package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PaymentPageWithCar extends BasePage{

    public PaymentPageWithCar(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".car-preferences .title-main")
    private WebElement labelWhoIsDrivingCar;

    @FindBy(css = ".trip-preferences.heading-visual-alignment .title-main")
    private WebElement labelWhoIsTravelingCar;

    @FindBy(css = ".prod-total-amount")
    private WebElement labelTotalMoney;

    @FindBy(css = ".segmented-list.payments.module .title-main")
    private WebElement labelPaymentMethodCar;

    @FindBy(css = ".scroll-wrapper > header:nth-child(1) h2")
    private WebElement labelFlightInformation;


    public void verifyPaymentPageWithCar(){
        getWait().until(ExpectedConditions.visibilityOfAllElements(labelWhoIsDrivingCar,labelWhoIsTravelingCar,labelTotalMoney,labelPaymentMethodCar,labelFlightInformation));

        Assert.assertEquals(labelWhoIsDrivingCar.getText(),"Who's driving?");
        Assert.assertEquals(labelWhoIsTravelingCar.getText(),"Who's flying?");
        Assert.assertTrue(labelTotalMoney.isDisplayed());
        Assert.assertEquals(labelPaymentMethodCar.getText(),"Payment");
        Assert.assertEquals(labelFlightInformation.getText(),"Important flight information");
    }

}
