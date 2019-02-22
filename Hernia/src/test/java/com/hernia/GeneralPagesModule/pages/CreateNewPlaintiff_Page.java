package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class CreateNewPlaintiff_Page extends BasePage {
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public CreateNewPlaintiff_Page enter_RepresentingAttorneyFirmName_Field_RepresentationSection(String enterRepresentingAttorneyFirmName){		
		
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[firm_name]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), enterRepresentingAttorneyFirmName);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_RepresentingAttorney_Field_RepresentationSection(String enterRepresentingAttorney){
		
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[representing_attorney]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), enterRepresentingAttorney);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_RepresentingAttorneyEmail_Field_RepresentationSection(String enterRepresentingAttorneyEmail){
		
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[representing_attorney_email]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), enterRepresentingAttorneyEmail);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));	
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_FirmFileNumber_Field_DetailsSection(String enterFirmFileNumber){
		
		myLib.enterTextField(By.xpath("//form//label[contains(.,'Firm File Number')]//following-sibling::input"), enterFirmFileNumber);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_CaseNumber_Field_DetailsSection(){
		
		String caseNumber = "Automation - " + randomString;
		
		System.out.println(caseNumber);
				
		myLib.enterTextField(By.xpath("//form//label[contains(.,'Case Number(s)')]//following-sibling::input"), caseNumber);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_AddedToMDL_Field_DetailsSection(String enterDate){
		
		myLib.enterTextField(By.xpath("//form//label[contains(.,'Added to MDL')]//following-sibling::input"), enterDate);

		myLib.clickTab(By.xpath("//form//label[contains(.,'Added to MDL')]//following-sibling::input"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  enter_FirstName_Field_PlaintiffSection(){
		
		String firstName = "Automation - " + randomString;
		
		System.out.println(firstName);
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'First Name')]//following-sibling::input"), firstName);		
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_MiddleName_Field_PlaintiffSection(String enterMiddleName){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Middle Name')]//following-sibling::input"), enterMiddleName);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_LastName_Field_PlaintiffSection(){
				
		String lastName = "Automation - " + randomString;
		
		System.out.println(lastName);
				
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Last Name')]//following-sibling::input"), lastName);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page select_Suffix_Dropdown_PlaintiffSection(String enterSuffixSelection){
				
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[suffix]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-dropdown select2-dropdown--above']//input[@class='select2-search__field']"), enterSuffixSelection);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-dropdown select2-dropdown--above']//input[@class='select2-search__field']"));
				
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_DateOfBirth_Field_PlaintiffSection(String enterDOB){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Date of Birth')]//following-sibling::input"), enterDOB);

		myLib.clickTab(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Date of Birth')]//following-sibling::input"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_Email_Field_PlaintiffSection(String enterEmail){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Email')]//following-sibling::input"), enterEmail);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_Phone_Field_PlaintiffSection(String enterPhone){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Plaintiff')]//following-sibling::div//label[contains(.,'Phone')]//following-sibling::input"), enterPhone);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public CreateNewPlaintiff_Page  enter_FirstName_Field_AliasSection(String enterFirstName){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Alias')]//following-sibling::div//label[contains(.,'First Name')]//following-sibling::input"), enterFirstName);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_MiddleName_Field_AliasSection(String enterMiddleName){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Alias')]//following-sibling::div//label[contains(.,'Middle Name')]//following-sibling::input"), enterMiddleName);

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_LastName_Field_AliasSection(String enterLastName){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Alias')]//following-sibling::div//label[contains(.,'Last Name')]//following-sibling::input"), enterLastName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page select_Suffix_Dropdown_AliasSection(String enterSuffixSelection){
				
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[alias_suffix]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), enterSuffixSelection);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
				
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  enter_StreetAddress_Field_AddressSection(String enterStreetAddress){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Address')]//following-sibling::div//label[contains(.,'Street Address')]//following-sibling::input"), enterStreetAddress);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  enter_City_Field_AddressSection(String enterCity){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Address')]//following-sibling::div//label[contains(.,'City')]//following-sibling::input"), enterCity);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  select_State_Field_AddressSection(String selectState){
		
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[state]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), selectState);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));	
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  enter_PostalCode_Field_AddressSection(String enterPostalCode){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Address')]//following-sibling::div//label[contains(.,'Postal Code')]//following-sibling::input"), enterPostalCode);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page  select_Country_Field_AddressSection(String selectCountry){
		
		myLib.clickElement(By.xpath("//select[@name='plaintiff_profile[country]']//following-sibling::span//span[@class='select2-selection select2-selection--single']"));
		
		myLib.enterTextField(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"), selectCountry);
		
		myLib.clickEnter(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));	
				
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page enter_OtherContactEmailAddresses_Field_NotificationsSection(String enterOtherContactEmailAddresses){
		
		myLib.enterTextField(By.xpath("//form//legend[contains(.,'Notifications')]//following-sibling::div//label[contains(.,'Other Contact Email Addresses')]//following-sibling::textarea"), enterOtherContactEmailAddresses);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page click_SaveChanges_Button(){
		
		myLib.clickElement(By.xpath("//form//input[@value='Save Changes']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public CreateNewPlaintiff_Page click_Cancel_Button(){
		
		myLib.clickElement(By.xpath("//form//a[text() ='Cancel']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
