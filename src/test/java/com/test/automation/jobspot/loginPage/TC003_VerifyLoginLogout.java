package com.test.automation.jobspot.loginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.DashboardPage;
import com.test.automation.jobspot.uiActions.LoginPage;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 * 
 */

public class TC003_VerifyLoginLogout extends TestBase {

	public static final Logger	log	= Logger.getLogger(TC003_VerifyLoginLogout.class.getName());
	LoginPage						loginPage;
	DashboardPage					dashPage;

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testLogin() throws InterruptedException {
		try {
			log.info("============= Starting testLogin() Test =============");

			loginPage = new LoginPage(driver);
			loginPage.loginToApplication(OR.getProperty("ValidUsername"), OR.getProperty("ValidPassword"));
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "Dashboard");

			log.info("============= Finished testLogin() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testLogin() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testLogin");
			Assert.fail();
		}
	}

	@Test(dependsOnMethods = "testLogin")
	public void testLogout() {
		try {
			log.info("============= Starting testLogout() Test =============");

			loginPage = new LoginPage(driver);
			dashPage = new DashboardPage(driver);
			dashPage.clickOnlogoutLink();
			Assert.assertEquals(driver.getTitle(), "JobSpot");

			log.info("============= Finished testLogout() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testLogout() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testLogout");
			Assert.fail();

		}
	}

}
