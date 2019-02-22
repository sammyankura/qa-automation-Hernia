package com.hernia.GeneralPagesModule.pages;

import org.openqa.selenium.By;
import com.hernia.utilities.BasePage;

public class General_Page extends BasePage {
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public General_Page navigate_To(String enterPageName) {

		myLib.waitUntilElementVisible(By.xpath("//ul[@class='medium-vertical menu icons icon-top']//li[normalize-space() = '" + enterPageName + "']"));
		
		myLib.clickElement(By.xpath("//ul[@class='medium-vertical menu icons icon-top']//li[normalize-space() = '" + enterPageName + "']"));
		
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public General_Page navigateTo_Breadcrumb(String enterBreadcrumbName) {

		myLib.clickElement(
				By.xpath("//ul[@class='breadcrumbs secondary']//li//a[contains(.,'" + enterBreadcrumbName + "')]"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public General_Page click_SignOut_Button() {

		myLib.clickElement(By.xpath("//a[@title='Sign out']"));

		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public General_Page switchToSilo(String enterSiloName) {

		myLib.clickElement(By.xpath("//div[@class='grid-y grid-frame']//button[@data-toggle='silo_list']"));

		myLib.clickElement(By.xpath("//div[@id='silo_list']/a[contains(.,'" + enterSiloName + "')]"));
		return this;
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
