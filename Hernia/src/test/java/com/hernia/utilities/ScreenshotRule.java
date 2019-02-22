
package com.hernia.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotRule {
	
	public static String getRandomString() {
		DateFormat dateFormat = new SimpleDateFormat("E, M-d-y '@' h:mm a z");

        Date date = new Date();
		StringBuilder sb = new StringBuilder();
		sb.append(dateFormat.format(date.getTime()));

		return sb.toString();
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static String takeScreenshot(WebDriver driver, String fileName) {

		try {
			fileName = getRandomString() + ".png";
			String directory = Constants.Screenshots_Path;
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(sourceFile, new File(directory + fileName));
			String destination = directory + fileName;
			return destination;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
}