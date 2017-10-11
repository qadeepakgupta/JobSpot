package com.test.automation.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 *
 */

public class SignupPage {

	public static final Logger	log	= Logger.getLogger(SignupPage.class.getName());
	WebDriver						driver;
	LoginPage						loginPage;

	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(xpath = "//div[1]/span/b/i")
	private WebElement signupPanelHeading;

	@FindBy(id = "fistName_ID")
	private WebElement signupFirstname;

	@FindBy(id = "LastName_ID")
	private WebElement signupLastname;

	@FindBy(id = "companyName_ID")
	private WebElement signupCompanyName;

	@FindBy(id = "companyEmail_ID")
	private WebElement signupEmailID;

	@FindBy(id = "mobileNumber_ID")
	private WebElement signupMobileNo;

	@FindBy(id = "submit_ID")
	private WebElement signUpButton;

	@FindBy(id = "cancel_ID")
	private WebElement cancelButton;

	@FindBy(id = "alertMessage")
	private WebElement errMessage;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForvisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clearSignupFields() {
		signupFirstname.clear();
		signupLastname.clear();
		signupCompanyName.clear();
		signupEmailID.clear();
		signupMobileNo.clear();
	}

	public String signupPanelHeading() {
		log.info("signup panel heading is:- " + signupPanelHeading.getText());
		return signupPanelHeading.getText();
	}

	public void clickToSignUpButton() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickToSignUp();
		waitForElementClickable(signUpButton);
		signUpButton.click();
		log.info("clicked on signUp button and object is:- " + signUpButton.toString());
	}

	public void signUpToApplication(String firstname, String lastname, String companyName, String emailID, String mobileNo)
			throws InterruptedException {
		log.info("========== starting signUpToApplication() ===============");

		HomePage homePage = new HomePage(driver);
		homePage.clickToSignUp();

		signupFirstname.sendKeys(firstname);
		log.info("entered firstname:-" + firstname + "and object is " + signupFirstname.toString());

		signupLastname.sendKeys(lastname);
		log.info("entered lastname:-" + lastname + "and object is " + signupLastname.toString());

		signupCompanyName.sendKeys(companyName);
		log.info("entered company name:-" + companyName + "and object is " + signupCompanyName.toString());

		signupEmailID.sendKeys(emailID);
		log.info("entered email ID:-" + emailID + "and object is " + signupEmailID.toString());

		signupMobileNo.sendKeys(mobileNo);
		log.info("entered mobile no.:-" + mobileNo + "and object is " + signupMobileNo.toString());

		Thread.sleep(2000);
		// signUpButton.click();
		signupMobileNo.sendKeys(Keys.ENTER);
		log.info("clicked on sign up button and object is:- " + signUpButton.toString());
		log.info("========== ending signUpToApplication() ===============");

	}


	public String getSignUpInvalidErrorMessage() {
		log.info("error message is:- " + errMessage.getText());
		return errMessage.getText();
	}

	public String getTitleName() {
		log.info("current title name is :- " + driver.getTitle());
		return driver.getTitle();
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}


	public void verifySignUpInfoMessage(String forgetInfoMessage) {
		String infoMessage = loginPage.getInfoMessageSuccessfully();
		Assert.assertEquals(infoMessage, forgetInfoMessage);
	}

	public void verifySignUpErrorMessage(String forgetErrorMessage) {
		Assert.assertEquals(getSignUpInvalidErrorMessage(), forgetErrorMessage);
	}


}
