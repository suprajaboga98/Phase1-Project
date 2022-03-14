package simplilearnfinalproject;

import java.util.*;

public class ClientApp
{
	public static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		int ch;
		do
		{
			LockedMe.displayMenu();
			System.out.println("Enter your choice: ");
			ch = obj.nextInt();
			
			switch(ch)
			{
			case 1 : LockedMe.getAllFiles();
					 break;
			case 2 : LockedMe.addFile();
			         break;
			case 3 : LockedMe.deleteFile();
			         break;
			case 4 : LockedMe.searchFiles();
			         break;
			case 5 : System.exit(0);
				     break;
		    default : System.out.println("Invalid option");
		    		  break;
			}
		}while(ch>0);
		
		obj.nextLine();
	}
}
