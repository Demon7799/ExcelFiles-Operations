package demo.excel_operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class DataWrite 
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> header = new ArrayList<String>();
		header.add("Name");
		header.add("Series");
		header.add("Kills");
		
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(); 
		data.add(header);
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter No. of Rows : ");
		int noOfRows = Integer.parseInt(sc.nextLine());
		
		for(int i=1;i<=noOfRows;i++)
		{
			data.add(i,new ArrayList<String>());
			for(int j=0;j<header.size();j++)
			{
				System.out.println("Enter "+header.get(j)+" : ");
				System.out.println();
				data.get(i).add(j,sc.nextLine());
			}
		}
		
		
		System.out.println(data);
		
		
		
		
		
//		
//		
//		data.add(1,new ArrayList<String>());
//		data.get(1).add(0,"Ryumen Sukuna");
//		data.get(1).add(1,"Jujutsu Kaisen");
//		data.get(1).add(2,"999999999");
//		
//		data.add(2,new ArrayList<String>());
//		data.get(2).add(0,"Muzan Kibutsuji");
//		data.get(2).add(1,"Demon Slayer");
//		data.get(2).add(2,"100000000");
//		
//		data.add(3,new ArrayList<String>());
//		data.get(3).add(0,"Meliodas");
//		data.get(3).add(1,"The Seven Deadly Sins");
//		data.get(3).add(2,"900000000");
		
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		HSSFSheet sheet = workBook.createSheet("Demons");
		
		
		for(int i=0;i<data.size();i++)
		{
			sheet.createRow(i);
			for(int j=0;j<header.size();j++)
			{
				sheet.getRow(i).createCell(j).setCellValue(data.get(i).get(j));
			}
		}
		
		CellStyle style = workBook.createCellStyle();
		// style.setFillForegroundColor(HSSFColor.DARK_YELLOW.index);
		style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		style.setFillPattern(FillPatternType.THICK_BACKWARD_DIAG);
		
		
		String filePath = "C:\\Users\\ACNadmin2\\Desktop\\Demon\\Eclipse-Wrokplace\\Excel_Operations\\ExcelFiles\\Excel_File.xls";
		File file = new File(filePath);
		
		workBook.write(file);
		workBook.close();
		
	}

}

