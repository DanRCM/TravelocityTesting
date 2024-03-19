package com.globant.pages;

import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CruisesPage extends BasePage{

    public CruisesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[aria-label=\"Going to,\"]")
    private WebElement btnGoingTo;

    @FindBy(css = "#destination_form_field")
    private WebElement inputGoingTo;

    @FindBy(css = "ul.uitk-action-list > li:nth-child(2) button")
    private WebElement btnOptionGoingTo;

//    @FindBy(css = "ul.uitk-action-list > li:nth-child(2) .typeahead-custom-truncate span")
//    private WebElement labelOptionGoingTo;

    @FindBy(css = ".uitk-button-primary.uitk-layout-flex-item")
    private WebElement btnDoneGoingTo;

    @FindBy(css = ".uitk-fake-input.uitk-form-field-trigger[data-testid=\"uitk-date-selector-input1-default\"]")
    private WebElement btnDates;

    @FindBy(css = ".uitk-cal-controls-button-next .uitk-button-paging")
    private WebElement btnNextDates;

    @FindBy(css = ".uitk-cal-controls-button-prev .uitk-button-paging")
    private WebElement btnPreviousDates;

    @FindBy(css = "td.uitk-day .uitk-date-number")
    private List<WebElement> allDaysElements;

    @FindBy(css = ".uitk-button-primary.uitk-layout-flex-item")
    private WebElement btnDoneDates;

    @FindBy(css = ".uitk-menu-trigger[name]")
    private WebElement btnDuration;

    @FindBy(css = "#duration_span_selector_min_input")
    private WebElement inputMinNights;

    @FindBy(css = "#duration_span_selector_max_input")
    private WebElement inputMaxNights;

    @FindBy(css = "#duration_span_selector_done_button")
    private WebElement btnDoneDuration;

    @FindBy(css = "#search_button")
    private WebElement btnSearch;

    public void clickBtnGoingTo(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnGoingTo));
        btnGoingTo.click();
    }

    public void sendKeysGoingTo(String goingTo){
        getWait().until(ExpectedConditions.elementToBeClickable(inputGoingTo));
        inputGoingTo.sendKeys(goingTo);
        getWait().until(ExpectedConditions.attributeContains(btnOptionGoingTo, "aria-label", goingTo));
    }

    public void clickOptionGoingTo(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnOptionGoingTo));
        btnOptionGoingTo.click();
    }

    public void clickDoneGoingTo(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnDoneGoingTo));
        btnDoneGoingTo.click();
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
    public void clickBtnDoneDates(){
        getWait().until(ExpectedConditions.visibilityOf(btnDoneDates));
        btnDoneDates.click();
    }

    public void clickBtnDuration(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnDuration));
        btnDuration.click();
    }

    public void SendMinDuration(String min){
        getWait().until(ExpectedConditions.elementToBeClickable(inputMinNights));
        inputMinNights.clear();
        inputMinNights.sendKeys(min);
    }

    public void SendMaxDuration(String max){
        getWait().until(ExpectedConditions.elementToBeClickable(inputMaxNights));
        inputMaxNights.clear();
        inputMaxNights.sendKeys(max);
    }

    public void clickBtnDoneDuration(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnDoneDuration));
        btnDoneDuration.click();
    }

    public void clickBtnSearch(){
        getWait().until(ExpectedConditions.visibilityOf(btnSearch));
        btnSearch.click();
    }
}
