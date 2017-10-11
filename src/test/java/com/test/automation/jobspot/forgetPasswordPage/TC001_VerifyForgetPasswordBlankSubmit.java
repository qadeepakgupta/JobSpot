package com.test.automation.jobspot.forgetPasswordPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ForgetPasswordPage;

public class TC001_VerifyForgetPasswordBlankSubmit extends TestBase {

	public static final Logger	log	= Logger.getLogger(TC001_VerifyForgetPasswordBlankSubmit.class.getName());
	ForgetPasswordPage			forgetPage;

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testForgetPasswordBlankSubmit() throws InterruptedException {
		try {
			log.info("============= Starting testForgetPasswordBlankSubmit() Test =============");

			forgetPage = new ForgetPasswordPage(driver);
			forgetPage.clickOnBlankSubmitButton(OR.getProperty("ValidUsername"));

			forgetPage.verifyForgetPasswordErrorMessage(OR.getProperty("ForgetPasswordBlankErrorMessage"));
			// Assert.assertTrue(true, "Security Answer can't be blank.");
			// Assert.assertEquals(forgetPage.getInvalidForgetPasswordErrorMessage(), "Security Answer can't be blank.");

			log.info("============= Finished testForgetPasswordBlankSubmit() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testForgetPasswordBlankSubmit() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testForgetPasswordBlankSubmit");
			Assert.fail();

		}
	}

}

