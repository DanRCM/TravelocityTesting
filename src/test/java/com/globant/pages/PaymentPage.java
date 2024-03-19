package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".faceoff-module-title-visual-alignment")
    private WebElement labelWhoIsTraveling;

    @FindBy(css = "#best-price-guarantee .alert-title")
    private WebElement labelPriceGuarantee;

    @FindBy(className = "insurance-header-title-padding")
    private WebElement labelProtectFlight;

    @FindBy(css = ".title-secure-icon")
    private WebElement labelPaymentMethod;

    @FindBy(css = ".faceoff-module-title")
    private WebElement labelSendInformation;

    public void verifyPaymentPage(){
        getWait().until(ExpectedConditions.visibilityOf(labelWhoIsTraveling));
        getWait().until(ExpectedConditions.visibilityOf(labelPriceGuarantee));
        getWait().until(ExpectedConditions.visibilityOf(labelProtectFlight));
        getWait().until(ExpectedConditions.visibilityOf(labelPaymentMethod));
        getWait().until(ExpectedConditions.visibilityOf(labelSendInformation));

        Assert.assertTrue(labelPriceGuarantee.isDisplayed());
        Assert.assertTrue(labelWhoIsTraveling.isDisplayed());
        Assert.assertTrue(labelProtectFlight.isDisplayed());
        Assert.assertTrue(labelPaymentMethod.isDisplayed());
        Assert.assertTrue(labelSendInformation.isDisplayed());
    }
}
