package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {


    AccountPage accountPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    LogoutPage logoutPage;
    ProductListPage productListPage;
    ProductPage productPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        accountPage = new AccountPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        homePage = new HomePage();
        logoutPage = new LogoutPage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        registerPage = new RegisterPage();
    }
    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    //1.2 Click on “Show All Laptops & Notebooks”
    //1.3 Select Sort By "Price (High > Low)"
    //1.4 Verify the Product price will arrange in High to Low order.
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    //2.1 Mouse hover on Laptops & Notebooks Tab and click
    //2.2 Click on “Show All Laptops & Notebooks”
    //2.3 Select Sort By "Price (High > Low)"
    //2.4 Select Product “MacBook”
    //2.5 Verify the text “MacBook”
    //2.6 Click on ‘Add To Cart’ button 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
    //2.8 Click on link “shopping cart” display into success message
    //2.9 Verify the text "Shopping Cart"
    //2.10 Verify the Product name "MacBook"
    //2.11 Change Quantity "2" 2.12 Click on “Update” Tab 2.13 Verify the message “Success: You have modified your shopping cart!”
    //2.14 Verify the Total £737.45
    //2.15 Click on “Checkout” button
    //2.16 Verify the text “Checkout”
    //2.17 Verify the Text “New Customer”
    //2.18 Click on “Guest Checkout” radio button
    //2.19 Click on “Continue” tab
    //2.20 Fill the mandatory fields
    //2.21 Click on “Continue” Button
    //2.22 Add Comments About your order into text area
    //2.23 Check the Terms & Conditions check box
    //2.24 Click on “Continue” button 2.25 Verify the message “Warning: Payment method required!”

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNoteBooksAndClick();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopsAndNotebooks();
        //before sorting by price filter
        List<WebElement> products = productListPage.getLaptopAndNoteBookProducts();
        List<Double> beforeSortProduct = new ArrayList<>();
        for (WebElement p : products) {
            beforeSortProduct.add(Double.valueOf(p.getText().split("\n")[0].replace("$", "").replace(",", "").trim()));
        }

        //sort price
        beforeSortProduct.sort(Collections.reverseOrder());

        //1.3 Select Sort By "Price (High > Low)"
        productListPage.selectOptionFromSortByDropDown("Price (High > Low)");

        //After sorting by price
        products = productListPage.getLaptopAndNoteBookProducts();
        List<Double> afterSortProduct = new ArrayList<>();
        for (WebElement p : products) {
            afterSortProduct.add(Double.valueOf(p.getText().split("\n")[0].replace("$", "").replace(",", "").trim()));
        }
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(afterSortProduct, beforeSortProduct, "Price is not sorted by high to low order");

    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNoteBooksAndClick();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopsAndNotebooks();
        //2.3 Select Sort By "Price (High > Low)"
        productListPage.selectOptionFromSortByDropDown("Price (High > Low)");
        //2.4 Select Product “MacBook” /"Sony VAIO")
        productListPage.clickOnSonyVaioProduct();
        //2.5 Verify the text “MacBook”/ "Sony VAIO"
        Assert.assertEquals(productPage.getProductTitleText(), "Sony VAIO", "Sony VAIO text is not matched");
        //2.6 Click on ‘Add To Cart’ button
        productPage.clickOnAddToCartButton();
        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!” /"Success: You have added Sony VAIO to your shopping cart!"
        Assert.assertTrue(productPage.getNotificationBarText().contains("Success: You have added Sony VAIO to your shopping cart!"));
        //2.8 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLink();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));
        //2.10 Verify the Product name "MacBook"/ "Sony VAIO"
        Assert.assertEquals(cartPage.getProductNameText(), "Sony VAIO", "Sony VAIO text is not displayed");
        //2.11 Change Quantity "2"
        cartPage.clearTextFromQtyField();
        cartPage.enterTextToQty("2");
        //2.12 Click on “Update” Tab
        cartPage.clickOnUpdateTab();
        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(cartPage.getGreenBarNotificationText().contains("Success: You have modified your shopping cart!"), "expected text is not match");
        //2.14 Verify the Total £737.45 // for Sony Vaio product --- £1,472.45, $2,404.00  price £612.50;  $1,202.00
        Assert.assertEquals(cartPage.getTotalPriceText(), "$2,404.00", "total price is not matched");
        //2.15 Click on “Checkout” button
        cartPage.clickOnCheckoutButton();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.getCheckoutText(), "Checkout", "Checkout text is mismatched");
        //2.17 Verify the Text “New Customer”
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getNewCustomerText().contains("New Customer"), "New Customer text is not displayed");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutRadioButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.enterTextToFirstName("Test FirstName");
        checkoutPage.enterTextToLastName("Test LastName");
        checkoutPage.enterTextToEmail("testfnln" + generateRandomNumber() + "@gmail.com");
        checkoutPage.enterTextToTelephone("04532939192");
        checkoutPage.enterTextToAddress1("Test RD");
        checkoutPage.enterTextToCity("Test City");
        checkoutPage.enterTextToPostCode("T5 7TA");
        // checkoutPage.selectOptionFromCountry("United Kingdom");
        checkoutPage.selectOptionFromRegionState("Bristol");
        checkoutPage.clickOnContinueGuestButton();
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnShippingMethodContinueButton();
        //2.22 Add Comments About your order into text area
        checkoutPage.enterTextToCommentBox("Kindly place near by address");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTermAndAgreementCheckBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnPaymentMethodContinueButton();
        // 2.25 Verify the message “Warning: Payment method required!” --this is N/A steps
    }
}
