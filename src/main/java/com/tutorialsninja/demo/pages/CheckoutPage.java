package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement checkoutText;

    //@CacheLookup
    @FindBy(css = "body div[id='checkout-checkout'] div[class='row'] div[class='row'] div:nth-child(1) h2:nth-child(1)")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutRadioButton;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionState;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueGuestButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement shippingMethodContinueButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']")
    WebElement commentBox;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAgreementCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement paymentMethodContinueButton;

    public String getCheckoutText() {
        Reporter.log("Get Checkout Text" + checkoutText.toString());
        CustomListeners.test.log(Status.PASS, "Get checkout text");
        return getTextFromElement(checkoutText);
    }

    public String getNewCustomerText() {
        Reporter.log("Get New Customer Text" + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "Get New Customer Text");
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        clickOnElement(guestCheckoutRadioButton);
        Reporter.log("Click on Checkout radio button" + guestCheckoutRadioButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Checkout  radio button");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void enterTextToFirstName(String firstNameText) {
        sendTextToElement(firstName, firstNameText);
        Reporter.log("Enter firstname: " + firstNameText + "into FirstName field" + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter firstname: " + firstNameText + "into FirstName Field");
    }

    public void enterTextToLastName(String lastNameText) {
        sendTextToElement(lastName, lastNameText);
        Reporter.log("Enter lastname: " + lastNameText + "into LastName field" + lastName.toString());
        CustomListeners.test.log(Status.PASS, "Enter lastname: " + lastNameText + "into LastName Field");
    }

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        Reporter.log("Enter email: " + emailText + "into Email field" + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter email: " + emailText + "into Email Field");
    }

    public void enterTextToTelephone(String telephoneText) {
        sendTextToElement(telephone, telephoneText);
        Reporter.log("Enter telephone: " + telephoneText + "into Telephone field" + telephone.toString());
        CustomListeners.test.log(Status.PASS, "Enter telephone: " + telephoneText + "into Telephone Field");
    }

    public void enterTextToAddress1(String address1Text) {
        sendTextToElement(address1, address1Text);
        Reporter.log("Enter address: " + address1Text + "into Address1 field" + address1.toString());
        CustomListeners.test.log(Status.PASS, "Enter address: " + address1Text + "into Address1 Field");
    }

    public void enterTextToCity(String cityText) {
        sendTextToElement(city, cityText);
        Reporter.log("Enter city: " + cityText + "into City field" + city.toString());
        CustomListeners.test.log(Status.PASS, "Enter city: " + cityText + "into City Field");
    }

    public void enterTextToPostCode(String postcodeText) {
        sendTextToElement(postCode, postcodeText);
        Reporter.log("Enter PostCode: " + postcodeText + "into PostCode field" + postCode.toString());
        CustomListeners.test.log(Status.PASS, "Enter postCode: " + postcodeText + "into PostCode Field");
    }

    public void selectOptionFromCountry(String countryOption) {
        selectByVisibleTextFromDropDown(country, countryOption);
        Reporter.log("Select " + countryOption + " option from Country dropdown field" + country.toString());
        CustomListeners.test.log(Status.PASS, "Select " + countryOption + " option from Country dropdown field");
    }

    public void selectOptionFromRegionState(String registerStateOption) {
        selectByVisibleTextFromDropDown(regionState, registerStateOption);
        Reporter.log("Select " + registerStateOption + " option from Region/State dropdown field" + regionState.toString());
        CustomListeners.test.log(Status.PASS, "Select " + registerStateOption + " option from Region/State dropdown field");
    }

    public void clickOnContinueGuestButton() {
        clickOnElement(continueGuestButton);
        Reporter.log("Click on continue button" + continueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on continue button");
    }

    public void clickOnShippingMethodContinueButton() {
        clickOnElement(shippingMethodContinueButton);
        Reporter.log("Click on Continue button" + shippingMethodContinueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Continue button");
    }

    public void enterTextToCommentBox(String commentBoxText) {
        sendTextToElement(commentBox, commentBoxText);
        Reporter.log("Enter Comment: " + commentBoxText + "into CommentBox" + commentBox.toString());
        CustomListeners.test.log(Status.PASS, "Enter Comment: " + commentBoxText + "into CommentBox");
    }

    public void clickOnTermAndAgreementCheckBox() {
        clickOnElement(termsAgreementCheckBox);
        Reporter.log("Click on Terms And Agreement CheckBox" + termsAgreementCheckBox);
        CustomListeners.test.log(Status.PASS, "Click on Terms And Agreement CheckBox");
    }

    public void clickOnPaymentMethodContinueButton() {
        clickOnElement(paymentMethodContinueButton);
        Reporter.log("Click on Continue button" + paymentMethodContinueButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Continue button");
    }

}
