package com.costco.framework;

import com.costco.framework.page.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 9/1/2017.
 */
public class CostcoScriptBase extends ScriptBase {


    private static String SPREE_URL = "https://www.costco.com/";

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected ShopingCartPage shopingCartPage;
    protected FindAWarehousePage findAWarehousePage;
    protected GetEmailOffer getEmailOffer;
    protected NavigationShopAllDepartment navigationShopAllDepartment;

    @Parameters({ "browser" })
    @BeforeMethod
    @Override
    public void beforeMethod(@Optional("ie-cloud") String browser) throws MalformedURLException {
        super.beforeMethod(browser);

        driver.navigate().to(SPREE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        shopingCartPage = new ShopingCartPage(driver);
        findAWarehousePage = new FindAWarehousePage(driver);
        getEmailOffer = new GetEmailOffer(driver);
        navigationShopAllDepartment = new NavigationShopAllDepartment(driver);
    }




}