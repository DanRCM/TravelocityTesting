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

    @FindBy(css = ".your-price-summary")
    private WebElement labelPriceSummary;

    @FindBy(css = ".title-main .insurance-header-title-padding")
    private WebElement labelProtectYourFlight;

    @FindBy(css = ".title-secure-icon")
    private WebElement labelPayMethod;

    @FindBy(css= ".product-title")
    private WebElement labelRoundTrip;


    public void verifyPaymentPage(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelWhoIsTraveling,labelPriceSummary,labelProtectYourFlight,labelPayMethod,labelRoundTrip));

        Assert.assertEquals(labelPriceSummary.getText(),"Your price summary");
        Assert.assertEquals(labelWhoIsTraveling.getText(),"Who's traveling?");
        Assert.assertEquals(labelRoundTrip.getText(), "Roundtrip flight");
        Assert.assertEquals(labelProtectYourFlight.getText(),"Protect your trip");
        Assert.assertEquals(labelPayMethod.getText(),"How would you like to pay?");
    }
}
