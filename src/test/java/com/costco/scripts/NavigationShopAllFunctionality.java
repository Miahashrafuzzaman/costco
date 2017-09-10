package com.costco.scripts;

import com.costco.framework.CostcoScriptBase;
import org.testng.annotations.Test;

/**
 * Created by student on 9/3/2017.
 */
public class NavigationShopAllFunctionality extends CostcoScriptBase {


    @Test
    public void alidEmail(){
       homePage.verifyHomePageTitle();
       navigationShopAllDepartment.dropDownButtonTest1();

    }
}
