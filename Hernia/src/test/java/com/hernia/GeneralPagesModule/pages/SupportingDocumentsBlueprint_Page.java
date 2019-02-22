package com.hernia.GeneralPagesModule.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hernia.utilities.BasePage;

public class SupportingDocumentsBlueprint_Page extends BasePage {
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public SupportingDocumentsBlueprint_Page select_DocumentType(String enterPageName) {

		String firstPartXpath = "//select[contains(@name,'supporting_document[supporting_document_type_id]')]//option[contains(.,'";
		String secondPartXpath = "')]";

		myLib.clickElement(By.xpath(firstPartXpath + enterPageName + secondPartXpath));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public SupportingDocumentsBlueprint_Page enter_DocumentName(String enterDocumentName) {

		myLib.enterTextField(By.xpath("//input[contains(@name,'supporting_document[name]')]"), enterDocumentName);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public SupportingDocumentsBlueprint_Page enter_Description(String enterDescription) {

		myLib.enterTextField(By.xpath("//textarea[contains(@name,'supporting_document[description]')]"),
				enterDescription);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public SupportingDocumentsBlueprint_Page upload_File(File enterFileName) {
			
			WebElement browseButton = driver.findElement(By.id("uploaded_document"));
			browseButton.sendKeys(enterFileName.getAbsolutePath());

		return this;
	}	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public SupportingDocumentsBlueprint_Page clickupload_Button() {
		
		myLib.clickElement(By.xpath("//form[@id='supporting_documents_form']//input[@value='Upload']"));
		
		myLib.waitUntilElementVisible(By.xpath("//table[@id='sup_docs_table']//td[2]"));
		
		if(driver.findElements(By.xpath("//table[@id='sup_docs_table']//td[2]")).size() != 0){
			System.out.println("File uploaded successfully!");
			}else{
			System.out.println("File was not uploaded!");
			}
		
		return this;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
