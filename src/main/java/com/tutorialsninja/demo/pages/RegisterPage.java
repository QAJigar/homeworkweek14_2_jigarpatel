package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;

    @CacheLookup
    @FindBy(xpath = "//input[@value='1'][@name='newsletter']")
    WebElement yesSubscribeRadioOption;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndAgreement;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;


    public String getRegisterAccountText() {
        Reporter.log("Get Register Account Text" + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS, "Get Register Account text");
        return getTextFromElement(registerAccountText);
    }

    public void enterTextToFirstName(String firstnameText) {
        sendTextToElement(firstName, firstnameText);
        Reporter.log("Enter firstname: " + firstnameText + "to FirstName field" + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter FirstName: " + firstnameText);
    }

    public void enterTextToLastName(String lastNameText) {
        sendTextToElement(lastName, lastNameText);
        Reporter.log("Enter lastname: " + lastNameText + "to FirstName field" + lastName.toString());
        CustomListeners.test.log(Status.PASS, "Enter LastName: " + lastNameText);
    }

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        Reporter.log("Enter email: " + emailText + "to Email field" + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter email: " + emailText);
    }

    public void enterTextToTelephone(String telephoneText) {
        sendTextToElement(telephone, telephoneText);
        Reporter.log("Enter telephone: " + telephoneText + "to Telephone field" + telephone.toString());
        CustomListeners.test.log(Status.PASS, "Enter email: " + telephoneText);
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        Reporter.log("Enter password: " + passwordText + "to Password field" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter password: " + passwordText);

    }

    public void enterTextToPasswordConfirm(String passwordConfirmText) {
        sendTextToElement(passwordConfirm, passwordConfirmText);
        Reporter.log("Enter password confirm: " + passwordConfirmText + "to Password Confirm field" + passwordConfirm.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password Confirm: " + passwordConfirmText);
    }

    public void clickOnYesRadioOption() {
        clickOnElement(yesSubscribeRadioOption);
        Reporter.log("Click on 'Yes' option into Subscribe button" + yesSubscribeRadioOption.toString());
        CustomListeners.test.log(Status.PASS, "Click on 'Yes' option into Subscribe button");
    }

    public void clickOnTermsAndAgreement() {
        clickOnElement(termsAndAgreement);
        Reporter.log("Click on terms and agreement checkbox" + termsAndAgreement.toString());
        CustomListeners.test.log(Status.PASS, "Click on terms and agreement checkbox");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

}
