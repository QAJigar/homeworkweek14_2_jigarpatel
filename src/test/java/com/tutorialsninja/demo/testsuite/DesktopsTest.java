package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    //AccountPage;
    CartPage cartPage;
    //CheckoutPage checkoutPage;
    HomePage homePage;
    //LogoutPage logoutPage;
    ProductListPage productListPage;
    ProductPage productPage;
   // RegisterPage registerAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
       // accountPage = new AccountPage();
        cartPage = new CartPage();
        //checkoutPage = new CheckoutPage();
        homePage = new HomePage();
       // logoutPage = new LogoutPage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        //registerAccountPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverToDesktopTabAndClick();
        //1.2 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();

        //before sorting product by name
        List<WebElement> products = productListPage.getDesktopsProducts();
        List<String> beforeSortProducts = new ArrayList<>();
        for (WebElement e : products) {
            beforeSortProducts.add(e.getText());
        }

        // beforeSortProducts.sort(Collections.reverseOrder());
        Collections.reverse(beforeSortProducts);

        //1.3 Select Sort By position "Name: Z to A"
        productListPage.selectOptionFromSortByDropDown("Name (Z - A)");

        //after sorting product by name
        products = productListPage.getDesktopsProducts();
        List<String> afterSortProducts = new ArrayList<>();
        for (WebElement e : products) {
            afterSortProducts.add(e.getText());
        }
        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(afterSortProducts, beforeSortProducts, "products are not sorted in descending (Z-A) order");
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "desktopProducts", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) throws InterruptedException {
        // 2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropDownAndClick();
        // 2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();
        // 2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverToDesktopTabAndClick();
        // 2.4 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();
        // 2.5 Select Sort By position "Name: A to Z"
        productListPage.selectOptionFromSortByDropDown("Name (A - Z)");
        // 2.6 Select product <product>
        productListPage.selectDesktopProducts(product);
        // 2.7 Enter Qty <qty> using Select class.
        productPage.clearTextFromQty();
        productPage.enterTextToQty(qty);
        // 2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();
        Thread.sleep(40000);
        // 2.9 Verify the Message <successMessage>
        System.out.println("For product " + product + productPage.getNotificationBarText());
        Assert.assertTrue(productPage.getNotificationBarText().contains(successMessage), "Success Message is not matched for product: " + product + ".");
        // 2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLink();
        // 2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"), "Shopping Cart text is not matched");
        // 2.12 Verify the Product name <productName>
        Assert.assertTrue(cartPage.getProductNameText().contains(productName), "product name is not matched for product: " + product + ".");
        // 2.13 Verify the Model <model>
        Assert.assertEquals(cartPage.getModelNameText(), model, "model Name is not matched for product: " + product + ".");
        // 2.14 Verify the Total <total>
        Assert.assertTrue(cartPage.getTotalPriceText().contains(total), "total price is not match  product: " + product + ".");
    }
}
