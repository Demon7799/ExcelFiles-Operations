package demo.xml_operation;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicData 
{
	public static ArrayList<String> checkInput() 
	{
	    ArrayList<String> userData = new ArrayList<String>();
	    System.out.println("Please enter your data : ");
	    Scanner input = new Scanner(System.in);
	    while (true) {
	        String line = input.nextLine();
	        int lastIndex = line.length();
	        
	       // System.out.println("Last Index : "+line.charAt(lastIndex-1));
	       if(line.charAt(lastIndex-1)== '1')
	        {
	        	userData.add(line);
	        	break;
	        }
	        userData.add(line);
	        
	  
	    }
	    return userData;
	}
	
	public static void main(String[] args) 
	{
		    ArrayList<String> userData = checkInput();
		    System.out.printf("User Input Data:\n%s", String.join("", userData));
//		    System.out.println(userData);
		
	
	
	}

}
