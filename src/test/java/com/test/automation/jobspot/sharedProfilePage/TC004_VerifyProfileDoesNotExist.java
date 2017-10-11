package com.test.automation.jobspot.sharedProfilePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ShareProfilePage;

public class TC004_VerifyProfileDoesNotExist extends TestBase {

	public static final Logger log = Logger.getLogger(TC004_VerifyProfileDoesNotExist.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testProfileDoesNotExist() throws InterruptedException {
		try {
			log.info("============= Starting testProfileDoesNotExist() Test =============");

			appendURL(OR.getProperty("InvalidCandidate"));
			ShareProfilePage vPage = new ShareProfilePage(driver);
			vPage.checkInvalidProfile();

			log.info("============= Finished testProfileDoesNotExist() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testProfileDoesNotExist() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testProfileDoesNotExist");
			Assert.fail();
		}
	}

}
