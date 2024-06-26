package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class FlightDetailsPage extends BasePage{

    @FindBy(css = ".uitk-heading-5.uitk-spacing")
    private WebElement labelPriceSummary;

    @FindBy(css = "div[data-test-id=\"journey-summary\"] > div")
    private List<WebElement> departureAndReturnInformation;

    @FindBy(css = ".uitk-typelist.uitk-typelist-orientation-inline a")
    private WebElement btnChangeFlight;

    @FindBy(css = ".uitk-card-has-overflow > div:nth-child(2) button")
    private WebElement btnCheckOut;

    @FindBy(css = ".uitk-sheet.uitk-centered-sheet-small")
    private WebElement popUpSeats;

    @FindBy(css = ".uitk-sheet.uitk-centered-sheet-small [data-stid=\"nudge-goto-checkout-button\"]")
    private WebElement btnGoToCheckOut;

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyFlightDetailsPage(){
        getWait().until(ExpectedConditions.visibilityOf(labelPriceSummary));
        Assert.assertTrue(labelPriceSummary.isDisplayed());
        for (WebElement element : departureAndReturnInformation){
            getWait().until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
        }

    }

    public void clickBtnChangeFlight(){
        getWait().until(ExpectedConditions.visibilityOf(btnChangeFlight));
        btnChangeFlight.click();
    }

    public void clickBtnCheckOut(){
        getWait().until(ExpectedConditions.visibilityOf(btnCheckOut));
        btnCheckOut.click();
    }

    public void verifyPopUpSeats(){
        if(popUpSeats.isDisplayed()){
            getWait().until(ExpectedConditions.visibilityOf(btnGoToCheckOut));
            btnGoToCheckOut.click();
        }
    }
}
