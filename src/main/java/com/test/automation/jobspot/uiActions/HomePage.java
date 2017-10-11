package com.test.automation.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 *
 */
public class HomePage {

	public static final Logger	log	= Logger.getLogger(HomePage.class.getName());
	WebDriver						driver;

	@FindBy(linkText = "Recruiter Sign Up")
	private WebElement signUp;

	@FindBy(linkText = "Recruiter Login")
	private WebElement login;

	@FindBy(id = "contactDtl")
	private WebElement contactUs;

	@FindBy(id = "aboutDtl")
	private WebElement aboutUs;

	@FindBy(id = "alertMessageForSuccess")
	private WebElement infoMessage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickToLogin() {
		waitForElementClickable(login);
		login.click();
		log.info("clicked on login link and object is:- " + login.toString());
	}

	public void clickToSignUp() {
		waitForElementClickable(signUp);
		signUp.click();
		log.info("clicked on signUp link and object is:- " + signUp.toString());

	}


	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
