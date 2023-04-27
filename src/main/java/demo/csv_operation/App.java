package demo.csv_operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class App {
	public static void main(String[] args) throws IOException 
	{
		String filePath = "C:\\Users\\ACNadmin2\\Desktop\\Demon\\Eclipse-Wrokplace\\Excel_Operations\\ExcelFiles\\Sample.csv";

		FileWriter fileWriter = new FileWriter(new File(filePath));

		CSVWriter csvWriter = new CSVWriter(fileWriter);

		Scanner sc = new Scanner(System.in);

		ArrayList<String[]> data = new ArrayList<String[]>();

		String[] header = {"Name","Series","Kills"};
		data.add(0,header);
		
		System.out.println("Enter no of rows");
		int noOfRow = Integer.parseInt(sc.nextLine());
		
		String item[];
		
		for(int i=1;i<=noOfRow;i++)
		{
			item = new String[noOfRow+1];
			
			for(int j=0;j<header.length;j++)
			{
				System.out.println("Enter "+header[j]+" : ");
				item[j] = sc.nextLine();
			}
			data.add(item);
		}
		System.out.println("Done :)");
		csvWriter.writeAll(data);
		csvWriter.close();
	}

}
