package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountMenu;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountMenuOptions;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNoteBooksMenu;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show AllLaptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsMenu;

    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement showAllDeskTopLink;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyMenu;

    @CacheLookup
    @FindBy(css = "button[name='GBP']")
    WebElement poundSterling;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> menus;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;


    public void clickOnMyAccountMenu() {
        clickOnElement(myAccountMenu);
        Reporter.log("clicking on My Account Menu " + myAccountMenu.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on My Account Menu");
    }


    public List<WebElement> getMyAccountMenuOptions() {
        Reporter.log("Get My Account menu options" + myAccountMenuOptions.toString());
        CustomListeners.test.log(Status.PASS, "Get My Account menu options");
        return webElementList(myAccountMenuOptions);

    }

    public void mouseHoverOnLaptopsAndNoteBooksAndClick() {
        mouseHoverToElementAndClick(laptopAndNoteBooksMenu);
        Reporter.log("Mouse Hover On LaptopsAndNoteBooks And Click" + laptopAndNoteBooksMenu.toString());
        CustomListeners.test.log(Status.PASS, "Mouse Hover On LaptopsAndNoteBooks And Click");
    }

    public void clickOnShowAllLaptopsAndNotebooks() {
        clickOnElement(showAllLaptopsAndNotebooks);
        Reporter.log("click on show All LaptopsAndNotebooks" + showAllLaptopsAndNotebooks.toString());
        CustomListeners.test.log(Status.PASS, "click on showAllLaptopsAndNotebooks");
    }

    public void mouseHoverToDesktopTabAndClick() {
        mouseHoverToElementAndClick(desktopsMenu);
        Reporter.log("Mouse Hover On DesktopTab And Click" + desktopsMenu.toString());
        CustomListeners.test.log(Status.PASS, "Mouse Hover On DesktopTab And Click");
    }

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDeskTopLink);
        Reporter.log("click on show All DeskTop " + showAllDeskTopLink.toString());
        CustomListeners.test.log(Status.PASS, "click on showAllDeskTop");
    }

    public void mouseHoverOnCurrencyDropDownAndClick() {
        mouseHoverToElementAndClick(currencyMenu);
        Reporter.log("Mouse hover on Currency Dropdown and click" + currencyMenu.toString());
        CustomListeners.test.log(Status.PASS, "select £ option from currency menu");
    }

    public void mouseHoverOnPoundSterlingAndClick() {
        mouseHoverToElementAndClick(poundSterling);
        Reporter.log("Mouse hover on £Pound Sterling and click" + poundSterling.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on £Pound Sterling and click");
    }

    public List<WebElement> getMenus() {
        Reporter.log("get menus options" + menus.toString());
        CustomListeners.test.log(Status.PASS, "get menu options");
        return webElementList(menus);
    }

    public void mouseHoverOnComponentsTabAndClick() {
        mouseHoverToElementAndClick(componentsTab);
        Reporter.log("Mouse hover on “Components” Tab and click" + componentsTab.toString());
        CustomListeners.test.log(Status.PASS, "Mouse hover on “Components” Tab and click");
    }
}
