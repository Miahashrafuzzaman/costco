package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import com.costco.framework.page.FindAWarehousePage;
import org.testng.annotations.Test;

/**
 * Created by student on 9/2/2017.
 */
public class WarehouseLInkFunctionality extends CostcoScriptBase {
    @Test
    public void creatAccountWithValidUserAndValidPassword(){

        homePage.verifyHomePageTitle();
        findAWarehousePage.navigateToWarehouseLink();
        findAWarehousePage.clickFindAWareHouse("11377");

        findAWarehousePage.clickFindAWareHouseButton();
        findAWarehousePage.verifyWarehousePageTitle();
    }
}
