package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductListPage extends Utility {

    //@CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropDown;

    @FindBy(xpath = "(//p[@class='price'])")
    List<WebElement> laptopAndNoteBookProducts;

    //@CacheLookup
    @FindBy(linkText = "Sony VAIO")
    WebElement productSonyVaio;

    //@CacheLookup
    @FindBy(xpath = "//h4//a")
    List<WebElement> desktopsProducts;

    @CacheLookup
    @FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HTC Touch HD')]")
    WebElement productHTCTouchHd;

    @CacheLookup
    @FindBy(css = "div[id='content'] h2")
    WebElement productCategoryTitleText;


    public void selectOptionFromSortByDropDown(String sortByOption) {
        selectByVisibleTextFromDropDown(sortByDropDown, sortByOption);
        Reporter.log("select option '" + sortByOption + "' from SortBy dropdown field" + sortByDropDown.toString());
        CustomListeners.test.log(Status.PASS, "select option '" + sortByOption + "' from SortBy dropdown field");
    }

    public List<WebElement> getLaptopAndNoteBookProducts() {
        Reporter.log("Get laptop and notebook products list" + laptopAndNoteBookProducts.toString());
        CustomListeners.test.log(Status.PASS, "Get laptop and notebook products list");
        return webElementList (laptopAndNoteBookProducts);
    }

    public void clickOnSonyVaioProduct() {
        clickOnElement(productSonyVaio);
        Reporter.log("Click on SonyVAIO Product" + productSonyVaio.toString());
        CustomListeners.test.log(Status.PASS, "Click on SonyVAIO Product");
    }

    public List<WebElement> getDesktopsProducts() {
        Reporter.log("Get desktops products list" + desktopsProducts.toString());
        CustomListeners.test.log(Status.PASS, "Get desktops products list");
        return webElementList(desktopsProducts);
    }


    /**
     * this method will select desktops product from product list
     *
     * @param product
     */
    public void selectDesktopProducts(String product) {
        List<WebElement> products = getDesktopsProducts();
        try {

            for (WebElement e : products) {
                if (e.getText().equalsIgnoreCase(product)) {
                    e.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            products = getDesktopsProducts();
        }
    }

    public String getProductCategoryText() {
        Reporter.log("Get product Category title" + productCategoryTitleText.toString());
        CustomListeners.test.log(Status.PASS, "Get product Category title");
        return getTextFromElement(productCategoryTitleText);
    }
}
