package simplilearnfinalproject;

import java.io.*;
import java.util.*;

public class LockedMe
{
	//File path
	static final String projectFilesPath = "C:\\Users\\Supraja Boga\\Downloads\\AllFiles";
	
	/**
	 * This method will display the menu for end-user
	 */
	public static void displayMenu()
	{
		System.out.println("**************************************************");
		System.out.println("\tWelcome to LockedMe.com secure app");
		System.out.println("\tDeveloped by Supraja Boga");
		System.out.println("**************************************************");
		System.out.println("\t1.Display all files");
		System.out.println("\t2.Add a new file");
		System.out.println("\t3.Delete a file");
		System.out.println("\t4.Search a file");
		System.out.println("\t5.Exit");
		System.out.println("**************************************************");
	}
	
	/**
	 * This method will retrieve all the files
	 */
	public static void getAllFiles()
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length > 0)
		{
			System.out.println("FILES LIST IS BELOW");
			for(var l : listOfFiles)
				System.out.println(l.getName());
		}
		else
			System.out.println("The folder is empty");
	}
	
	/**
	 * This method will add a file
	 */
	public static void addFile()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter filename");
			String fileName = sc.nextLine();
			
			System.out.println("Enter how many lines in the file:");
			int linesCount = Integer.parseInt(sc.nextLine());
			
			FileWriter fw = new FileWriter(projectFilesPath + "\\" + fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter file line");
				fw.write(sc.nextLine());
			}
			System.out.println("File created successfully");
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println("Some error occured");
		}
	}
	
	/**
	 *This method will check if the file exists or not in the folder
	 * @param fileName
	 * @return true or false
	 */
	public static boolean checkFileExists(String fileName)
	{
		//Store all files into a list(to achieve case-sensitive)
		ArrayList<String> allFileNames = new ArrayList<String>();
		
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length > 0)
		{
			for(var l : listOfFiles)
				allFileNames.add(l.getName());
		}
		else
			System.out.println("The folder is empty");
		
		return allFileNames.contains(fileName);
	}
	
	/**
	 * This method will delete a file
	 */
	public static void deleteFile()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter filename to be deleted");
			String fileName = sc.nextLine();
			
			File f = new File(projectFilesPath + "\\" + fileName);
			
			if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File deleted successfully");
			}
			else
				System.out.println("File not found");
		}
		catch(Exception e)
		{
			System.out.println("Unable to delete. Please contact admin@test.com");
		}
	}
	
	/**
	 * This method will search a file
	 */
	public static void searchFiles()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter filename to be searched");
			String fileName = sc.nextLine();
			
			File f = new File(projectFilesPath + "\\" + fileName);
			
			if(checkFileExists(fileName))
				System.out.println("File is available");
			else
				System.out.println("File is not available");
		}
		catch(Exception e)
		{
			System.out.println("Unable to get the file. Please contact admin@test.com");
		}
	}
}
