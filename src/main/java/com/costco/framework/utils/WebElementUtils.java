package com.costco.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masihur on 5/20/17.
 */
public class WebElementUtils {

    private WebDriver driver;

    public WebElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    static final Logger LOGGER = LoggerFactory.getLogger(WebElementUtils.class);

   // public WebElementUtils(WebDriver driver) {
       // super(driver);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    //}

    public void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            LOGGER.info("Element {} is highlighted", element);
            delayFor(2000);
        }
    }

    public static void delayFor(int timeinMili) {
        try {
            Thread.sleep(timeinMili);
            LOGGER.info("Execution waiting for {}", timeinMili);
        } catch (InterruptedException e) {
            LOGGER.error("Exception Occurred {}", e);
        }
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        LOGGER.info("Scroll window to visualise web element {} ", element);
        delayFor(3000);
    }


   // @Test
    public void dropDownButtonTest() {
        WebElement button = driver.findElement(By.xpath("//button[@id='split-button-05']/following-sibling::button"));
        dropDownButtonHandle1(button, "Action");
    }

    private void dropDownButtonHandle1(WebElement button, String text) {
        WebElementUtils elementUtils = new WebElementUtils(driver);
        elementUtils.scrollToElement(button);//
        if (button.isDisplayed() && button.isEnabled()) button.click();
        WebElementUtils.delayFor(2000);
        WebElement buttonItem = driver.findElement((By.xpath("//button[@id='split-button-05']/following-sibling::ul/li/a[text()='" + text + "']")));
        elementUtils.scrollToElement(buttonItem);
        buttonItem.click();
    }



/*
    List<WebElement> countryList = driver.findElements(By.id("order_bill_address_attributes_country_id"));

        for(int j = 0; j < countryList.size(); ++j) {
        if(((WebElement)countryList.get(j)).getText().contentEquals("United States of America")) {
            System.out.println(((WebElement)countryList.get(j)).getText());
            ((WebElement)countryList.get(j)).click();
            break;
        }
    }

    List<WebElement> stateList = driver.findElements(By.id("order_bill_address_attributes_state_id"));

        for(int i = 0; i < stateList.size(); ++i) {
        if(((WebElement)stateList.get(i)).getText().contentEquals("New York")) {
            System.out.println(((WebElement)stateList.get(i)).getText());
            ((WebElement)stateList.get(i)).click();
            break;
        }
    }

    */
}

