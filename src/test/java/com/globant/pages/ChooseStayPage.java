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

    @FindBy(css = "[data-stid=\"property-listing-results\"] > div:nth-child(1) a")
    private WebElement btnStayOption;

    @FindBy(css = ".uitk-spacing-padding-blockend-unset .uitk-heading-3")
    private WebElement labelTittleStay;

    @FindBy(css = ".uitk-badge-base-text[aria-hidden=\"false\"]")
    private WebElement labelStayRating;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1) h3.uitk-layout-grid-item-has-row-start")
    private WebElement labelTittleFromStayOptionPage;
    @FindBy(css = ".uitk-spacing.uitk-spacing-margin-blockstart-unset > svg")
    private List<WebElement> starNumberFromStayOptionPage;

    @FindBy(css = "div[data-stid=\"property-listing-results\"] > div:nth-child(1) .uitk-badge-base-text[aria-hidden=\"true\"]")
    private WebElement labelRatingFromStayOptionPage;

    @FindBy(css = "form.uitk-form div:nth-child(2) > div:nth-child(8) ul > div")
    private List<WebElement> btnStars;

    public void verifyStayPage(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(btnSortBy,labelNumberBedrooms,labelPropertyType,labelStartRating,btnViewInMap));

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

    public void verifyOptionsStayPage(String tittle, int starNumber,String rating){
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelStayRating,labelTittleStay));
        getWait().until(ExpectedConditions.visibilityOfAllElements(starNumberFromStayOptionPage));

        Assert.assertEquals(labelTittleStay.getText(), tittle);
        Assert.assertEquals(starNumberFromStayOptionPage.size(), starNumber);
        Assert.assertEquals(labelStayRating.getText(), rating);
    }

    public void clickStayOption(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelTittleFromStayOptionPage,labelTittleFromStayOptionPage));

        String labelTittle = labelTittleFromStayOptionPage.getText();
        String labelStay = labelRatingFromStayOptionPage.getText();

        getWait().until(ExpectedConditions.elementToBeClickable(btnStayOption));
        btnStayOption.click();

        switchWindow();

        verifyOptionsStayPage(labelTittle, 3,labelStay);
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


