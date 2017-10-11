package com.test.automation.jobspot.signupPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.SignupPage;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 * 
 */

public class TC001_VerifySignUpBlankSubmit extends TestBase {

	public static final Logger	log	= Logger.getLogger(TC001_VerifySignUpBlankSubmit.class.getName());
	SignupPage						signupPage;

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testSignUpBlankSubmit() throws InterruptedException {
		try {
			log.info("============= Starting testSignUpBlankSubmit() Test =============");

			signupPage = new SignupPage(driver);
			// Click on sign up button
			signupPage.clickToSignUpButton();

			// Verify Sign Up Error Message
			signupPage.verifySignUpErrorMessage(OR.getProperty("ErrMsgFirstName"));

			log.info("============= Finished testSignUpBlankSubmit() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testSignUpBlankSubmit() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testSignUpBlankSubmit");
			Assert.fail();

		}
	}


}
