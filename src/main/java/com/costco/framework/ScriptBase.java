package com.costco.framework;

import com.costco.framework.page.PageBase;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by student on 9/1/2017.
 */
public class ScriptBase {

    protected WebDriver driver = null;

    private static final String USERNAME = "miah6";
    private static final String AUTOMATE_KEY = "CpmyGavXn3xY1A1zL5vp";
    private static final String REMOTE_HUB = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static final String LOCAL_HUB_IP = "10.10.20.70";
    //private static final String LOCAL_HUB_IP = "192.168.0.11";
    private static final String LOCAL_HUB = "http://" + LOCAL_HUB_IP + ":4444/wd/hub";





    @Parameters({ "browser" })
    @BeforeMethod
    public void beforeMethod(@Optional("ie-cloud") String browser) throws MalformedURLException {

        if (browser.contentEquals("ch")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        else if (browser.contentEquals("ff")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.contentEquals("ie")) {
            InternetExplorerDriverManager.getInstance().arch32().setup();

            //InternetExplorerDriverManager.getInstance().setup();
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            capability.setJavascriptEnabled(true);
            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capability.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
            capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

            driver = new InternetExplorerDriver(capability);
        }



        else if (browser.contentEquals("ch-grid")) {
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(LOCAL_HUB),capability);
        }
        else if (browser.contentEquals("ff-grid")) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(new URL(LOCAL_HUB),capability);
        }
        else if (browser.contentEquals("ie-grid")) {
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            capability.setJavascriptEnabled(true);
            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capability.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
            capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            driver = new RemoteWebDriver(new URL(LOCAL_HUB), capability);
        }
        else if (browser.contentEquals("ch-cloud")) {
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setCapability("browser", "Chrome");
            capability.setCapability("browser_version", "60.0");
            capability.setCapability("os", "Windows");
            capability.setCapability("os_version", "7");
            capability.setCapability("resolution", "1280x1024");
            driver = new RemoteWebDriver(new URL(REMOTE_HUB),capability);
        }
        else if (browser.contentEquals("ff-cloud")) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setCapability("browser", "Firefox");
            capability.setCapability("browser_version", "56.0 beta");
            capability.setCapability("os", "Windows");
            capability.setCapability("os_version", "7");
            capability.setCapability("resolution", "1280x1024");
            driver = new RemoteWebDriver(new URL(REMOTE_HUB),capability);
        }
        else if (browser.contentEquals("ie-cloud")) {
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            capability.setCapability("browser", "IE");
            capability.setCapability("browser_version", "11.0");
            capability.setCapability("os", "Windows");
            capability.setCapability("os_version", "7");
            capability.setCapability("resolution", "1280x1024");
            driver = new RemoteWebDriver(new URL(REMOTE_HUB), capability);
        }

    }


    /*
    public WebDriver getDriver()   {
        return driver;
    }
    private PageBase Costco = null;

    public PageBase flowers800() {
        if (Costco == null) {
            Costco = new PageBase(getDriver());
        }
        return Costco;
    }
    */

    @AfterMethod
    public void afterMethod(){
        driver.close();
       // driver.quit();

        try {
            driver.quit();
        }
        catch (Exception ex){
        }

    }


}
