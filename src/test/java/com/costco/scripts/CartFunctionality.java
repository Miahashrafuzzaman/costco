package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import org.testng.annotations.Test;

/**
 * Created by student on 9/2/2017.
 */
public class CartFunctionality extends CostcoScriptBase{

    @Test
    public void creatAccountWithValidUserAndValidPassword(){

        homePage.verifyHomePageTitle();
        shopingCartPage.navigateToCart();
        shopingCartPage.verifyCartPageTitle();
        shopingCartPage.navigateToContinueShoppingButton();
        shopingCartPage.verifyContinueShoppingPageTitle();
        shopingCartPage.navigateToTopSellingApplicationLink();
        shopingCartPage.sortBydropDownButtonTest();
        shopingCartPage.navigateTosetSelectItemLink();
        shopingCartPage.navigateToSignInForPrice();
        loginPage.login("usa_zaman@yahoo.com","mamun6424");
        shopingCartPage.verifyLoginSuccessMsg();
        shopingCartPage.navigateToAddToCart();
        shopingCartPage.navigateToAddFinalCard();



    }
}
