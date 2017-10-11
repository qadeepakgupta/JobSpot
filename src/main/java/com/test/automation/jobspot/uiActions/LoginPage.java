package com.test.automation.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 *
 */

public class LoginPage {

	public static final Logger log = Logger.getLogger(LoginPage.class.getName());

	WebDriver	driver;
	HomePage		homePage;

	@FindBy(xpath = "//div[1]/span/b/i")
	private WebElement loginPanelHeading;

	@FindBy(id = "name")
	private WebElement loginUsername;

	@FindBy(id = "password")
	private WebElement loginPassword;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	@FindBy(linkText = "Sign Up")
	private WebElement signUp;

	@FindBy(id = "forgotPassword")
	private WebElement forgetPassword;

	@FindBy(id = "alertMessage")
	private WebElement errMessage;

	@FindBy(id = "alertMessageForSuccess")
	private WebElement infoMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clearLoginFields() {
		loginUsername.clear();
		loginPassword.clear();
	}

	public void clickToForgetPassword(String username) throws InterruptedException {
		log.info("Starting clickToForgetPassword() ");
		HomePage homePage = new HomePage(driver);
		homePage.clickToLogin();
		
		loginUsername.sendKeys(username);
		log.info("entered login username:-" + username + "and object is " + loginUsername.toString());

		forgetPassword.click();
		log.info("clicked on forget password link and object is:- " + forgetPassword.toString());
		log.info("Ending clickToForgetPassword() ");
	}


	public void loginToApplication(String username, String password) throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.clickToLogin();

		waitForElementClickable(loginUsername);
		loginUsername.sendKeys(username);
		log.info("entered username:-" + username + "and object is " + loginUsername.toString());
		loginPassword.sendKeys(password);
		log.info("entered password:-" + password + "and object is " + loginPassword.toString());

		waitForElementClickable(loginButton);
		loginButton.click();
		log.info("clicked on login button and object is:- " + loginButton.toString());

	}

	public String loginPanelHeading() {
		log.info("login panel heading is:- " + loginPanelHeading.getText());
		return loginPanelHeading.getText();
	}

	public String getInvalidLoginErrorMessage() {
		log.info("error message is:- " + errMessage.getText());
		return errMessage.getText();
	}

	public String getInfoMessageSuccessfully() {
		log.info("Info message is:- " + infoMessage.getText());
		return infoMessage.getText();
	}


	public String getTitleName() {
		log.info("current title name is :- " + driver.getTitle());
		return driver.getTitle();
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		log("switched to the default Content");
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void loginToDemoSite(String emailAddress, String loginPassword) {
		loginUsername.sendKeys(emailAddress);
		this.loginPassword.sendKeys(loginPassword);
		loginButton.click();
	}

	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

}