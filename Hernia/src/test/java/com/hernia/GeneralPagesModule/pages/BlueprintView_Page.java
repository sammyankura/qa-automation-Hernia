package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hernia.utilities.BasePage;

public class BlueprintView_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public BlueprintView_Page click_Button(String enterButtonName) {
		
		myLib.waitUntilElementVisible(By.xpath("//div[@id='action_bar_container']//a[contains(.,'" + enterButtonName + "')]"));
		
		myLib.clickElement(By.xpath("//div[@id='action_bar_container']//a[contains(.,'" + enterButtonName + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public BlueprintView_Page click_AddDocument_Button_SupportingDocuments_Panel() {
		
		myLib.clickElement(By.id("add_documents"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public BlueprintView_Page upload_SupportingDocument_SupportingDocuments_Panel(String enterFileName) {
		
		WebElement chooseFileButton = driver.findElement(By.id("uploaded_document"));
		chooseFileButton.sendKeys(enterFileName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public BlueprintView_Page click_UploadDocument_Button_SupportingDocuments_Panel() {
		
		myLib.clickElement(By.id("upload"));
		
		myLib.waitUntilElementVisible(By.xpath("//table[@id='sup_docs_table']//td[2]"));

		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
