package com.globant.pages;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, String url){
        super(driver);
        super.driver.get(url);
    }

    @FindBy(css = "ul.uitk-tabs li a")
    private List<WebElement> homeOptions;

    public void selectBarOptionIndex(int index){
        index = index - 1;
        getWait().until(ExpectedConditions.visibilityOfAllElements(homeOptions));

        homeOptions.get(index).click();
        Assert.assertEquals("true", homeOptions.get(index).getAttribute("aria-selected"));
    }
}
