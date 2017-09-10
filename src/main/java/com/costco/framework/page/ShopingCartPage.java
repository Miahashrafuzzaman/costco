package com.costco.framework.page;

import com.costco.framework.utils.WebElementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static com.costco.framework.utils.WebElementUtils.delayFor;

/**
 * Created by student on 9/2/2017.
 */
public class ShopingCartPage extends PageBase {

    public ShopingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

        @FindBy (id = "cart-d")
        //id="cart-d"
        private WebElement cart;

        @FindBy(name = "continue-shopping")
        private WebElement continueshoppingButton;

        @FindBy (className = "h5-style-guide-link")
        private WebElement topSellingApplicationLInk;

        @FindBy (xpath = ".//*[@id='search-results']//div[3]/div[2]/a/img")
        //.//*[@id='search-results']//div[3]/div[2]/a/div/p[4]
        //.//*[@id='search-results']/ctl:cache/div[3]/div[2]/a/img
        private WebElement selectItemLink;

        @FindBy (id = "sign-in-to-buy")
        private WebElement signInToBuyButton;

        @FindBy (xpath = ".//*[@id='add-to-cart']/input")
        private WebElement addToCart;

        //@FindBy (id = "addRelatedItemToCartBtn_1")
        @FindBy (xpath = ".//*[@id='addRelatedItemToCartBtn_1']")
        private  WebElement addFinalCard;


        public void navigateToAddFinalCard (){
            addFinalCard.click();
        }

        public void navigateToAddToCart(){
            addToCart.click();
        }

        public void navigateToSignInForPrice (){
            signInToBuyButton.click();
        }

        public void navigateTosetSelectItemLink (){
            selectItemLink.click();

        }

    public void navigateToCart() {
        cart.click();
    }
    public void verifyCartPageTitle(){
        delayFor(3000);
       String expectedTitle = "Shopping Cart";
        delayFor(3000);
       // String expectedTitle = "Welcome to Costco Wholesale";
        verifyPageTitle(expectedTitle);
    }

    @FindBy(id = "myaccount-d")
    private WebElement signinMsgLabel;

    public void verifyLoginSuccessMsg(){
        delayFor(3000);
        String expectedSuccessMsg = "My Account ";
        delayFor(3000);
        String actualMsg = signinMsgLabel.getText();
        Assert.assertEquals(actualMsg,expectedSuccessMsg);
    }

    public void navigateToContinueShoppingButton(){
        continueshoppingButton.click();
    }

    public void verifyContinueShoppingPageTitle(){
        delayFor(3000);
        String expectedTitle = "Welcome to Costco Wholesale";
        delayFor(3000);
        verifyPageTitle(expectedTitle);
    }

    public void navigateToTopSellingApplicationLink() {
        topSellingApplicationLInk.click();
    }

    public void sortBydropDownButtonTest() {
        WebElement button = driver.findElement(By.xpath(".//*[@id='sort_by']"));
        button.click();

        WebElementUtils elementUtils = new WebElementUtils(driver);
        delayFor(3000);
        WebElement buttonItem = driver.findElement((By.xpath(".//*[@id='sort_by']/option[2]")));
        delayFor(3000);
        elementUtils.scrollToElement(buttonItem);
        elementUtils.highlight(buttonItem);
        delayFor(2000);
        buttonItem.click();
    }
    /*

    //@Test
    public void dropDownButtonTest1() {
        WebElement button = driver.findElement(By.xpath(".//*[@id='sort_by']/option[3]"));
        button.click();
        dropDownButtonHandle1(button, "Price (Low to High)");
    }

    private void dropDownButtonHandle1(WebElement button, String text) {
        WebElementUtils elementUtils = new WebElementUtils(driver);
        elementUtils.scrollToElement(button);//
        if (button.isDisplayed() && button.isEnabled()) button.click();
        WebElementUtils.delayFor(2000);
        WebElement buttonItem = driver.findElement((By.xpath(".//*[@id='sort_by']/option[3]")));
        elementUtils.scrollToElement(buttonItem);
        buttonItem.click();
    }


    */


}
