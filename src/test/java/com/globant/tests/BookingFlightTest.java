package com.globant.tests;

import org.testng.annotations.Test;

public class BookingFlightTest extends BaseTest{

    @Test
    public void bookingFlightTest(){
        homePage.selectBarOptionIndex(2);
        flightHomePage.clickBtnLeavingFrom();
        flightHomePage.sendKeysLeavingFrom("LAS");
        flightHomePage.clickOptionLeaving();
        flightHomePage.clickBtnGoingTo();
        flightHomePage.sendKeysGoingTo("LAX");
        flightHomePage.clickOptionGoingTo();
        flightHomePage.clickBtnDates();
        flightHomePage.clickBtnRightDates();
        flightHomePage.clickOnDay("26");
        flightHomePage.clickBtnRightDates();
        flightHomePage.clickOnDay("26");
        flightHomePage.clickOnDone();
        flightHomePage.clickBtnTraveler();
        flightHomePage.clickBtnIncreaseAdultTraveler(1);
        flightHomePage.clickBtnSearch();
        departingFlightPage.verifyDepartingFlightPage();
        departingFlightPage.clickBtnSortBy();
        departingFlightPage.verifySortByOptions();
        departingFlightPage.chooseFlightOption(1);
        returningFlightPage.verifyFlightReturnPage();
        returningFlightPage.chooseFlightReturnOption(3);
        returningFlightPage.switchWindow();
        flightDetailsPage.verifyFlightDetailsPage();
        flightDetailsPage.clickBtnCheckOut();
        flightDetailsPage.verifyPopUpSeats();
        paymentPage.verifyPaymentPage();
    }
}
