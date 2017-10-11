package com.test.automation.jobspot.loginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.LoginPage;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 31-07-2017
 *
 */

public class TC002_VerifyLoginWithValidCredentails extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithValidCredentails.class.getName());
	LoginPage loginPage;

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testLoginWithValidCredentails() throws InterruptedException {
		try {
			log.info("============= Starting testLoginWithValidCredentails() Test =============");
			loginPage = new LoginPage(driver);
			loginPage.loginToApplication(OR.getProperty("ValidUsername"), OR.getProperty("ValidPassword"));
			Thread.sleep(1000);
			Assert.assertEquals(driver.getTitle(), "Dashboard");
			log.info("============= Finished testLoginWithValidCredentails() Test =============");

		} catch (Exception e) {
			log.error("============= Finished testLoginWithValidCredentails() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testLoginWithValidCredentails");
			Assert.fail();

		}

	}

}
