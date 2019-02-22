package com.hernia.utilities;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;

import com.hernia.GeneralPagesModule.pages.BlueprintDetails_Page;
import com.hernia.GeneralPagesModule.pages.BlueprintView_Page;
import com.hernia.GeneralPagesModule.pages.CreateNewPlaintiff_Page;
import com.hernia.GeneralPagesModule.pages.DocumentExchanges_Page;
import com.hernia.GeneralPagesModule.pages.ECF_Page;
import com.hernia.GeneralPagesModule.pages.General_Page;
import com.hernia.GeneralPagesModule.pages.LogIn_Page;
import com.hernia.GeneralPagesModule.pages.PlaintiffProfile_Page;
import com.hernia.GeneralPagesModule.pages.ReviewBlueprint_Page;
import com.hernia.GeneralPagesModule.pages.Search_Page;
import com.hernia.GeneralPagesModule.pages.ServeBluprint_Page;
import com.hernia.GeneralPagesModule.pages.SupportingDocumentsBlueprint_Page;

public class Constants extends Credentials{

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// QA URL
	public static final String HM_QA_URL = "https://ethicon-hm-qa.ankuracloud.net/";

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Excel file location
	public static final String ExcelFile = "src/test/resources/ExcelData.xlsx";
		
	public static final File jpg = new File("src/test/resources/ankura.jpg");

	public static final File PDF = new File("src/test/resources/sample.pdf");
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	// Test Failure Screenshots location
	public static final String Screenshots_Path = "Test_Failure_Screenshots/"; 
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Enter Random String
	public static String randomString = RandomStringUtils.randomAlphabetic(8);
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Instances of pages
	public static final LogIn_Page logInPage = new LogIn_Page();
	public static final Search_Page searchPage = new Search_Page();
	public static final CreateNewPlaintiff_Page createNewPlaintiffPage = new CreateNewPlaintiff_Page();
	public static final General_Page generalPage = new General_Page();
	public static final DocumentExchanges_Page documentExchangesPage = new DocumentExchanges_Page();
	public static final BlueprintView_Page blueprintViewPage = new BlueprintView_Page();
	public static final SupportingDocumentsBlueprint_Page supportingDocumentsBlueprintPage = new SupportingDocumentsBlueprint_Page();
	public static final ServeBluprint_Page serveBluprintPage = new ServeBluprint_Page();
	public static final PlaintiffProfile_Page plaintiffProfilePage = new PlaintiffProfile_Page();
	public static final ReviewBlueprint_Page reviewBlueprintPage = new ReviewBlueprint_Page();
	public static final BlueprintDetails_Page blueprintDetailsPage = new BlueprintDetails_Page();
	public static final ECF_Page ecfPage = new ECF_Page();
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}