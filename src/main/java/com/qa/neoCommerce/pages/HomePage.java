package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import com.qa.opencart.contants.Appconstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;
    Element_utils eleutil;
    //1. Private By Locator
    private By searchTextfield = By.xpath("//input[@name='q']");
    private By welcomeHeader = By.tagName("h2");
    private By logoutlink = By.linkText("Log out");

    private By searchButton = By.xpath("//button[text()='Search']");

    private By MyAccountlink = By.linkText("My account");

    //2. public page class constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }

    //3. public Page actions/ methods
    public String getHomePageTitle(){
        String Title = eleutil.waitForTitleIs(Appconstants.HOME_PAGE_TITLE,5);
        System.out.println("Home page Title :" + Title);
        return Title;
    }

    public String getHomePageURL(){
        String URL = eleutil.waitForUrlContains(Appconstants.HOME_PAGE_URL_FRACTION,5);
        System.out.println("Home page URL :" + URL);
        return URL;
    }

    public boolean isLogoutLinkExit(){

        return eleutil.ElementIsDisplayed(logoutlink);
    }

    public boolean isSearchTextBoxFieldExit(){

        return eleutil.ElementIsDisplayed(searchTextfield);
    }

    public boolean isWelcomeHeaderExit(){

        return eleutil.ElementIsDisplayed(welcomeHeader);
    }

    public boolean isMyAccountLinkExit(){

        return eleutil.ElementIsDisplayed(MyAccountlink);
    }

    public SearchResultsPage doSearch(String searchkey){
        System.out.println("searching for : " +searchkey);
        eleutil.doSendkeys(searchTextfield, searchkey);
        eleutil.doclick(searchButton);
        return new SearchResultsPage(driver);
    }


}
