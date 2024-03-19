package com.globant.tests;

import org.testng.annotations.Test;

public class BookingFlight_Hotel_CarTest extends BaseTest{

    @Test
    public void Flight_Hotel_Car_Test(){
        homePage.clickBtnFlights();
        flightPage.clickBtnLeavingFrom();
        flightPage.sendKeysLeavingFrom("LAS");
        flightPage.clickOptionLeaving();
        flightPage.clickBtnGoingTo();
        flightPage.sendKeysGoingTo("LAX");
        flightPage.clickOptionGoingTo();
        flightPage.clickCheckBoxCar();
        flightPage.clickCheckBoxHotel();
        flightPage.clickBtnDates();
        flightPage.clickBtnRightDates();
        flightPage.clickBtnRightDates();
        flightPage.clickOnDay("13");
        flightPage.clickOnDay("26");
        flightPage.clickOnDone();
        flightPage.clickBtnTraveler();
        flightPage.clickBtnIncreaseAdultTraveler();
        flightPage.clickBtnSearch();
        chooseStayPage.verifyStayPage();
        chooseStayPage.clickBtnSortBy();
        chooseStayPage.clickBtnSortByPrice();
        chooseStayPage.clickBtnStarIndex(3);
        chooseStayPage.clickStayOption();
        chooseRoomPage.clickBtnReserve();
        chooseRoomPage.clickBtnDepartingFlight();
        chooseRoomPage.clickBtnSelect();
        chooseRoomPage.clickBtnReturningFlight();
        chooseRoomPage.clickBtnSelect();
        chooseRoomPage.clickBtnCarReserve();
        paymentPage.verifyPaymentPage();
    }
}
