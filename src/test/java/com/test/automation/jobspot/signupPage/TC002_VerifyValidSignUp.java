package com.test.automation.jobspot.signupPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.LoginPage;
import com.test.automation.jobspot.uiActions.SignupPage;


/**
 * 
 * @author Deepak Gupta
 * @Created Date 05-10-2017
 * 
 */

public class TC002_VerifyValidSignUp extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyValidSignUp.class.getName());

	SignupPage	signupPage;
	LoginPage	loginPage;


	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testValidSignUp() throws InterruptedException {
		try {
			log.info("============= Starting testValidSignUp() Test =============");
			signupPage = new SignupPage(driver);
			signupPage.signUpToApplication(OR.getProperty("ValidFirstname"), OR.getProperty("ValidLastname"), OR.getProperty("ValidCompanyName"),
					OR.getProperty("ValidEmailAddress"), OR.getProperty("ValidMobileNumber"));

			String actualTitleName = driver.getTitle();
			Assert.assertEquals(actualTitleName, OR.getProperty("TitleName"));

			log.info("============= Finished testValidSignUp() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testValidSignUp() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testValidSignUp");
			Assert.fail();

		}
	}


}

