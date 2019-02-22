package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class ECF_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public ECF_Page create_NewECF(){
		
		myLib.clickElement(By.xpath("//div[@id='action_bar_container']//span[text()='New ECF']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ECF_Page click_Search_Button(){
		
		myLib.clickElement(By.xpath("//form[@id='ecf_search']//input[@type='submit'][@value='Search']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ECF_Page enter_DocketNumber(String enterDocketNumber){

		myLib.enterTextField(By.id("q_docket_number_cont"), enterDocketNumber);
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public ECF_Page enter_Name(String enterName){

		myLib.enterTextField(By.id("q_name_cont"), enterName);
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public ECF_Page enter_Filer(String enterFiler){

		myLib.enterTextField(By.id("q_filer_cont"), enterFiler);
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	public ECF_Page enter_DateFiled(String enterDateFiled){

		myLib.enterTextField(By.id("q_date_filed_eq"), enterDateFiled);
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
