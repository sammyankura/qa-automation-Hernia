package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;
import com.hernia.utilities.BasePage;

public class ServeBluprint_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ServeBluprint_Page click_Serve_Button() {

		myLib.waitUntilElementVisible(By.xpath("//input[@value='Serve' and @type='submit']"));
	
		myLib.clickElement(By.xpath("//input[@value='Serve' and @type='submit']"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ServeBluprint_Page click_Cancel_Button() {

		myLib.waitUntilElementVisible(By.xpath("//form//a[text()='Cancel']"));
	
		myLib.clickElement(By.xpath("//form//a[text()='Cancel']"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ServeBluprint_Page enter_Comments(String enterComments){
		
		myLib.waitUntilElementVisible(By.xpath("//textarea[@name = 'submit_comments']"));
		
		myLib.enterTextField(By.xpath("//textarea[@name = 'submit_comments']"), enterComments);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}
