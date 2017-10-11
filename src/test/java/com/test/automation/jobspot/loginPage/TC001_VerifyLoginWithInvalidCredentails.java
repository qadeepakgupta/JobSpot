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

public class TC001_VerifyLoginWithInvalidCredentails extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentails.class.getName());
	LoginPage loginPage;

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testLoginWithInvalidCredentails() throws InterruptedException {
		try {
			log.info("============= Starting testLoginWithInvalidCredentails() Test =============");
			loginPage = new LoginPage(driver);
			loginPage.loginToApplication(OR.getProperty("InvalidUsername"), OR.getProperty("InvalidPassword"));
			Thread.sleep(2000);
			Assert.assertEquals(loginPage.getInvalidLoginErrorMessage(), "Username or password Incorrect.");
			log.info("============= Finished testLoginWithInvalidCredentails() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testLoginWithInvalidCredentails() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testLoginWithInvalidCredentails");
			Assert.fail();
		}
	}

}
