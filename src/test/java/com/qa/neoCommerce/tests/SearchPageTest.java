package com.qa.neoCommerce.tests;

import com.qa.neoCommerce.base.BaseTest;
import com.qa.opencart.contants.Appconstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @BeforeClass
    public void SearchResultsetup() {
        homepage = lp.doLoginMethod(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void searchResultsImageCountTest(){
        searchresult = homepage.doSearch("Desktop");
        Assert.assertEquals(searchresult.getSearchProductCount(),3);
    }

    @Test
    public void searchResultsURLPageTest(){
        String searchURL = searchresult.getSearchResultPageURL();
        Assert.assertTrue(searchURL.contains(Appconstants.Search_PAGE_URL_FRACTION));

    }
}

