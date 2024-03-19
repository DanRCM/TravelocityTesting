package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseRoomPage extends BasePage{
    public ChooseRoomPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div [data-stid=\"section-room-list\"] > div > div:nth-child(1) button[data-stid=\"submit-hotel-reserve\"]")
    private WebElement btnReserve;

    @FindBy(css = "main > ul > li:nth-child(1) button")
    private WebElement btnDepartingFlight;

    @FindBy(css = "main > ul > li:nth-child(4) button")
    private WebElement btnReturningFlight;

    @FindBy(css = "[data-stid=\"select-button\"]")
    private WebElement btnSelect;

    @FindBy(css = ".no-bullet > li:nth-child(1) button[data-stid=\"reserve-button\"]")
    private WebElement btnSelectCar;

    public void clickBtnReserve(){
        getWait().until(ExpectedConditions.visibilityOf(btnReserve));
        btnReserve.click();
    }

    public void clickBtnDepartingFlight(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnDepartingFlight));
        btnDepartingFlight.click();
    }

    public void clickBtnReturningFlight(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnReturningFlight));
        btnReturningFlight.click();
    }

    public void clickBtnSelect(){
        getWait().until(ExpectedConditions.visibilityOf(btnSelect));
        btnSelect.click();
    }

    public void clickBtnCarReserve(){
        getWait().until(ExpectedConditions.visibilityOf(btnSelectCar));
        btnSelectCar.click();
    }
}
