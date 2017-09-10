package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import org.testng.annotations.Test;

/**
 * Created by student on 9/1/2017.
 */
public class RegisterFunctionality extends CostcoScriptBase {

    @Test
    public void creatAccountWithValidUserAndValidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        registrationPage.navigateToCreatAccountPage();
        registrationPage.registration("moushum@yahoo.com","mamun6424","mamun6424");
        registrationPage.clickregisterlink();
        registrationPage.verifyRegistrationPageTitle();
        registrationPage.verifyRegistrationSuccess();

    }


    @Test
    public void creatAccountWithAllreadyUsedEmailAndValidPassword(){
        homePage.verifyHomePageTitle();
        homePage.navigateToLoginPage();
        registrationPage.navigateToCreatAccountPage();
        registrationPage.registration("masq@yahoo.com","mamun6424","mamun6424");
        registrationPage.clickregisterlink();
        registrationPage.verifyRegistrationPageTitle();
        registrationPage.verifyRegistrationUnsuccessMsg1();


    }



}
