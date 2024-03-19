package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, String url){
        super(driver);
        super.driver.get(url);
    }

    @FindBy(css = ".uitk-tabs-container ul > li:nth-child(2) a")
    private WebElement btnFlights;

    @FindBy(css = ".uitk-tabs-container ul > li:nth-child(6) a")
    private WebElement btnCruises;

    public void verifyFlightsSection(){
        getWait().until(ExpectedConditions.visibilityOf(btnFlights));
        String estate = btnFlights.getAttribute("aria-selected");
        Assert.assertEquals("true", estate);
    }

    public void clickBtnFlights(){
        getWait().until(ExpectedConditions.visibilityOf(btnFlights));
        btnFlights.click();
        verifyFlightsSection();
    }

    public void clickBtnCruises(){
        getWait().until(ExpectedConditions.visibilityOf(btnCruises));
        btnCruises.click();
    }

}
