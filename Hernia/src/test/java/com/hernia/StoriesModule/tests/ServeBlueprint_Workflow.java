package com.hernia.StoriesModule.tests;


import org.testng.annotations.Test;

import com.hernia.utilities.BasePage;

public class ServeBlueprint_Workflow extends BasePage{

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@Test(priority = 1)
	public void create_Plaintiff(){ 
		
		logInPage.navigate_To(HM_QA_URL);
		logInPage.log_Into_Application(Plaintiff_UserName, Plaintiff_Password);
		generalPage.navigate_To("Plaintiffs");
		searchPage.click_NewPlaintiff_Button();
		createNewPlaintiffPage.enter_RepresentingAttorneyFirmName_Field_RepresentationSection("Adam Law");
		createNewPlaintiffPage.enter_RepresentingAttorney_Field_RepresentationSection("Adam");
		createNewPlaintiffPage.enter_RepresentingAttorneyEmail_Field_RepresentationSection("automationankura@gmail.com");
		createNewPlaintiffPage.enter_FirstName_Field_PlaintiffSection();
		createNewPlaintiffPage.enter_LastName_Field_PlaintiffSection();
		createNewPlaintiffPage.enter_CaseNumber_Field_DetailsSection();
		createNewPlaintiffPage.click_SaveChanges_Button();
		plaintiffProfilePage.copyFirstName_PlaintiffSilo();
		plaintiffProfilePage.copyLastName_PlaintiffSilo();
		plaintiffProfilePage.copyMDLOID_PlaintiffSilo();
		plaintiffProfilePage.copyCaseNumber_PlaintiffSilo();	
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@Test(priority = 2)
	public void serve_Blueprint_To_Opposing_Counsel_And_Mark_Blueprint_Deficient(){
	
		logInPage.navigate_To(HM_QA_URL);
		logInPage.log_Into_Application(Plaintiff_UserName, Plaintiff_Password);
		generalPage.navigate_To("Plaintiffs");
		searchPage.enter_FirstName_SearchBox(excelRead.getData(0, 1, 2));
		searchPage.enter_LastName_SearchBox(excelRead.getData(0, 1, 3));
		searchPage.enter_MDLOID_SearchBox(excelRead.getData(0, 1, 0));
		searchPage.click_Search_Button();
		searchPage.click_PlaintiffName_PlaintiffsResults_SearchResults(excelRead.getData(0, 1, 2));
		plaintiffProfilePage.click_BlueprintName_Link_FormsRequiringService_Section("PPF - Authorizations");
		blueprintDetailsPage.click_Button("Start");
		blueprintDetailsPage.click_Button("Save");	
		blueprintDetailsPage.click_Button("Supporting Documents");
		supportingDocumentsBlueprintPage.upload_File(PDF);
		supportingDocumentsBlueprintPage.clickupload_Button();
		generalPage.navigateTo_Breadcrumb("PPF - Authorizations");
		blueprintViewPage.click_Button("Generate PDF");
		blueprintViewPage.click_Button("Serve");
		serveBluprintPage.click_Serve_Button();
		generalPage.click_SignOut_Button();
		
		logInPage.log_Into_Application(Defense_UserName, Defense_Password);
		generalPage.navigate_To("Document Exchanges");
		documentExchangesPage.select_ServedBy("Plaintiff");
		documentExchangesPage.enter_CaseNumber(excelRead.getData(0, 1, 1));
		documentExchangesPage.enter_FirstName(excelRead.getData(0, 1, 2));
		documentExchangesPage.enter_LastName(excelRead.getData(0, 1, 3));
		documentExchangesPage.click_Search_Button();
		documentExchangesPage.click_Action("PPF - Authorizations", excelRead.getData(0, 1, 2), "Link Plaintiff");
		documentExchangesPage.click_CreateNewPlaintiff_Button_LinkPlaintiff_Flow();
		plaintiffProfilePage.click_Action_ToPerformOnBlueprint_FormsRequiringService_Section("PPF - Authorizations", "Review");
		reviewBlueprintPage.click_Deficient();
		reviewBlueprintPage.enter_Deficiency_Reason("Missing Documents");
		reviewBlueprintPage.upload_DeficiencyLetter(PDF);
		reviewBlueprintPage.select_Deficiency("P001 - Plaintiff Deficiency Code");
		reviewBlueprintPage.click_CompleteReview();
		plaintiffProfilePage.verify_Blueprint_Status_FormsRequiringService_Section("PPF - Authorizations", "Deficient");
		generalPage.click_SignOut_Button();
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	@Test(priority = 3)
	public void reserve_Blueprint_To_Opposing_Counsel_And_Approve_Blueprint(){
		logInPage.navigate_To(HM_QA_URL);
		logInPage.log_Into_Application(Plaintiff_UserName, Plaintiff_Password);
		generalPage.navigate_To("Plaintiffs");
		searchPage.enter_MDLOID_SearchBox(excelRead.getData(0, 1, 0));
		searchPage.click_Search_Button();
		searchPage.click_PlaintiffName_PlaintiffsResults_SearchResults(excelRead.getData(0, 1, 2));
		plaintiffProfilePage.click_Action_ToPerformOnBlueprint_FormsRequiringService_Section("PPF - Authorizations", "Edit");
		blueprintDetailsPage.click_Button("Save");	
		blueprintViewPage.click_Button("Generate PDF");
		blueprintViewPage.click_Button("Serve");
		serveBluprintPage.click_Serve_Button();
		generalPage.click_SignOut_Button();
		
		logInPage.log_Into_Application(Defense_UserName, Defense_Password);
		generalPage.navigate_To("Plaintiffs");
		searchPage.enter_FirstName_SearchBox(excelRead.getData(0, 1, 2));
		searchPage.enter_LastName_SearchBox(excelRead.getData(0, 1, 3));
		searchPage.click_Search_Button();
		searchPage.click_PlaintiffName_PlaintiffsResults_SearchResults(excelRead.getData(0, 1, 2));
		plaintiffProfilePage.click_Action_ToPerformOnBlueprint_FormsRequiringService_Section("PPF - Authorizations", "Review");
		reviewBlueprintPage.click_Approve();
		reviewBlueprintPage.click_CompleteReview();
		plaintiffProfilePage.verify_Blueprint_Status_FormsRequiringService_Section("PPF - Authorizations", "Approved");	  
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}