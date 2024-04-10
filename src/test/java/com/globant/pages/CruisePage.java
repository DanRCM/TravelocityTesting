package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Set;

public class CruisePage extends BasePage{
    public CruisePage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div .uitk-carousel-container")
    private WebElement roomSections;

    @FindBy(css = ".uitk-heading.uitk-spacing-padding-four")
    private WebElement labelItinerary;

    public void verifyResultCruisesPage(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(roomSections,labelItinerary));
        Assert.assertTrue(roomSections.isDisplayed());
        Assert.assertEquals(labelItinerary.getText(), "Itinerary");
    }
}
