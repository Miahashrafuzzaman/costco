package com.costco.framework.page;

import com.costco.framework.utils.DelayUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.costco.framework.utils.WebElementUtils.delayFor;

/**
 * Created by student on 9/1/2017.
 */
public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy(id = "header_sign_in")
    private WebElement signinlink;

   // @FindBy(css= ".btn.costco-button.tertiary")
    //private WebElement creatAccount;

    @FindBy (id = "register_email1")
    private WebElement emailAddress;

    @FindBy (id = "logonPassword")
    private  WebElement passwordTextbox;

    @FindBy (id = "logonPasswordVerify")
    private WebElement confirmPassword;

    @FindBy (xpath = ".//*[@id='RegisterForm']/fieldset/div[7]/input")
    private WebElement registerButton;

    @FindBy(id = "myaccount-d")
    private WebElement creatAccountMsgLabel;

    @FindBy(xpath= ".//*[@id='LogonForm']/fieldset/div[8]/a")
    private WebElement creatAccount;

    public void navigateToLoginPage(){
        signinlink.click();
    }

    public void navigateToCreatAccountPage(){
        creatAccount.click();
    }

    public void enterEmail(String email){
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmpassword){
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmpassword);
    }

    public void clickregisterlink(){
        registerButton.click();
    }


    public void registration(String email, String password, String confirmpassword ){
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmpassword);
        clickregisterlink();
    }

    public void verifyRegistrationPageTitle(){
        delayFor(3000);
        String expectedTitle = "Register Account";
        //String expectedTitle = "Sign In";
        delayFor(3000);

        verifyPageTitle(expectedTitle);
    }

    public void verifyRegistrationSuccess(){
        String expectedSuccessMsg = "My Account ";
        String actualMsg = creatAccountMsgLabel.getText();
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }

    public void verifyRegistrationUnsuccessMsg(){
        String expectedSuccessMsg = "Enter a valid email address";
        String actualMsg = creatAccountMsgLabel.getText();
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }
/*
    public void verifyRegistrationUnsuccessMsg1(){
        String expectedSuccessMsg = "Enter a valid email address";
        String actualMsg = creatAccountMsgLabel.getText();
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }


    public void verifyRegistrationUnsuccessMsg1(){
        String expectedSuccessMsg = "The e-mail address you have chosen is already in use. Please choose a different e-mail address.";
        String actualMsg = creatAccountMsgLabel.getText();
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }

*/

    public void verifyRegistrationUnsuccessMsg1() {
        DelayUtil.delayFor(3000);
        String text = getDriver().findElement(By.xpath(".//*[@id='register']/div/div/div[1]")).getText();
        DelayUtil.delayFor(3000);
        Assert.assertEquals("The e-mail address you have chosen is already in use. Please choose a different e-mail address.", text);
    }



}
