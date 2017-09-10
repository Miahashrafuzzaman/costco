package com.costco.framework.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.costco.framework.utils.DelayUtil.delayFor;

/**
 * Created by student on 9/2/2017.
 */
public class GetEmailOffer extends PageBase {
    public GetEmailOffer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy (id = "email-signup-popover")
    private WebElement getEmailOfferLink;

    @FindBy (id = "header_emailSignUpEmail")
    private WebElement enterYourEmail;

    @FindBy (id = "header_emailSignup")
    private WebElement goButton;

    public void navigateToGetEmailOfferLink(){
        getEmailOfferLink.click();
    }


    private void enterEmail (String email){
        enterYourEmail.clear();
        //enterYourEmail.click();
        enterYourEmail.sendKeys(email);
    }


    public void navigatoToGoButton(){
        goButton.click();
    }

    public void sendEmailTextBox(String email) {
        enterEmail(email);
        navigatoToGoButton();

    }
    public void varifyJoinCostcoPageTitle(){
        delayFor(3000);
        String expectedTitle = "Welcome to Costco Wholesale";
        delayFor(3000);
        //String expectedTitle = "Join Costco | Costco";
        verifyPageTitle(expectedTitle);



    }


    public void verifyForErrorMessage() {
        String text = getDriver().findElement(By.cssSelector(".signInCopy.accent")).getText();
        Assert.assertEquals("*Required", text);
    }




}
