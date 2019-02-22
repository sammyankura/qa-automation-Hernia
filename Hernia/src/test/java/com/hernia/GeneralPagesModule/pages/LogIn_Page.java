package com.hernia.GeneralPagesModule.pages;	

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

	public class LogIn_Page extends BasePage {

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		public LogIn_Page navigate_To(String enterEnvironmentName) {
			driver.get(enterEnvironmentName);
			System.out.println("Page Title: '" + driver.getTitle() + "'");
			String pageTitle = driver.getTitle();
			myLib.customWait(2);
			
			if (pageTitle.contains("MDL Online")) {
				myLib.softAssert(true);
			} else {
				myLib.softAssert(false);
				System.out.println("Site Title NOT VERIFIED!");
			}
			return this;
		}
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		public LogIn_Page log_Into_Application(String enterUsername, String enterPassword) {
			
			myLib.waitUntilElementVisible(By.xpath("//input[@id='user_email']"));
			
			try {				
								
				myLib.enterTextField(By.xpath("//input[@id='user_email']"), enterUsername);

				myLib.enterTextField(By.xpath("//input[@id='user_password']"), enterPassword);
				
				myLib.clickElement(By.name("commit"));
				
				myLib.customWait(2);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return this;
		}
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}