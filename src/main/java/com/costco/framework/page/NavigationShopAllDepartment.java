package com.costco.framework.page;

import com.costco.framework.utils.DelayUtil;
import com.costco.framework.utils.WebElementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.costco.framework.utils.WebElementUtils.delayFor;

/**
 * Created by student on 9/3/2017.
 */
public class NavigationShopAllDepartment extends PageBase {
    public NavigationShopAllDepartment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    //@FindBy (id = "navigation-dropdown")
   // private WebElement button;


    public void dropDownButtonTest1() {
        WebElement button = driver.findElement(By.xpath(".//*[@id='navigation-dropdown']"));
        button.click();

        WebElementUtils elementUtils = new WebElementUtils(driver);
        delayFor(3000);
        DelayUtil.delayFor(2000);
        WebElement buttonItem = driver.findElement((By.xpath(".//*[@id='WC_CategoriesSidebarDisplayf_links_3_2']/i")));
        elementUtils.scrollToElement(buttonItem);
        elementUtils.highlight(buttonItem);
        WebElementUtils.delayFor(2000);
        buttonItem.click();
    }
/*


    private void dropDownButtonHandle1(WebElement button, String text) {
        WebElementUtils elementUtils = new WebElementUtils(driver);
        elementUtils.scrollToElement(button);
        if (button.isDisplayed() && button.isEnabled()) button.click();
        WebElementUtils.delayFor(2000);
        WebElement buttonItem = driver.findElement((By.xpath(".//*[@id='primary-category-container']/li[2]" + "text + ")));
        elementUtils.scrollToElement(buttonItem);
        buttonItem.click();
    }

*/
    }

