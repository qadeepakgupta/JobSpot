package com.test.automation.jobspot.forgetPasswordPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ForgetPasswordPage;

public class TC002_VerifyValidForgetPassword extends TestBase {

	public static final Logger	log	= Logger.getLogger(TC002_VerifyValidForgetPassword.class.getName());
	ForgetPasswordPage			forgetPage;


	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testForgetPassword() {
		try {
			log.info("============= Starting testForgetPassword() Test =============");

			forgetPage = new ForgetPasswordPage(driver);
			// Enter valid username then click on forget password link then enter valid security answser and click on submit button
			forgetPage.forgetPassword(OR.getProperty("ValidUsername"), OR.getProperty("ValidSecurityAnswser"));

			// Verify Info Message
			forgetPage.verifyForgetPasswordInfoMessage(OR.getProperty("ForgetPasswordInfoMessage"));

			log.info("============= Finished testForgetPassword() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testForgetPassword() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testForgetPassword");
			Assert.fail();

		}
	}


}

