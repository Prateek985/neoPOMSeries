package com.qa.neoCommerce.tests;

import com.qa.neoCommerce.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {

    @BeforeClass
    public void productInfoSetup(){
        homepage = lp.doLoginMethod(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void ProductInfoPageHeaderTest(){
        searchresult = homepage.doSearch("Desktop");
        productpage = searchresult.selectProduct("Lenovo IdeaCentre 600 All-in-One PC");
        String ProductHeader = productpage.getproductHeader();
        Assert.assertEquals(ProductHeader,"Lenovo IdeaCentre 600 All-in-One PC");
    }

    @Test
    public void ProductInfoPageImageCountTest(){
        searchresult = homepage.doSearch("Desktop");
        productpage = searchresult.selectProduct("Lenovo IdeaCentre 600 All-in-One PC");
        Assert.assertEquals(productpage.getproductImageCount(),1);
    }

    @Test
    public void ProductInfoPagePriceTest(){
        searchresult = homepage.doSearch("Desktop");
        productpage = searchresult.selectProduct("Lenovo IdeaCentre 600 All-in-One PC");
        Assert.assertEquals(productpage.getproductPrice(),"$500.00");
    }

    @Test
    public void ProductInfoPagecartMessageTest(){
        searchresult = homepage.doSearch("Desktop");
        productpage = searchresult.selectProduct("Lenovo IdeaCentre 600 All-in-One PC");
        Assert.assertEquals(productpage.doAddToCart(),"The product has been added to your shopping cart");
    }

    @Test
    public void ShoppingcartTest(){
        shoppingcart = productpage.doShoppingcart();
        Assert.assertEquals(shoppingcart.ShoppingCartPageTitle(),"nopCommerce demo store. Shopping Cart");
    }




}
