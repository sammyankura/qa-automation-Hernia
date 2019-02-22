package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class DocumentExchanges_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page click_BlueprintType(String enterPlaintiffName , String enterBlueprintType){
		
		myLib.clickElement(By.xpath("//table//tbody//following-sibling::td[contains(.,'" + enterPlaintiffName + "')]//preceding-sibling::td//a[contains(.,'" + enterBlueprintType + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page click_PlaintiffName(String enterBlueprintType, String enterPlaintiffName){
			
		myLib.clickElement(By.xpath("//table//tbody//tr[contains(.,'" + enterBlueprintType + "')]//following-sibling::a[contains(.,'" + enterPlaintiffName + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page click_Action(String enterBlueprintType, String enterPlaintiffName, String selectReviewOrLinkPlaintiff){

		myLib.clickElement(By.xpath("//table//tbody//td[contains(.,'" + enterBlueprintType + "')]//following::td[contains(.,'" + enterPlaintiffName + "')]//following-sibling::td//a[contains(.,'" + selectReviewOrLinkPlaintiff + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page click_UnlinkedExchanges_Button(){

		myLib.clickElement(By.xpath("//div[@id='action_bar_container'][contains(.,'Unlinked Exchanges')]//a[@class='button']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public DocumentExchanges_Page click_MagnifyingGlass_Icon(){

		myLib.clickElement(By.xpath("//i[@class='fi-magnifying-glass']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page select_ServedBy(String enterServedBy){
		
		myLib.clickElement(By.xpath("//select[@id='from']//option[text()='" + enterServedBy + "']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_CaseNumber(String enterCaseNumber){
		
		myLib.enterTextField(By.id("case_number"), enterCaseNumber);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_FirstName(String enterFirstName){
		
		myLib.enterTextField(By.id("first_name"), enterFirstName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_LastName(String enterLastName){
		
		myLib.enterTextField(By.id("last_name"), enterLastName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page enter_RepresentingFirm(String enterRepresentingFirm){
		
		myLib.enterTextField(By.id("firm"), enterRepresentingFirm);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_RepresentingAttorney(String enterRepresentingAttorney){
		
		myLib.enterTextField(By.id("attorney"), enterRepresentingAttorney);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page select_ReviewStatus(String enterReviewStatus){
		
		myLib.clickElement(By.xpath("//select[@id='review_status']//option[text()='" + enterReviewStatus + "']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page enter_ServedOnOrAfter_Date(String enterServedOnOrAfterDate){
		
		myLib.enterTextField(By.id("served_on"), enterServedOnOrAfterDate);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page click_Search_Button(){

		myLib.clickElement(By.xpath("//input[@value ='Search' and @type='submit']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_FirstName_LinkPlaintiff_Flow(){

		myLib.clickElement(By.id("first_name"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page enter_LastName_LinkPlaintiff_Flow(){

		myLib.clickElement(By.id("last_name"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public DocumentExchanges_Page click_Search_Button_LinkPlaintiff_Flow(){

		myLib.clickElement(By.xpath("//input[@value='Search']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page select_Organization_LinkPlaintiff_Flow(String enterOrganizationName){

		myLib.clickElement(By.xpath("//select[@id='organization_id']//option[contians(.,'" + enterOrganizationName + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public DocumentExchanges_Page click_CreateNewPlaintiff_Button_LinkPlaintiff_Flow(){

		myLib.clickElement(By.xpath("//input[@value='Create New Plaintiff']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}
