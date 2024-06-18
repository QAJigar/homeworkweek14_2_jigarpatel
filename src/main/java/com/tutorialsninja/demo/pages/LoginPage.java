package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;


    public String getReturningCustomerText() {
        Reporter.log("Get Returning Customer text" + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "Get Returning Customer text");
        return getTextFromElement(returningCustomerText);
    }

    public void enterTextToEmailAddress(String emaiText) {
        sendTextToElement(emailAddress, emaiText);
        Reporter.log("Enter email address: " + emaiText + emailAddress.toString());
        CustomListeners.test.log(Status.PASS, "Enter email address: " + emaiText);
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        Reporter.log("Enter password: " + passwordText + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter password: " + passwordText);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Click on login button" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on login button");
    }
}
