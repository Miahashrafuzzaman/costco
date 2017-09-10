package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import org.testng.annotations.Test;

/**
 * Created by student on 9/1/2017.
 */
public class SigninFunctionality extends CostcoScriptBase {
    @Test
    public void validUserAndValidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        loginPage.verifyLoginPageTitle();
        loginPage.login("usa_zaman@yahoo.com","mamun6424");
        homePage.verifyLoginSuccess();
    }
/*
    @Test
    public void validUserAndInvalidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        loginPage.verifyLoginPageTitle();
        loginPage.login("usa_zaman@yahoo.com","mamun642");
       // homePage.verifyLoginSuccess();
        homePage.verifyLoginUnsuccess();
    }

    @Test
    public void InvalidUserAndValidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        loginPage.verifyLoginPageTitle();
        loginPage.login("usa_zam@yahoo.com","mamun6424");
        // homePage.verifyLoginSuccess();
        homePage.verifyLoginUnsuccess();
    }
/*
    @Test
    public void InvalidUserAndInvalidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        loginPage.verifyLoginPageTitle();
        loginPage.login("usa_zam@yahoo.com","mamun642");
        // homePage.verifyLoginSuccess();
        homePage.verifyLoginUnsuccess();
    }
*/
}
