package com.qa.neoCommerce.pages;

import com.qa.neoCommerce.Utils.Element_utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage {

    private WebDriver driver;
    Element_utils eleutil;
    //1. Private By Locator
    private By productHeader = By.tagName("h1");
    private By ImageCount = By.cssSelector("div.picture-gallery img");

    private By productPrice = By.cssSelector("div.product-price");

    private By AddtocartButton = By.xpath("(//button[text()='Add to cart'])[1]");

    private By AddtocartMessage = By.xpath("//div[contains(@class,'success')]/p[text()='The product has been added to your ']");

    private By shoppingCart = By.linkText("shopping cart");

    //2. public page class constructor
    public ProductInfoPage(WebDriver driver){
        this.driver = driver;
        eleutil = new Element_utils(driver);
    }

    public String getproductHeader(){
        String Header = eleutil.dogetText(productHeader);
        System.out.println(Header);
        return Header;
    }

    public int getproductImageCount(){
        int totalimage = eleutil.waitForElementsVisible(ImageCount,10).size();
        System.out.println("Image Count for " + getproductHeader() + " : " +totalimage);
        return totalimage;
    }

    public String getproductPrice(){
        String productprice = eleutil.dogetText(productPrice);
        System.out.println("Product price for " + getproductHeader() + " : " +productprice);
        return productprice;
    }

    public String doAddToCart(){
        eleutil.doclick(AddtocartButton);
        String cartMsg = eleutil.waitForElementVisible(AddtocartMessage,10).getText();
        System.out.println("Add to Cart Message:" + cartMsg);
        return cartMsg;

    }

    public ShoppingCartPage doShoppingcart(){
        eleutil.doclick(shoppingCart,10);
        return new ShoppingCartPage(driver);
    }

}
