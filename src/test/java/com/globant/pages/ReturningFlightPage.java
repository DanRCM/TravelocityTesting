package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class ReturningFlightPage extends BasePage{

    public ReturningFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[stid=\"select-button\"]")
    private WebElement btnSelectFlight;

    @FindBy(css = ".uitk-typelist-spacing li button")
    private List<WebElement> btnFlightOptions;

    @FindBy(css = ".uitk-spacing.uitk-spacing-margin-blockstart-unset")
    private WebElement filterBySection;

    @FindBy(css = ".uitk-field.uitk-field-select-field.has-floatedLabel-label")
    private WebElement btnSortBy;

    @FindBy(css = ".uitk-spacing-margin-blockstart-unset div fieldset")
    private List<WebElement> verifyFilterBySections;

    public void verifyFlightReturnPage(){
        getWait().until(ExpectedConditions.visibilityOf(filterBySection));
        for(WebElement element : verifyFilterBySections) {
            getWait().until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed(), "The element is not visible");
        }
    }

    public void clickBtnSelectFlight(){
        getWait().until(ExpectedConditions.visibilityOf(btnSelectFlight));
        btnSelectFlight.click();
    }

    public void chooseFlightReturnOption(int index){
        index = index-1;

        getWait().until(ExpectedConditions.visibilityOfAllElements(btnFlightOptions));
        getWait().until(ExpectedConditions.visibilityOf(btnFlightOptions.get(index)));
        btnFlightOptions.get(index).click();
        clickBtnSelectFlight();

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
