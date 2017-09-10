package com.costco.framework.utils;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by masihur on 5/20/17.
 */
public class CustomWaitUtils {

    private WebDriver driver = null;

    private static final int DEFAULT_WAIT_TIME = 5000;

    public CustomWaitUtils(WebDriver driver){
        this.driver = driver;
    }

    /**
     *
     * @param locator
     * @return
     */
    public WebElement waitForElement(final By locator) {
        return waitForElement(locator, DEFAULT_WAIT_TIME);
    }

    /**
     *
     * @param locator
     * @param timeToWaitInSec
     * @return
     */
    public WebElement waitForElement(final By locator, int timeToWaitInSec) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(locator);
//            }
//        });
        WebElement element = wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(locator));
        return element;
    }

    /**
     *
     * @param locator
     * @return
     */
    public WebElement waitForElementDisplayed(final By locator) {
        return waitForElementDisplayed(locator, DEFAULT_WAIT_TIME);
    }

    /**
     *
     * @param locator
     * @param timeToWaitInSec
     * @return
     */
    public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSec) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                WebElement element = driver.findElement(locator);
//                if (element != null && element.isDisplayed()) {
//                    //highlight(element);
//                    return element;
//                }
//                return null;
//            }
//        });
        WebElement element = wait.until((Function<WebDriver, WebElement>) driver -> {
            WebElement element1 = driver.findElement(locator);
            if (element1 != null && element1.isDisplayed()) {
                //highlight(element);
                return element1;
            }
            return null;
        });
        return element;
    }

    /**
     *
     * @return
     */
    public FluentWait<WebDriver> fluentWait() {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(DEFAULT_WAIT_TIME, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Exception>>() {
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                    }
                }).withMessage("The message you will see in if a TimeoutException is thrown");
    }

    /**
     *
     * @param duration
     * @param timeUnit
     * @return
     */
    public FluentWait<WebDriver> fluentWait(int duration, TimeUnit timeUnit) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(duration, timeUnit)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Exception>>() {
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                    }
                });
    }
}
