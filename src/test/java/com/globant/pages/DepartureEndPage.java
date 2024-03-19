package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Set;

public class DepartureEndPage extends BasePage{

    public DepartureEndPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[data-stid=\"fare-card\"] .uitk-button-primary")
    private WebElement btnSelectFlight;

    @FindBy(css = "li:nth-child(4) div button")
    private WebElement btnDepartureToLasVegas;

    @FindBy(css = ".uitk-field.uitk-field-select-field.has-floatedLabel-label")
    private WebElement btnSortBy;

    @FindBy(css = ".uitk-form div > div:nth-child(5) h4")
    private WebElement labelDepartureTime;

    @FindBy(css = ".uitk-form div > div:nth-child(6) h4")
    private WebElement labelArrivalTime;

    public void verifyDepartureEndPage(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnSortBy));
        getWait().until(ExpectedConditions.visibilityOf(labelArrivalTime));
        getWait().until(ExpectedConditions.visibilityOf(labelDepartureTime));

        Assert.assertTrue(btnSortBy.isDisplayed(), "The element is not visible");
        Assert.assertTrue(labelArrivalTime.isDisplayed(), "The element is not visible");
        Assert.assertTrue(labelDepartureTime.isDisplayed(), "The element is not visible");
    }

    public void clickBtnDepartureToLasVegas(){
        getWait().until(ExpectedConditions.visibilityOf(btnDepartureToLasVegas));
        btnDepartureToLasVegas.click();
        getWait().until(ExpectedConditions.visibilityOf(btnSelectFlight));
        btnSelectFlight.click();
    }

    public void switchWindow() {
        getWait().until(ExpectedConditions.numberOfWindowsToBe(2));

        String originalwindowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(originalwindowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
