package com.costco.framework.page;

import com.costco.framework.utils.DelayUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.costco.framework.utils.DelayUtil.delayFor;

/**
 * Created by student on 9/1/2017.
 */
public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy(id = "header_sign_in")
    private WebElement signinlink;

    @FindBy(id = "myaccount-d")
    private WebElement signinMsgLabel;

    public void navigateToLoginPage(){
        signinlink.click();
    }
    public void verifyHomePageTitle(){
        delayFor(3000);
        String expectedTitle = "Welcome to Costco Wholesale";
        delayFor(3000);
       // String expectedTitle = "Sign In";
       verifyPageTitle(expectedTitle);
    }
    public void verifyLoginSuccess(){
        delayFor(3000);
        String expectedSuccessMsg = "My Account ";
        delayFor(3000);
        String actualMsg = signinMsgLabel.getText();
        delayFor(1000);
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }
    public void verifyLoginUnsuccess() {
        DelayUtil.delayFor(3000);
        String text = getDriver().findElement(By.xpath(".//*[@id='logon']/div/div/div[1]")).getText();
        DelayUtil.delayFor(3000);
        Assert.assertEquals("The email address and/or password you entered are invalid.", text);
    }




}
