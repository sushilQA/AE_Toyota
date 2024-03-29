package org.Toyota.TestCaseScripts;

import java.io.IOException;

import org.Toyota.Base.BaseClass;
import org.Toyota.Modules.CardHolderOnboarding;
import org.Toyota.Pages.Login;
import org.Toyota.Pages.Logout;
import org.Toyota.Pages.MyRequest;
import org.Toyota.Utilities.ExcelDataRead;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class CardHolder extends BaseClass {

	@Test(enabled = true, priority = 1)
	public void badgeAdminLogin() throws InterruptedException, IOException, BiffException {
		Login login = new Login(properties, driver);
		login.userLogIn(ExcelDataRead.readACell(1, 0), ExcelDataRead.readACell(1, 1));
		CardHolderOnboarding cardHolderOnboarding = new CardHolderOnboarding(properties, driver); 
		MyRequest myRequest = new MyRequest(properties, driver);
		myRequest.myRequest(driver, properties);
		cardHolderOnboarding.cardHolderOnBoarding(driver, properties);

	}

	@AfterClass
	public void afterClass() {
		System.out.println("TC1 Executed Successfully");
	}

}
