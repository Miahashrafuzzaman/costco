package com.costco.framework.page;

import com.costco.framework.CostcoScriptBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by student on 9/1/2017.
 */
public class PageBase {
    protected WebDriver driver = null;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void verifyPageTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    public WebDriver getDriver()   {
        return driver;
    }


    //
//    public CostcoScriptBase(WebDriver driver) {
//        super();
//    }



//


}
