package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    AccountPage accountPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    HomePage homePage;
    LogoutPage logoutPage;
    ProductListPage productListPage;
    ProductPage productPage;
    RegisterPage registerAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        accountPage = new AccountPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        homePage = new HomePage();
        logoutPage = new LogoutPage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        registerAccountPage = new RegisterPage();
    }

    public void selectMenu(String menu) {
        List<WebElement> menuList = homePage.getMenus();
        for (WebElement m : menuList) {
            try {
                if (m.getText().equalsIgnoreCase(menu)) {
                    m.click();
                }
            } catch (StaleElementReferenceException e) {
                menuList = homePage.getMenus();
            }
        }
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverToDesktopTabAndClick();
        // 1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(productListPage.getProductCategoryText(), "Desktops", "Desktops text is not matched");
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopsAndNoteBooksAndClick();
        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertTrue(productListPage.getProductCategoryText().contains("Laptops & Notebooks"), "Laptops & Notebooks text is not matched");
    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverOnComponentsTabAndClick();
        // 3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(productListPage.getProductCategoryText(), "Components", "Components text is not matched");
    }
}
