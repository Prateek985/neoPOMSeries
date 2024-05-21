package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private WebDriver driver;
    Element_utils eleutil;
    //1. Private By Locator



    //2. public page class constructor
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }

    public String ShoppingCartPageTitle(){
        String Title = eleutil.waitForTitleIs("nopCommerce demo store. Shopping Cart",5);
        System.out.println("Shopping Cart page Title :" + Title);
        return Title;
    }



}
