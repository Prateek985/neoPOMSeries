package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;
    Element_utils eleutil;
    //1. Private By Locator
    private By emailid = By.id("Email");
    private By password = By.id("Password");
    private By RememberMe = By.id("RememberMe");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By forgotpwdlink = By.linkText("Forgot password?");

    private By RegisterBtn = By.xpath("//button[text()='Register']");

    //2. public page class constructor
    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }
}
