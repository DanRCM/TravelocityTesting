package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class DepartingFlightPage extends BasePage{

    public DepartingFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".uitk-field.uitk-field-select-field.has-floatedLabel-label")
    private WebElement btnSortBy;

    @FindBy(css = ".uitk-field-select-field select option")
    private List<WebElement> btnOptionsSortBy;

    @FindBy(css = ".uitk-typelist-spacing li button")
    private List<WebElement> btnFlightOptions;

    @FindBy(css = ".uitk-field-select-field select option:nth-child(3)")
    private WebElement btnSortByDurationShort;

    @FindBy(css = ".uitk-form > div > div:nth-child(4) .uitk-spacing-margin-blockend-two")
    private WebElement labelTravelAndBaggage;

    @FindBy(css = ".uitk-form div > div:nth-child(5) h4")
    private WebElement labelDepartureTime;

    @FindBy(css = ".uitk-form div > div:nth-child(6) h4")
    private WebElement labelArrivalTime;

    @FindBy(css = "[stid=\"select-button\"]")
    private WebElement btnSelectFlight;

    public void verifyDepartingFlightPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnSortBy));
        getWait().until(ExpectedConditions.visibilityOf(labelArrivalTime));
        getWait().until(ExpectedConditions.visibilityOf(labelDepartureTime));

        Assert.assertTrue(btnSortBy.isDisplayed(), "The element is not visible");
        Assert.assertTrue(labelArrivalTime.isDisplayed(), "The element is not visible");
        Assert.assertTrue(labelDepartureTime.isDisplayed(), "The element is not visible");
    }

    public void clickBtnSortBy(){
        getWait().until(ExpectedConditions.visibilityOf(btnSortBy));
        btnSortBy.click();
    }

    public void clickBtnSortByDurationShort(){
        getWait().until(ExpectedConditions.visibilityOf(btnSortByDurationShort));
        btnSortByDurationShort.click();
    }

    public void verifySortByOptions(){
        for(WebElement element: btnOptionsSortBy) {
            getWait().until(ExpectedConditions.visibilityOf(labelTravelAndBaggage));
            getWait().until(ExpectedConditions.elementToBeClickable(btnSortBy));
            getWait().until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Assert.assertTrue(btnSortBy.isDisplayed());
            Assert.assertTrue(labelTravelAndBaggage.isDisplayed());
        }
        clickBtnSortByDurationShort();
    }

    public void btnSelectFlight(){
        getWait().until(ExpectedConditions.visibilityOf(btnSelectFlight));
        btnSelectFlight.click();
    }

    public void chooseFlightOption(int index){
        index = index-1;

        getWait().until(ExpectedConditions.visibilityOfAllElements(btnFlightOptions));
        getWait().until(ExpectedConditions.visibilityOf(btnFlightOptions.get(index)));
        btnFlightOptions.get(index).click();
        btnSelectFlight();
    }
}
