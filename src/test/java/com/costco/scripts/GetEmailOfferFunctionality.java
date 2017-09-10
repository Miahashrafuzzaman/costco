package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import org.testng.annotations.Test;

/**
 * Created by student on 9/2/2017.
 */
public class GetEmailOfferFunctionality extends CostcoScriptBase {

    @Test
    public void getEmailOfferWithValidEmail(){
        homePage.verifyHomePageTitle();
        getEmailOffer.navigateToGetEmailOfferLink();
        getEmailOffer.sendEmailTextBox("usa_zaman@yahoo.com");
        getEmailOffer.navigatoToGoButton();
       // getEmailOffer.navigatoToGoButton();
        getEmailOffer.varifyJoinCostcoPageTitle();

        //findAWarehousePage.verifyWarehousePageTitle();
    }



}
