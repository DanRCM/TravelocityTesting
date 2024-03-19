package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class ChooseStayPage extends BasePage{
    public ChooseStayPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".uitk-link-align-center.uitk-link-medium")
    private WebElement btnViewInMap;

    @FindBy(css = "#sort-filter-dropdown-sort")
    private WebElement btnSortBy;

    @FindBy(css = "form.uitk-form div:nth-child(2) > div:nth-child(8) h4")
    private WebElement labelStartRating;

    @FindBy(css = "form.uitk-form div:nth-child(2) > div:nth-child(9) h4")
    private WebElement labelPropertyType;

    @FindBy(css = "form.uitk-form div:nth-child(2) > div:nth-child(10) h4")
    private WebElement labelNumberBedrooms;

    @FindBy(css = "#sort-filter-dropdown-sort option:nth-child(2)")
    private WebElement btnSortByPrice;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1)")
    private WebElement btnStayOptions;

    @FindBy(css = ".uitk-spacing-padding-blockend-unset .uitk-heading-3")
    private WebElement labelTittleStay;

    @FindBy(css = "[data-stid = \"prominence-highly-rated-property\"] .uitk-badge-base-text")
    private WebElement labelStayRating;

    @FindBy(css = ".align-end .uitk-lockup-price")
    private WebElement labelPriceStay;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1) h3.uitk-layout-grid-item-has-row-start")
    private WebElement labelFromTittleStayOption;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1) .uitk-lockup-price")
    private WebElement labelFromPriceStayOption;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1) .uitk-badge-base-text")
    private WebElement labelFromStayRatingOption;

    @FindBy(css = "form.uitk-form div:nth-child(2) > div:nth-child(8) ul > div")
    private List<WebElement> btnStars;

    public void verifyStayPage(){
        getWait().until(ExpectedConditions.visibilityOf(btnViewInMap));
        getWait().until(ExpectedConditions.visibilityOf(btnSortBy));
        getWait().until(ExpectedConditions.visibilityOf(labelNumberBedrooms));
        getWait().until(ExpectedConditions.visibilityOf(labelPropertyType));
        getWait().until(ExpectedConditions.visibilityOf(labelStartRating));

        Assert.assertTrue(btnSortBy.isDisplayed());
        Assert.assertTrue(btnViewInMap.isDisplayed());
        Assert.assertTrue(labelNumberBedrooms.isDisplayed());
        Assert.assertTrue(labelPropertyType.isDisplayed());
        Assert.assertTrue(labelStartRating.isDisplayed());
    }

    public void clickBtnSortBy(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnSortBy));
        btnSortBy.click();
    }

    public void clickBtnSortByPrice(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnSortByPrice));
        btnSortByPrice.click();
    }

    public void clickBtnStarIndex(int index){
        index--;
        getWait().until(ExpectedConditions.elementToBeClickable(btnStars.get(index)));
        btnStars.get(index).click();
    }

    public void verifyOptionsStayPage(String tittle, String price, String rating){
        getWait().until(ExpectedConditions.visibilityOf(labelTittleStay));
        getWait().until(ExpectedConditions.visibilityOf(labelPriceStay));
        getWait().until(ExpectedConditions.visibilityOf(labelStayRating));

        Assert.assertEquals(labelTittleStay.getText(), tittle);
        Assert.assertEquals(labelPriceStay.getText(), price);
        Assert.assertEquals(labelStayRating.getText(), rating);
    }

    public void clickStayOption(){
        getWait().until(ExpectedConditions.visibilityOf(labelFromTittleStayOption));
        getWait().until(ExpectedConditions.visibilityOf(labelFromPriceStayOption));
        getWait().until(ExpectedConditions.visibilityOf(labelFromStayRatingOption));

        String labelTittle = labelFromTittleStayOption.getText();
        String labelPrices = labelFromPriceStayOption.getText();
        String labelStay = labelFromStayRatingOption.getText();

        getWait().until(ExpectedConditions.elementToBeClickable(btnStayOptions));
        btnStayOptions.click();

        switchWindow();

        verifyOptionsStayPage(labelTittle,labelPrices, labelStay);
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


