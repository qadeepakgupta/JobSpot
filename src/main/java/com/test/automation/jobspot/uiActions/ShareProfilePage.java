package com.test.automation.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShareProfilePage {

	public static final Logger log = Logger.getLogger(ShareProfilePage.class.getName());
	WebDriver driver;

	@FindBy(className = "pageName")
	private WebElement sharedProfileName;

	@FindBy(name = "accessCode_Value")
	private WebElement accessCode;

	@FindBy(id = "submitButton_ID")
	private WebElement submitButton;

	@FindBy(id = "alertMessage")
	private WebElement errMessage;

	@FindBy(xpath = "//div[2]/label")
	private WebElement privateAccessMessage;

	public ShareProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String checkCandidateName() {
		return sharedProfileName.getText();
	}

	public String privateAccess() {
		return privateAccessMessage.getText();
	}

	public void checkPublicAccess(String titleName) {
		String candidateName = checkCandidateName();
		log.info("View Shared Profile Name is :" + candidateName);
		String publicAccess = driver.getTitle();
		if (publicAccess.equalsIgnoreCase(titleName)) {
			log.info("View Shared Profile Status is :" + publicAccess);
		} else {
			log.error("View Shared Profile Status is :" + publicAccess);
			Assert.fail();
		}

	}

	public void checkPrivateAccess() {
		String candidateName = checkCandidateName();
		log.info("View Shared Profile Name is :" + candidateName);
		String privateAccess = privateAccess();
		if (privateAccess.equals("Private Access")) {
			log.info("View Shared Profile Status is :" + privateAccess);
		} else {
			log.error("View Shared Profile Status is :" + privateAccess);
			Assert.fail();
		}

	}

	public void checkInvalidProfile() {
		String candidateName = checkCandidateName();
		log.info("Shared Candidate Profile Name is :" + candidateName);
		String invalid = privateAccess();
		if (invalid.equalsIgnoreCase("Profile does not exist.")) {
			log.info("Profile Status is :" + invalid);
		} else {
			log.error("Profile Status is :" + invalid);
			Assert.fail();

		}

	}

	public void checkRestrictedAccess(String Code) throws InterruptedException {
		String restrictedAccess = driver.getTitle();
		if (restrictedAccess.equals("Access Gateway")) {
			log.info("Current Title Name is :" + restrictedAccess);
			Thread.sleep(2000);
			accessCode.sendKeys(Code);
			submitButton.click();
			String candidateName = checkCandidateName();
			log.info("Candidate Name is :" + candidateName);
		} else {
			log.error("Invalid Candidate Profile is: " + restrictedAccess);
			Assert.fail();
		}
	}

}
