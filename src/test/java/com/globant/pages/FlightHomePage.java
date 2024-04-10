package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlightHomePage extends BasePage{
    public FlightHomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".uitk-input-swapper-start-input")
    private WebElement btnLeavingFrom;

    @FindBy(css = ".uitk-fake-input.uitk-form-field-trigger[aria-label=\"Going to\"]")
    private WebElement btnGoingTo;

    @FindBy(css = "#origin_select")
    private WebElement inputLeavingFrom;

    @FindBy(css = "#destination_select")
    private WebElement inputGoingTo;

    @FindBy(css = ".uitk-fake-input.uitk-form-field-trigger[data-testid=\"uitk-date-selector-input1-default\"]")
    private WebElement btnDates;

    @FindBy(css = ".uitk-cal-controls-button-next .uitk-button-paging")
    private WebElement btnNextDates;

    @FindBy(css = ".uitk-cal-controls-button-prev .uitk-button-paging")
    private WebElement btnPreviousDates;

    @FindBy(css = "[aria-label=\"Las Vegas (LAS - All Airports) Nevada, United States\"]")
    private WebElement btnOptionLeaving;

    @FindBy(css = "[aria-label=\"Los Angeles (LAX - Los Angeles Intl.) California, United States\"]")
    private WebElement btnOptionGoingTo;

    @FindBy(css = "td.uitk-day .uitk-date-number")
    private List<WebElement> allDaysElements;

    @FindBy(css = ".uitk-button-primary.uitk-layout-flex-item")
    private WebElement btnDoneDates;

    @FindBy(css = ".uitk-menu-trigger.uitk-fake-input.uitk-form-field-trigger")
    private WebElement btnTravelers;

    @FindBy(css = "section > div:nth-child(1) .uitk-step-input-controls > button:first-child")
    private WebElement btnDecreaseAdultTraveler;

    @FindBy(css = "section > div:nth-child(1) .uitk-step-input-controls > button:last-child")
    private WebElement btnIncreaseAdultTraveler;

    @FindBy(css = "#traveler_selector_adult_step_input")
    private WebElement labelQuantityAdult;

    @FindBy(css = "#travelers_selector_done_button")
    private WebElement btnDoneTraveler;

    @FindBy(css = "#search_button")
    private WebElement btnSearch;

    @FindBy(css = ".uitk-layout-flex-flex-direction-row.uitk-layout-flex-gap-three > div:nth-child(2) div.uitk-layout-flex-item")
    private WebElement checkBoxCar;

    @FindBy(css = ".uitk-layout-flex-flex-direction-row.uitk-layout-flex-gap-three > div:nth-child(1) div.uitk-layout-flex-item")
    private WebElement checkBoxHotel;



    public void clickBtnLeavingFrom(){
        getWait().until(ExpectedConditions.visibilityOf(btnLeavingFrom));
        btnLeavingFrom.click();
    }

    public void clickCheckBoxCar(){
        getWait().until(ExpectedConditions.visibilityOf(checkBoxCar));
        checkBoxCar.click();
    }

    public void clickCheckBoxHotel(){
        getWait().until(ExpectedConditions.visibilityOf(checkBoxHotel));
        checkBoxHotel.click();
    }
    public void sendKeysLeavingFrom(String leavingFrom){
        getWait().until(ExpectedConditions.elementToBeClickable(inputLeavingFrom));
        inputLeavingFrom.click();
        inputLeavingFrom.sendKeys(leavingFrom);
    }

    public void clickOptionLeaving(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnOptionLeaving));
        btnOptionLeaving.click();
    }

    public void clickBtnGoingTo(){
        getWait().until(ExpectedConditions.visibilityOf(btnGoingTo));
        btnGoingTo.click();
    }

    public void sendKeysGoingTo(String goingTo){
        getWait().until(ExpectedConditions.elementToBeClickable(inputGoingTo));
        inputGoingTo.click();
        inputGoingTo.sendKeys(goingTo);
    }

    public void clickOptionGoingTo(){
        getWait().until(ExpectedConditions.visibilityOf(btnOptionGoingTo));
        btnOptionGoingTo.click();
    }

    public void clickBtnDates(){
        getWait().until(ExpectedConditions.visibilityOf(btnDates));
        btnDates.click();
    }

    public void clickBtnRightDates(){
        getWait().until(ExpectedConditions.visibilityOf(btnNextDates));
        btnNextDates.click();
    }

    public void clickBtnLeftDates(){
        getWait().until(ExpectedConditions.visibilityOf(btnPreviousDates));
        btnPreviousDates.click();
    }

    public void clickOnDay(String dayNumber) {
        for (WebElement dayElement : allDaysElements) {
            if (dayElement.getText().equals(dayNumber)) {
                dayElement.click();
                break;
            }
        }
    }

    public void clickOnDone(){
        getWait().until(ExpectedConditions.visibilityOf(btnDoneDates));
        btnDoneDates.click();
    }

    public void clickBtnTraveler(){
        getWait().until(ExpectedConditions.visibilityOf(btnTravelers));
        btnTravelers.click();
    }

    public void clickBtnIncreaseAdultTraveler(int i){
        getWait().until(ExpectedConditions.visibilityOf(btnIncreaseAdultTraveler));
        getWait().until(ExpectedConditions.visibilityOf(labelQuantityAdult));

        for (int j = 0; j < i; j++) {
            if (Integer.parseInt(labelQuantityAdult.getAttribute("value")) < i){
                btnIncreaseAdultTraveler.click();
            }else{
                btnDoneTraveler.click();
            }
        }
    }

    public void clickBtnSearch(){
        getWait().until(ExpectedConditions.visibilityOf(btnSearch));
        btnSearch.click();
    }

}
