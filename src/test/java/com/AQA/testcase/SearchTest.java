package com.AQA.testcase;

import com.AQA.common.BaseSetup;
import com.AQA.common.BasePage;
import com.AQA.common.SortProduct;
import com.AQA.pages.Products;
import com.AQA.pages.EbayPage;
import com.AQA.pages.AmazonPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTest extends BaseSetup {

    public String key = "iphone 11";
    public String titleEbay = "Electronics, Cars, Fashion, Collectibles & More | eBay";
    public String titleAmazon = "Amazon.com. Spend less. Smile more.";

    EbayPage ebayPage1 = new EbayPage(driver);
    AmazonPage amazon1 = new AmazonPage(driver);
    Products webs = new Products();

    List<Products> result = new ArrayList<>();
    List<Products> resultAll = new ArrayList<>();

    @Test
    public void searchProduct()
    {
        ebayPage1.openURL(driver, webs.ebayURL );
        ebayPage1.getTitle(driver, titleEbay);
        ebayPage1.keyWord(driver, ebayPage1.inputSearch, key);
        ebayPage1.click(driver, ebayPage1.btnSearch);
        ebayPage1.verifySearch(driver, ebayPage1.verifyResultSearch);
        result = ebayPage1.getProductEbay(driver);
        resultAll.addAll(result);

        amazon1.openURL(driver,webs.amazonURL);
        amazon1.getTitle(driver, titleAmazon);
        amazon1.keyWord(driver, amazon1.inputSearch, key);
        amazon1.click(driver, amazon1.btnSearch);
        amazon1.verifySearch(driver, amazon1.verifyResultSearch);
        result = amazon1.getProductAmazon(driver);
        resultAll.addAll(result);

        Collections.sort(resultAll, new SortProduct());
        amazon1.printProduct(resultAll);

    }




}
