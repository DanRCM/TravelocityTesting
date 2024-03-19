package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class OptionsCruisesPage extends BasePage{

    public OptionsCruisesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".uitk-spacing-margin-six > div .uitk-gallery-carousel")
    private List<WebElement> btnsCruises;

    @FindBy(css = ".uitk-spacing-margin-six > div span.uitk-badge-base-text")
    private List<WebElement> labelDiscounts;

    @FindBy(css = "#sort-filter-dropdown-SortOption")
    private WebElement btnSort;

    @FindBy(css = "#sort-filter-dropdown-SortOption option:nth-child(1)")
    private WebElement btnSortByPrice;

    public void verifyDiscountsCruises() {
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelDiscounts));
        Assert.assertFalse(labelDiscounts.isEmpty());
        System.out.println(labelDiscounts.size());
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
        btnsCruises.get(optionCruise).click();
    }

}
