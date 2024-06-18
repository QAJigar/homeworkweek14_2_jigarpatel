package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ProductPage extends Utility {

    //  @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement productTitleText;

    // @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    // @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement greenBarNotification;

    // @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    // @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement qty;

    public String getProductTitleText() {
        Reporter.log("Get product title text" + productTitleText.toString());
        CustomListeners.test.log(Status.PASS, "Get product title text");
        return getTextFromElement(productTitleText);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        Reporter.log("Click on AddToCart button" + addToCartButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on AddToCart button");
    }

    public String getNotificationBarText() {
        Reporter.log("Get Notification Message" + greenBarNotification.toString());
        CustomListeners.test.log(Status.PASS, "Get Notification Message");
        return getTextFromElement(greenBarNotification);
    }

    public void clickOnShoppingCartLink() {
        clickOnElement(shoppingCartLink);
        Reporter.log("Click on Shopping Cart link from notification message" + shoppingCartLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on Shopping Cart link from notification message");
    }

    public void clearTextFromQty() {
        clearTextFromField(qty);
        Reporter.log("Clear pre-populated text from Quantity field" + qty.toString());
        CustomListeners.test.log(Status.PASS, "Clear pre-populated text from Quantity field");

    }

    public void enterTextToQty(String qtyValue) {
        sendTextToElement(qty, qtyValue);
        Reporter.log("Enter value " + qtyValue + "into quantity field" + qty.toString());
        CustomListeners.test.log(Status.PASS, "Enter value '" + qtyValue + "' into quantity field");
    }
}
