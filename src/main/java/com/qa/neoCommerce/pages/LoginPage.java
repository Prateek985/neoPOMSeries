package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import com.qa.opencart.contants.Appconstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // page class/ page library/ page actions/methods
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
    public LoginPage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }

    //3. public Page actions/ methods
    public String getLoginPageTitle(){
        String Title = eleutil.waitForTitleIs(Appconstants.LOGIN_PAGE_TITLE,5);
        System.out.println("login page Title :" + Title);
        return Title;
    }

    public String getLoginPageURL(){
        String URL = eleutil.waitForUrlContains(Appconstants.LOGIN_PAGE_URL_FRACTION,5);
        System.out.println("login page URL :" + URL);
        return URL;
    }

    public boolean isForgotPwdLinkExit(){

        return eleutil.ElementIsDisplayed(forgotpwdlink);
    }


    public boolean isLoginBtnExit(){
        return eleutil.ElementIsDisplayed(loginButton);
    }

    public boolean isRegisterBtnExit(){
        return eleutil.ElementIsDisplayed(RegisterBtn);
    }

    public HomePage doLoginMethod(String Username, String pwd){
        System.out.println("user Credentils : " + Username + " & " +pwd);
        eleutil.waitForElementVisible(emailid,10).sendKeys(Username);
        eleutil.doSendkeys(password,pwd);
        eleutil.doclick(RememberMe);
        eleutil.doclick(loginButton);
        return new HomePage(driver);
    }

}
