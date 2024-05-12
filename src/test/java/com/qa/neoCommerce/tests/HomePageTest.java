package com.qa.neoCommerce.tests;

import com.qa.neoCommerce.base.BaseTest;
import com.qa.opencart.contants.Appconstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @BeforeClass
    public void Homesetup(){
        homepage = lp.doLoginMethod(prop.getProperty("username"), prop.getProperty("password") );

    }

    @Test(priority = 1)
    public void HomePageTitleTest(){
        String actualTitle = homepage.getHomePageTitle();
        Assert.assertEquals(actualTitle, Appconstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void HomePageUrlTest(){
        String actualurl = homepage.getHomePageURL();
        Assert.assertTrue(actualurl.contains(Appconstants.HOME_PAGE_URL_FRACTION));
    }

    @Test(priority = 3)
    public void isLogoutLinkExitTest()
    {
        Assert.assertTrue(homepage.isLogoutLinkExit());
    }


    @Test(priority = 4)
    public void isSearchTextBoxFieldExitTest() {
        Assert.assertTrue(homepage.isSearchTextBoxFieldExit());
    }

    @Test(priority = 5)
    public void isWelcomeHeaderExitTest(){
        Assert.assertTrue(homepage.isWelcomeHeaderExit());
    }

    @Test(priority = 6)
    public void isMyAccountLinkExitTest() {
        Assert.assertTrue(homepage.isMyAccountLinkExit());
    }


    @Test(priority = 6)
    public void doSearchTest() {
        homepage.doSearch("Desktop");

    }
}
