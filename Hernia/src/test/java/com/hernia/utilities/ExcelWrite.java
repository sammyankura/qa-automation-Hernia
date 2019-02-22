package com.hernia.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	FileOutputStream fileOut;
	Workbook workbook;
	Sheet sheet;
	File src;
	FileInputStream fis;
	String data;
	Cell cell;

	public ExcelWrite(String filePath) {
		try {

			src = new File(Constants.ExcelFile);
			workbook = new XSSFWorkbook();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ExcelWrite writeData(String sheetName, int rowNum, int columnNum, String Result) {
		
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			sheet = workbook.createSheet(sheetName);
		}

		Row row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}

		Cell cell = row.getCell(columnNum);
		if (cell == null) {
			cell = row.createCell(columnNum);
			cell.setCellValue(Result);
		} else {
			cell.setCellValue(Result);
		}
		
		try {
			// Open the file to write the results
			FileOutputStream fileOut = new FileOutputStream(Constants.ExcelFile);

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*	
	@Test(priority = 1)
	public void create_Plaintiff(){
		
		writeData("testSheet", 1, 0, "test Result");
		
	}*/

}
