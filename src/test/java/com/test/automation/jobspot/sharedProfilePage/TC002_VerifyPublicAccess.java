package com.test.automation.jobspot.sharedProfilePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ShareProfilePage;

public class TC002_VerifyPublicAccess extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyPublicAccess.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testPublicAccess() throws InterruptedException {
		try {
			log.info("============= Starting testPublicAccess() Test =============");

			appendURL(OR.getProperty("PublicAccess"));
			ShareProfilePage vPage = new ShareProfilePage(driver);
			vPage.checkPublicAccess("Gurmeet Singh");

			log.info("============= Finished testPublicAccess() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testPublicAccess() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testPublicAccess");
			Assert.fail();
		}
	}

}
