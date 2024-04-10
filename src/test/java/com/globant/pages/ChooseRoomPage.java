package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ChooseRoomPage extends BasePage{
    public ChooseRoomPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "main > ul > li button")
    private List<WebElement> btnChooseFlightOption;

    @FindBy(css = ".uitk-spacing-margin-medium-inline-unset > div:nth-child(1) button[type=\"submit\"]")
    private WebElement btnReserveRoom;

    @FindBy(css = "[data-stid=\"select-button\"]")
    private WebElement btnSelect;

    @FindBy(css = ".no-bullet > li:nth-child(1) button[data-stid=\"reserve-button\"]")
    private WebElement btnSelectCar;

    public void clickBtnReserve(){
        getWait().until(ExpectedConditions.visibilityOf(btnReserveRoom));
        btnReserveRoom.click();
    }

    public void clickBtnDepartingFlight(int index){
        getWait().until(ExpectedConditions.visibilityOfAllElements(btnChooseFlightOption));
        btnChooseFlightOption.get(index).click();
        clickBtnSelect();
    }

    public void clickBtnReturningFlight(int index){
        getWait().until(ExpectedConditions.visibilityOfAllElements(btnChooseFlightOption));
        btnChooseFlightOption.get(index).click();
        clickBtnSelect();
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
