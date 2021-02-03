package propertiesFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class ReadPropertiesFile {

	public static void main(String ... args) {
	
	
			
		       
				try
				{
					// check if file exists, if not it will throw FileNotFoundException
					if (!doesFileExist("C:\\\\Users\\\\aarav\\\\eclipse-workspace\\\\JavaFiles\\\\data\\\\dictionary.properties"))
					{
						throw new FileNotFoundException("File doesn't exist.");
					}
					
					/* if file exists we have to check do we have permission for reading file
						 and if it's not empty
					 */
					else 
					{
						File f = new File ("C:\\\\Users\\\\aarav\\\\eclipse-workspace\\\\JavaFiles\\\\data\\\\dictionary.properties");
						if (!f.canRead())
						{
							System.err.println("File exists but doesn't have permission for reading.");
							System.exit(1);
						}
						else if (f.length() == 0)
						{
							System.err.println("File exists but it's empty.");
							System.exit(1);
						}
						
						/* if file exists, we can read it and it's not empty 
							we will open file read words and theirs meanings 
						  	and print contents of a file.
						*/
						else
						{
							System.out.println("File exists and will be read by this program.");
							System.out.println();
							printDictionary(f);
						}			
							
					}
				}
				catch (FileNotFoundException e)
				{
					System.out.println(e.getMessage());
				}			
		    }

		/*****************************doesFileExist(String path)***********************************/	
		    //Method doesFileExist will return true if file exists, and if it's a regular file.
			public static boolean doesFileExist(String path) 
			{
				File file = new File(path);
				
				if (!file.exists() || !file.isFile())
				{
					return false;
				}
				else 
				{
					return true;
				}
			}
		/*****************************printDictionary(File f)***********************************/		
			// This method will print words and theirs meanings 	
			public static void printDictionary(File f) 
			{
				try
				{
					Scanner sc = new Scanner(f);
					String line;
					int i =1;

					while (sc.hasNextLine())
					{
						line = sc.nextLine();
		        
						String[] splitLine = line.split("-");
		       	 		String[] meaning = splitLine[1].split(",");
		        		System.out.println("Word" + i + ": " + splitLine[0].trim());
						i++;
				
		        		for(int j=0; j < meaning.length; j++)
						{
		            		System.out.println("Meaning" + (j + 1) + ": " + meaning[j].trim());
		        		}
				
						System.out.println();
					}
					sc.close();			
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
	 
			
		}
	
