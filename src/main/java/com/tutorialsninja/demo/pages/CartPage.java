package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qty;

    @CacheLookup
    @FindBy(xpath = "//button[@data-original-title='Update']")
    WebElement updateTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement greenBarNotificationText;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//tbody//tr//td[@class='text-left'][2]")
    WebElement modelName;

    public String getShoppingCartText() {
        Reporter.log("Get Shopping cart text" + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Get Shopping cart text");
        return getTextFromElement(shoppingCartText);
    }

    public String getProductNameText() {
        Reporter.log("Get Product Name text" + productNameText.toString());
        CustomListeners.test.log(Status.PASS, "Get Product Name text");
        return getTextFromElement(productNameText);
    }

    public void clearTextFromQtyField() {
        clearTextFromField(qty);
        Reporter.log("Clear pre-populated text from Quantity field" + qty.toString());
        CustomListeners.test.log(Status.PASS, "Clear pre-populated text from Quantity field");
    }

    public void enterTextToQty(String qtyValue) {
        sendTextToElement(qty, qtyValue);
        Reporter.log("Enter value " + qtyValue + "into quantity field" + qty.toString());
        CustomListeners.test.log(Status.PASS, "Enter value '" + qtyValue + "' into quantity field");
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
        Reporter.log("Click on Update tab" + updateTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on Update tab");
    }

    public String getGreenBarNotificationText() {
        Reporter.log("Get notification text" + greenBarNotificationText.toString());
        CustomListeners.test.log(Status.PASS, "Get notification text");
        return getTextFromElement(greenBarNotificationText);
    }

    public String getTotalPriceText() {
        Reporter.log("Get Total Price text" + totalPrice.toString());
        CustomListeners.test.log(Status.PASS, "Get Total Price text");
        return getTextFromElement(totalPrice);
    }

    public void clickOnCheckoutButton() {
        Reporter.log("Click on Checkout button" + checkoutButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Checkout button");
        clickOnElement(checkoutButton);
    }

    public String getModelNameText() {
        Reporter.log("Get Model Name text" + modelName.toString());
        CustomListeners.test.log(Status.PASS, "Get Model Name text");
        return getTextFromElement(modelName);
    }
}
