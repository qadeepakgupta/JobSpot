package com.test.automation.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 31-07-2017
 *
 */

public class DashboardPage {

	public static final Logger	log	= Logger.getLogger(DashboardPage.class.getName());
	WebDriver						driver;

	@FindBy(xpath = "//header/div/div/div/div[3]/a")
	private WebElement companyName;

	@FindBy(xpath = "//*[@title='Menu']")
	private WebElement menuOptionShow;

	@FindBy(className = "closebtn")
	private WebElement menuOptionHide;

	@FindBy(xpath = "//div[@class='pageName']")
	private WebElement headerName;

	@FindBy(xpath = "//li/a/span[text()='Dashboard']")
	private WebElement dashboard;

	@FindBy(xpath = "//li/a/span[text()='Company Profile']")
	private WebElement companyProfile;

	@FindBy(xpath = "//li/a/span[text()='Job Listing']")
	private WebElement jobLisiting;

	@FindBy(xpath = "//li/a/span[text()='Search Candidates']")
	private WebElement searchCandidates;

	@FindBy(xpath = "//li/a/span[text()='Company Candidates']")
	private WebElement appliedCandidates;

	@FindBy(xpath = "//li/a/span[text()='Manage Interviews']")
	private WebElement manageInterviews;

	@FindBy(xpath = "//li/a/span[text()='Question Answers']")
	private WebElement questionAnswers;

	@FindBy(xpath = "//li/a/span[text()='Notifications']")
	private WebElement notifications;

	@FindBy(xpath = "//li/a/span[text()='Change Password']")
	private WebElement changePassword;

	@FindBy(xpath = "//li/a/span[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//li/a/span[text()='Account Settings']")
	private WebElement accountSettings;

	@FindBy(className = "open-Menu")
	private WebElement menu;

	@FindBy(id = "alertMessage")
	private WebElement errMessage;

	@FindBy(id = "alertMessageForSuccess")
	private WebElement infoMessage;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 
	}

	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickOnlogoutLink() {
		waitForElementClickable(menuOptionShow);
		menuOptionShow.click();
		log.info("Menu Option is clicked");
		if (logout.isDisplayed() || logout.isEnabled()) {
			waitForElementClickable(logout);
			logout.click();
			log.info("Logout link is clicked");
		} else {
			log.info("Logout link is not enabled right now");
		}
	}

	/*
	 * public void waitForElementClickable(WebElement ele) { GenericMethod gMethod = new GenericMethod(driver); gMethod.elementToBeClickable(ele); }
	 * 
	 * public void clickCompanyProfileLink() throws InterruptedException { waitForElementClickable(menuOptionShow); menuOptionShow.click();
	 * logger.info("Menu Option is clicked"); Thread.sleep(2000); lnkCompanyProfile.click(); logger.info("Company Profile link is clicked");
	 * 
	 * }
	 * 
	 * public void clickDashboardLink() throws InterruptedException { waitForElementClickable(menuOptionShow); menuOptionShow.click();
	 * logger.info("Menu Option is clicked"); Thread.sleep(2000); lnkDashboard.click(); logger.info("Dashboard link is clicked");
	 * 
	 * }
	 * 
	 * public void clickJobLisitingLink() throws InterruptedException { Thread.sleep(5000);
	 * 
	 * waitForElementClickable(menuOptionShow);
	 * 
	 * if (menuOptionShow.isDisplayed() || menuOptionShow.isEnabled()) { waitForElementClickable(menuOptionShow); menuOptionShow.click();
	 * logger.info("Menu Option is clicked"); } else { logger.info("Menu Option is not enabled right now"); }
	 * 
	 * waitForElementClickable(lnkJobLisiting);
	 * 
	 * if (lnkJobLisiting.isDisplayed() || lnkJobLisiting.isEnabled()) { lnkJobLisiting.click(); logger.info("Job Lisiting link is clicked"); } else {
	 * logger.info("Job Lisiting link is not enabled right now"); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void verifyHeaderName(String expectedTitle) { String actualTitle = headerName.getText(); if (actualTitle.equals(expectedTitle)) {
	 * logger.info("Actual Title Name is " + actualTitle); } else { logger.error("Actual Title Name is " + actualTitle); }
	 * 
	 * }
	 */

	public void verifyErrorMsg() {
		Assert.assertTrue(errMessage.isDisplayed());
	}

	public void verifyInfoMsg() {
		Assert.assertTrue(infoMessage.isDisplayed());
	}

}
