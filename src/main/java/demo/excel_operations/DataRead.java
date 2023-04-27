package demo.excel_operations;

//Java Program to Illustrate Reading
//Data to Excel File Using Apache POI

//Import statements
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Main class
public class DataRead {

	// Main driver method
	public static void main(String[] args) {

		// Try block to check for exceptions
		try {
			String filePath = "C:\\Users\\ACNadmin2\\Desktop\\Demon\\Eclipse-Wrokplace\\Excel_Operations\\ExcelFiles\\Sample.xls";
			// Reading file from local directory
			FileInputStream file = new FileInputStream(new File(filePath));

			// Create Workbook instance holding reference to
			// .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			// Till there is an element condition holds true
			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				// For each row, iterate through all the
				// columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// Checking the cell type and format
					// accordingly
					switch (cell.getCellType()) {

					// Case 1
					case NUMERIC:
						System.out.printf("%-15s",cell.getNumericCellValue());
						break;
					// Case 2
					case STRING:
						System.out.printf("%-15s",cell.getStringCellValue());
						break;
					}
				}

				System.out.println("");
			}

			// Closing file output streams
			file.close();
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			// Display the exception along with line number
			// using printStackTrace() method
			e.printStackTrace();
		}
	}
}
