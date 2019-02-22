package com.hernia.GeneralPagesModule.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hernia.utilities.BasePage;

public class ReviewBlueprint_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ReviewBlueprint_Page click_CompleteReview(){
		
		myLib.clickElement(By.xpath("//input[@value = 'Complete Review' and @type = 'submit']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ReviewBlueprint_Page click_Approve(){
		
		myLib.handleCheckBox(By.id("forms_exchange_review_approve_or_deficient_approve"), true);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ReviewBlueprint_Page click_Deficient(){
		
		myLib.handleCheckBox(By.id("forms_exchange_review_approve_or_deficient_deficient"), true);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ReviewBlueprint_Page enter_Deficiency_Reason(String enterDeficiencyReason){
		
		myLib.enterTextField(By.xpath("//textarea[@id='forms_exchange_review_deficient_reason']"), enterDeficiencyReason);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ReviewBlueprint_Page upload_DeficiencyLetter(File enterFileName) {
		
		WebElement chooseFileButton = driver.findElement(By.id("forms_exchange_review_deficiency_letter"));
		chooseFileButton.sendKeys(enterFileName.getAbsolutePath());

	return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ReviewBlueprint_Page select_Deficiency(String selectDeficiencyCode){
		
		myLib.waitUntilElementVisible(By.xpath("//div[@id='deficiency-container']"));
		
//		myLib.selectDropDownMenuValue(By.xpath("//div[@id='deficiency-container']//option[contains(.,'" + enterDeficiencyCode +  "')]"));
		
		myLib.bootStrapDropDown(By.xpath("//div[@id='deficiency-container']//option"), selectDeficiencyCode);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
