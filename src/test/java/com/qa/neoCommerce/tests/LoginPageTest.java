package com.qa.neoCommerce.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.neoCommerce.base.BaseTest;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void LoginPageTitleTest(){
         String actualTitle = lp.getLoginPageTitle();
        Assert.assertEquals(actualTitle,"nopCommerce demo store. Login");
    }

    @Test(priority = 2)
    public void LoginPageUrlTest(){
        String actualurl = lp.getLoginPageURL();
        Assert.assertTrue(actualurl.contains("login?return"));
    }

    @Test(priority = 3)
    public void forgetPwdLinkExitTest(){
        Assert.assertTrue(lp.isForgotPwdLinkExit());
    }

    @Test(priority = 4)
    public void loginBtnExitTest(){
        Assert.assertTrue(lp.isLoginBtnExit());
    }

    @Test(priority = 5)
    public void RegisterBtnExitTest(){
        Assert.assertTrue(lp.isRegisterBtnExit());
    }

    @Test(priority = 6)
    public void loginTest(){
        String actPageTitle = lp.doLoginMethod("davidbiber214@gmail.com", "David@123");
        Assert.assertEquals(actPageTitle,"nopCommerce demo store");

    }


}
