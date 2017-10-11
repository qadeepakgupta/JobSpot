package com.test.automation.jobspot.sharedProfilePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.jobspot.testBase.TestBase;
import com.test.automation.jobspot.uiActions.ShareProfilePage;

public class TC001_VerifyPrivateAccess extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyPrivateAccess.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		openBrowser();
	}

	@Test
	public void testPrivateAccess() throws InterruptedException {
		try {
			log.info("============= Starting testPrivateAccess() Test =============");

			appendURL(OR.getProperty("PrivateAccess"));
			ShareProfilePage vPage = new ShareProfilePage(driver);
			vPage.checkPrivateAccess();

			log.info("============= Finished testPrivateAccess() Test =============");
		} catch (Exception e) {
			log.error("============= Finished testPrivateAccess() Test =============");
			log.error("Exception is: " + e.getMessage());
			getScreenShot("testPrivateAccess");
			Assert.fail();
		}
	}

}
