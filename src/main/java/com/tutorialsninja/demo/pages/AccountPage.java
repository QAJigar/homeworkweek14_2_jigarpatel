package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {


    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement accountCreatedSuccessMessageText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement myAccountText;

    public String getAccountCreatedSuccessMessageText() {
        Reporter.log("Get Account Create Success Message" + accountCreatedSuccessMessageText.toString());
        CustomListeners.test.log(Status.PASS, "Get Account Create Success Message");
        return getTextFromElement(accountCreatedSuccessMessageText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on Continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
        Reporter.log("Click on My Account menu" + myAccountLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on My Account menu");
    }

    public String getMyAccountText() {
        Reporter.log("Get my account text" + myAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get My Account");
        return getTextFromElement(myAccountText);
    }

}
