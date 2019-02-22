package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class PlaintiffProfile_Page extends BasePage {
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page copyMDLOID_PlaintiffSilo() {
		
			String profile_MDLOID = driver.findElement(By.xpath("//div[@class='profile-numbers']//h3[contains(.,'MDLO ID')]")).getText();
			String MDLOID = profile_MDLOID.substring(9);
			System.out.println("MDLO ID: " + MDLOID);
			excelWrite.writeData("Plaintiff Info", 1, 0, MDLOID);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page copyMDLOID_DefenseSilo() {
		
		String profile_MDLOID = driver.findElement(By.xpath("//div[@class='profile-numbers']//h3[contains(.,'MDLO ID')]")).getText();
		System.out.println(profile_MDLOID);
		
		String MDLOID = profile_MDLOID.substring(9);
		System.out.println(MDLOID);
		excelWrite.writeData("Plaintiff Info", 5, 0, MDLOID);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page copyCaseNumber_PlaintiffSilo() {
		
		String profile_CaseNumber = driver.findElement(By.xpath("//div[@class='profile-numbers']//h3[contains(.,'Case Number')]")).getText();
		String CaseNumber = profile_CaseNumber.substring(16);
		System.out.println("Case Number: " + CaseNumber);
		excelWrite.writeData("Plaintiff Info", 1, 1, CaseNumber);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page copyFirstName_PlaintiffSilo() {
		
		String profile_FirstName = driver.findElement(By.xpath("//div[@class=' content auto cell cell-block-y']/h1")).getText();
		String firstName = profile_FirstName.substring(0, 21);
		System.out.println("First Name: " + firstName);
		excelWrite.writeData("Plaintiff Info", 1, 2, firstName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page copyLastName_PlaintiffSilo() {
		
		String profile_LastName = driver.findElement(By.xpath("//div[@class=' content auto cell cell-block-y']/h1")).getText();
		String lastName = profile_LastName.substring(22, 43);
		System.out.println("Last Name: " + lastName);
		excelWrite.writeData("Plaintiff Info", 1, 3, lastName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page click_Edit_Plaintiff() {

		myLib.clickElement(By.xpath("//a[text()='Edit']"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page add_Tag(String enterTagName) {

		myLib.clickElement(By.xpath("//span[@id='select2-profile_tag_list-container']"));
		
		myLib.clickElement(By.xpath("//ul[@id='select2-profile_tag_list-results']//li[contains(.,'" + enterTagName + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page remove_Tag(String enterTagName) {
		
		myLib.clickElement(By.xpath("//div[@id='tag_container']/ul[@class='tags no-bullet']/li[contains(.,'" + enterTagName + "')]//i"));
		
		myLib.customWait(1);
		driver.switchTo().alert().accept();

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page click_BlueprintName_Link_FormsRequiringService_Section(String enterBlueprintName) {

		myLib.waitUntilElementVisible(By.xpath("//table[@id='profile_servable_blueprints']//td[1]"));
		
		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']//td[1][contains(.,'" + enterBlueprintName + "')]/a"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page verify_Blueprint_Status_FormsRequiringService_Section(String enterBlueprintName, String enterStatus) {
		
		myLib.waitUntilElementVisible(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[2]"));

//		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[contains(.,'"
//				+ enterBlueprintName + "')]/following-sibling::td[1][contains(.,'" + enterStatus + "')]"));
		
		String blueprintStatus = driver.findElement(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[contains(.,'"
				+ enterBlueprintName + "')]/following-sibling::td[1][contains(.,'" + enterStatus + "')]")).getText();
		
		if(blueprintStatus.contains(enterStatus)) {
			myLib.softAssert(true);
			System.out.println("The current Blueprint Status is:" + "\"" + blueprintStatus + "\"" + ". This is the expected result!");
		}else {
			myLib.softAssert(false);
			System.out.println("The current Blueprint Status is:" + "\"" + blueprintStatus + "\"" + ". This is the NOT the expected result!");
		}
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page verify_Blueprint_ExtensionStatus_FormsRequiringService_Section(String enterBlueprintName, String enterStatus) {

		myLib.waitUntilElementVisible(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[3]"));

		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[contains(.,'"
				+ enterBlueprintName + "')]/following-sibling::td[2][contains(.,'" + enterStatus + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page verify_Blueprint_EstDueDate_FormsRequiringService_Section(String enterBlueprintName, String enterEstDueDate) {

		myLib.waitUntilElementVisible(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[4]"));

		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']/tbody//td[contains(.,'"
				+ enterBlueprintName + "')]/following-sibling::td[3][contains(.,'" + enterEstDueDate + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page click_Action_ToPerformOnBlueprint_FormsRequiringService_Section(String enterBlueprintName, String enterAction) {

		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']//td[contains(.,'" + enterBlueprintName
				+ "')]//following-sibling::td//a[contains(.,'" + enterAction + "')]"));

		if (enterAction.contains("Amend")) {
			myLib.customWait(1);
			driver.switchTo().alert().accept();
		} else {
			myLib.customWait(1);
		}
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page click_Download_BlueprintPDF_FormsRequiringService_Section(String enterBlueprintName) {

		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']//td[contains(.,'" + enterBlueprintName
				+ "')]//following-sibling::td//a[@title='Download the document']"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page requestExtension(String enterBlueprintName){
	
		myLib.hoverOverElement(By.xpath("//a[@class='dropdown small button'][contains(.,'Request Extension')]"));
		
		myLib.waitUntilElementVisible(By.xpath("//table[@id='profile_servable_blueprints']//li[@aria-label=' Request Extension']/ul//a"));
		
		myLib.clickElement(By.xpath("//table[@id='profile_servable_blueprints']//li[@aria-label=' Request Extension']/ul//a[contains(.,'" + enterBlueprintName + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page click_BlueprintName_Link_Forms_PrivateToPlaintiffsCounsel_Section(String enterBlueprintName) {

		myLib.clickElement(By.xpath("//table[@id='profile_unservable_blueprints']//td[1][contains(.,'" + enterBlueprintName + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public PlaintiffProfile_Page click_Action_ToPerformOnBlueprint_PrivateToPlaintiffsCounsel_Section(String enterBlueprintName, String enterAction) {

		myLib.clickElement(By.xpath("//table[@id='profile_unservable_blueprints']//td[contains(.,'" + enterBlueprintName
				+ "')]//following-sibling::td//a[contains(.,'" + enterAction + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public PlaintiffProfile_Page verify_Blueprint_SharedWithPlaintiffLeadership_Date_PrivateToPlaintiffsCounsel_Section(String enterBlueprintName, String enterStatus) {

		myLib.clickElement(By.xpath("//table[@id='profile_unservable_blueprints']/tbody//td[contains(.,'"
				+ enterBlueprintName + "')]/following-sibling::td[2][contains(.,'" + enterStatus + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
