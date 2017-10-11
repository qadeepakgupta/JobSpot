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
 * @Created Date 10-10-2017
 *
 */

public class ForgetPasswordPage {


	public static final Logger log = Logger.getLogger(ForgetPasswordPage.class.getName());

	WebDriver	driver;
	LoginPage	loginPage;

	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(xpath = "//div[1]/span/b/i")
	private WebElement forgetPanelHeading;

	@FindBy(xpath = "//div[2]/div/input[1]")
	private WebElement forgetUsername;

	@FindBy(xpath = "//div[3]/div/input[1]")
	private WebElement forgetSecurityQuestion;

	@FindBy(xpath = "//div[4]/div/input[1]")
	private WebElement forgetSecurityAnswer;

	@FindBy(xpath = "//div[5]/div/input[1]")
	private WebElement forgetEmailAddress;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	@FindBy(id = "cancelButton")
	private WebElement cancelButton;

	@FindBy(id = "alertMessage")
	private WebElement errMessage;


	public ForgetPasswordPage(WebDriver driver) {
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

	public String getInvalidForgetPasswordErrorMessage() {
		log.info("Error message is:- " + errMessage.getText());
		return errMessage.getText();
	}

	public String forgetPanelHeading() {
		log.info("forget password panel heading is:- " + forgetPanelHeading.getText());
		return forgetPanelHeading.getText();
	}

	public void clickOnBlankSubmitButton(String loginUsername) throws InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.clickToForgetPassword(loginUsername);

		waitForElementClickable(submitButton);
		submitButton.click();
		log.info("clicked on forget password submit button and object is:- " + submitButton.toString());
	}


	public void forgetPassword(String loginUsername, String securityAnswer) throws InterruptedException {
		log.info("========== starting forgetPassword() ===============");

		loginPage = new LoginPage(driver);
		loginPage.clickToForgetPassword(loginUsername);

		Thread.sleep(1000);

		forgetSecurityAnswer.sendKeys(securityAnswer);
		log.info("Entered security answer :- " + securityAnswer + " and object is " + forgetSecurityAnswer.toString());

		waitForElementClickable(submitButton);
		submitButton.click();
		log.info("Clicked forget password submit button and object is:- " + submitButton.toString());
		log.info("========== ending forgetPassword() ===============");

	}


	public void verifyForgetPasswordInfoMessage(String forgetInfoMessage) {
		String infoMessage = loginPage.getInfoMessageSuccessfully();
		Assert.assertEquals(infoMessage, forgetInfoMessage);
	}

	public void verifyForgetPasswordErrorMessage(String forgetErrorMessage) {
		Assert.assertEquals(getInvalidForgetPasswordErrorMessage(), forgetErrorMessage);
	}

}
