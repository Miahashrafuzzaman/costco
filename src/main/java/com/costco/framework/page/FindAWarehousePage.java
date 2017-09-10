package com.costco.framework.page;

import com.costco.framework.utils.DelayUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by student on 9/2/2017.
 */
public class FindAWarehousePage extends PageBase {
    public FindAWarehousePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);
    }

    @FindBy(id = "warehouse-locations")
    private WebElement findAWerehouse;

    public void navigateToWarehouseLink(){
        findAWerehouse.click();
    }

    @FindBy(id = "warehouse-search-field")
    private WebElement cityStateOrZip;


    public void enterCityZip(String zip){
        //cityStateOrZip.clear();
        cityStateOrZip.sendKeys(zip);
    }

    public void clickFindAWareHouse(String zip) {
        enterCityZip(zip);
        clickFindAWareHouseButton();

    }

   // @FindBy(css = ".btn.btn-primary")

    @FindBy(xpath = ".//*[@id='warehouse_locator_search']/input[8]")
    private WebElement findAWerehouseButton;



    public void verifyWarehousePageTitle(){
        DelayUtil.delayFor(3000);
        String expectedTitle = "Sheds & Barns | Costco";
        //String expectedTitle = "Offers | Costco";
        DelayUtil.delayFor(3000);
        verifyPageTitle(expectedTitle);
    }


    public void clickFindAWareHouseButton(){
        DelayUtil.delayFor(3000);
        findAWerehouseButton.click();
    }





/*
    @Test
    public void dropDownButtonTest(){
        WebElement button = driver.findElement(By.xpath("//button[@id='split-button-01']/following-sibling::button"));
        dropDownButtonHandle(button, "Action");
    }

    private void dropDownButtonHandle(WebElement button, String text){
        // WebElementUtils elementUtils
        WebElementUtils elementUtils = new WebElementUtils(driver);
        elementUtils.scrollToElement(button);
        if(button.isDisplayed()) button.click();
        WebElementUtils.delayFor(3000);
        elementUtils.scrollToElement(button);
        if(button.isDisplayed() && button.isEnabled()) button.click();
        WebElementUtils.delayFor(3000);
        WebElement buttonItem = driver.findElement((By.xpath("//button[@id='split-button-01']/following-sibling::ul/li/a[text()='" +text+"']")));
        elementUtils.scrollToElement(buttonItem);
        buttonItem.click();
    }
    */
}
