package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LogoutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public String getAccountLogoutText() {
        Reporter.log("Get Account Logout text" + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "Get Account Logout text");
        return getTextFromElement(accountLogoutText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }
}
