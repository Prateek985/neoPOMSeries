package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import com.qa.opencart.contants.Appconstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;
    Element_utils eleutil;
    //1. Private By Locator
    private By searchproducts = By.cssSelector("div.product-item");

    //2. public page class constructor
    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }

    public int getSearchProductCount(){
        return eleutil.waitForElementsVisible(searchproducts, 10).size();
    }

    public String getSearchResultPageURL(){
        String URL = eleutil.waitForUrlContains(Appconstants.Search_PAGE_URL_FRACTION,5);
        System.out.println("Home page URL :" + URL);
        return URL;
    }
}
