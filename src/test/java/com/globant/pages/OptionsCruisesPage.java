package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class OptionsCruisesPage extends BasePage{

    public OptionsCruisesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".uitk-spacing-margin-six > div .uitk-gallery-carousel")
    private List<WebElement> btnsCruises;

    @FindBy(css = ".uitk-card-has-link .uitk-type-end .uitk-badge-base-text")
    private List<WebElement> labelDiscounts;

    @FindBy(css = "#sort-filter-dropdown-SortOption")
    private WebElement btnSort;

    @FindBy(css = "#sort-filter-dropdown-SortOption option:nth-child(1)")
    private WebElement btnSortByPrice;

//    @FindBy(css = "div .uitk-carousel-container")
//    private WebElement roomSections;
//
//    @FindBy(css = ".uitk-heading.uitk-spacing-padding-four")
//    private WebElement labelItinerary;

    public void verifyDiscountsCruises() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelDiscounts));
        Assert.assertFalse(labelDiscounts.isEmpty());
        Assert.assertTrue(btnsCruises.size()-labelDiscounts.size() != 0);
    }

    public void clickBtnSort(){
        getWait().until(ExpectedConditions.visibilityOf(btnSort));
        btnSort.click();
    }

    public void clickBtnSortByPrice(){
        getWait().until(ExpectedConditions.visibilityOf(btnSortByPrice));
        btnSortByPrice.click();
    }

    public void clickOptionCruise(int optionCruise){
        getWait().until(ExpectedConditions.visibilityOfAllElements(btnsCruises));
        btnsCruises.get(optionCruise-1).click();
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
