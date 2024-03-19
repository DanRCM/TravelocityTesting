package com.globant.tests;

import org.testng.annotations.Test;

public class BookingFlightTest extends BaseTest{

    @Test
    public void bookingFlightTest(){
        homePage.clickBtnFlights();
        flightPage.clickBtnLeavingFrom();
        flightPage.sendKeysLeavingFrom("LAS");
        flightPage.clickOptionLeaving();
        flightPage.clickBtnGoingTo();
        flightPage.sendKeysGoingTo("LAX");
        flightPage.clickOptionGoingTo();
        flightPage.clickBtnDates();
        flightPage.clickBtnRightDates();
        flightPage.clickOnDay("26");
        flightPage.clickBtnRightDates();
        flightPage.clickOnDay("26");
        flightPage.clickOnDone();
        flightPage.clickBtnTraveler();
        flightPage.clickBtnIncreaseAdultTraveler();
        flightPage.clickBtnSearch();
        departureInitialPage.verifyDepartureInitialPage();
        departureInitialPage.clickBtnSortBy();
        departureInitialPage.verifySortByOptions();
        departureInitialPage.clickBtnDepartureToLosAngeles();
        departureEndPage.verifyDepartureEndPage();
        departureEndPage.clickBtnDepartureToLasVegas();
        departureEndPage.switchWindow();
        flightDetailsPage.verifyFlightDetailsPage();
        flightDetailsPage.clickBtnChangeFlight();
        flightDetailsPage.clickBtnCheckOut();
        flightDetailsPage.verifyPopUpSeats();
        paymentPage.verifyPaymentPage();
    }
}
