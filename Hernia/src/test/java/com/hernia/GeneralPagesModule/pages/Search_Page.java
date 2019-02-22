package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class Search_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page click_NewPlaintiff_Button(){
		
		myLib.clickElement(By.xpath("//div[@id='action_bar_container']//a[contains(.,'New Plaintiff')]"));

		return this;
		}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page click_Search_Button(){
		
		myLib.clickElement(By.xpath("//div[@class='grid-y grid-frame']//input[@type='submit' and @value='Search']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page select_Form_Type(String enterFormType){
		
		myLib.clickElement(By.xpath("//div[@class='grid-x grid-margin-x']//div[@class='search-checkboxes']//label[text()='" + enterFormType + "']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page select_Form_Status(String enterFormStatus){
		
		myLib.clickElement(By.xpath("//div[@class='grid-x grid-margin-x']//div[@class='search-checkboxes']//label[text()='" + enterFormStatus + "']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page enter_FirstName_SearchBox(String enterFirstName){
		
		myLib.enterTextField(By.xpath("//form[contains(@action,'/profiles/searches')]//input[@name ='profile_search[first_name]']"), enterFirstName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page enter_LastName_SearchBox(String enterLastName){
		
		myLib.enterTextField(By.xpath("//form[contains(@action,'/profiles/searches')]//input[@name ='profile_search[last_name]']"), enterLastName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page enter_MDLOID_SearchBox(String enterMDLOID){
		
		myLib.enterTextField(By.xpath("//form[contains(@action,'/profiles/searches')]//input[@name ='profile_search[id]']"), enterMDLOID);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page enter_FirmFileNumber_SearchBox(String enterLastName){
		
		myLib.enterTextField(By.xpath("//form[contains(@action,'/profiles/searches')]//input[@name ='profile_search[reference_number]']"), enterLastName);
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page selectTag_TaggedWith_DropDown(String enterTagName){
		
		myLib.clickElement(By.xpath("//select[@id='profile_search_tags']"));
		
		myLib.clickElement(By.xpath("//ul[@id='select2-profile_search_tags-results']//li[contains(.,\"" + enterTagName + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
	public Search_Page selectTagMode_RadioButton(String enterTagMode){
				
		myLib.clickElement(By.xpath("//div[@id='tag_mode_container']//label[contains(.,\"" + enterTagMode + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page selectTag_NotTaggedWith_DropDown(String enterTagName){
		
		myLib.clickElement(By.xpath("//select[@id='profile_search_excluded_tags']"));
		
		myLib.clickElement(By.xpath("//ul[@id='select2-profile_search_excluded_tags-results']//li[contains(.,\"" + enterTagName + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page select_FormType(String enterFormAbbreviation){

		myLib.clickElement(By.xpath("//form[@id='profile_search_form']/div[3]//div[@class='search-checkboxes']//label[contains(.,\"" + enterFormAbbreviation + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page select_FormStatus(String enterFormStatus){

		myLib.clickElement(By.xpath("//form[@id='profile_search_form']/div[3]//div[@class='search-checkboxes']//label[contains(.,\"" + enterFormStatus + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page select_ResultsView(String enterResultsView){

		myLib.clickElement(By.xpath("//ul[@class='page-toggles']//a[contains(.,\"" + enterResultsView + "\")]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public Search_Page click_PlaintiffName_PlaintiffsResults_SearchResults(String enterPlaintiffName){
		
		myLib.clickElement(By.xpath("//div[@id='profile-results']//tr//a[contains(.,\"" + enterPlaintiffName + "\")]"));
				
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Search_Page click_PlaintiffName_FormsResults_SearchResults(String enterBlueprintName, String enterPlaintiffName){
		
		myLib.clickElement(By.xpath("//div[@id='blueprint-results']//tr//td[contains(.,\"" + enterBlueprintName + "\")]//preceding-sibling::td/a[contains(.,\"" + enterPlaintiffName + "\")]"));
				
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
}