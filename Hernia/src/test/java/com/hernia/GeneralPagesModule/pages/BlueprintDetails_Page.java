package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;

import com.hernia.utilities.BasePage;

public class BlueprintDetails_Page extends BasePage{
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public BlueprintDetails_Page click_Button(String enterButtonName){
		
		myLib.clickElement(By.xpath("//div[@id='action_bar_container']/a[contains(.,'" + enterButtonName + "')]"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public BlueprintDetails_Page click_InternalNotes_Icon(){
		
		myLib.clickElement(By.xpath("//div[@class='shrink cell data-panel-buttons']//a[@title='Show Notes']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public BlueprintDetails_Page click_Deficiency_Icon(){
		
		myLib.clickElement(By.xpath("//div[@class='shrink cell data-panel-buttons']//a[@title='Show Deficiency Comment']"));
		
		return this;
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}
