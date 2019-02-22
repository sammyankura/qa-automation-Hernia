
package com.hernia.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	Workbook wb;
	Sheet Credentials;
	Sheet sheet;
	File src;
	FileInputStream fis;
	String data;
	Cell cell;

	public static ExcelRead excel = new ExcelRead(Constants.ExcelFile);
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ExcelRead(String filePath) {
		try {
			src = new File(Constants.ExcelFile);
			fis = new FileInputStream(src);
//			ZipSecureFile.setMinInflateRatio(-1.0d); 
			wb = new XSSFWorkbook(fis);
			wb = WorkbookFactory.create(new FileInputStream(src));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public String getData(int sheetNumber, int rowNum, int columnNum) {

		try {
			sheet = wb.getSheetAt(sheetNumber);
			data = sheet.getRow(rowNum).getCell(columnNum).toString();

			wb.close();
		} catch (IOException e) {
			e.getMessage();
		}

		return data;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}