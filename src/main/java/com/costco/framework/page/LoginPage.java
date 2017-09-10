package com.costco.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.costco.framework.utils.WebElementUtils.delayFor;

/**
 * Created by student on 9/1/2017.
 */
public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy(id="logonId")
    private WebElement emailTextbox;

    @FindBy(id="logonPassword")
    private WebElement passwordTextbox;

    @FindBy(css = ".primary")
    private WebElement signInButton;

    public void enterEmail(String email){
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void clickLogin(){
        signInButton.click();
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public void verifyLoginPageTitle(){
        delayFor(3000);
            //String expectedTitle = "Welcome to Costco Wholesale";
        String expectedTitle = "Sign In";
        delayFor(3000);
        verifyPageTitle(expectedTitle);
    }

}
