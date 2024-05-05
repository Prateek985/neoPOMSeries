package com.qa.neoCommerce.base;

import com.qa.neoCommerce.factory.DriverFactory;
import com.qa.neoCommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    DriverFactory df;
    protected Properties prop;
    protected LoginPage lp;

    @BeforeTest
    public void setup(){
       df = new DriverFactory();
       prop = df.initProp();
       driver = df.initDriver(prop);
       lp = new LoginPage(driver);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
