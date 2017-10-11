package com.test.automation.jobspot.sharedProfilePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ShareProfilePage;

public class TC003_VerifyRestrictedAccess extends TestBase {

	public static final Logger log = Logger.getLogger(TC003_VerifyRestrictedAccess.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testRestrictedAccess() throws InterruptedException {
		try {
			log.info("============= Starting testRestrictedAccess() Test =============");
			
			appendURL(OR.getProperty("RestrictedAccess"));

			ShareProfilePage vPage = new ShareProfilePage(driver);
			vPage.checkRestrictedAccess(OR.getProperty("Code"));
			
			log.info("============= Finished testRestrictedAccess() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testRestrictedAccess() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testRestrictedAccess");
			Assert.fail();

		}
	}
}
