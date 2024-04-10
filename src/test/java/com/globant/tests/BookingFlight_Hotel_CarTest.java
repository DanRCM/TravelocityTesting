package com.globant.tests;

import org.testng.annotations.Test;

public class BookingFlight_Hotel_CarTest extends BaseTest{

    @Test
    public void Flight_Hotel_Car_Test(){
        homePage.selectBarOptionIndex(2);
        flightHomePage.clickBtnLeavingFrom();
        flightHomePage.sendKeysLeavingFrom("LAS");
        flightHomePage.clickOptionLeaving();
        flightHomePage.clickBtnGoingTo();
        flightHomePage.sendKeysGoingTo("LAX");
        flightHomePage.clickOptionGoingTo();
        flightHomePage.clickCheckBoxCar();
        flightHomePage.clickCheckBoxHotel();
        flightHomePage.clickBtnDates();
        flightHomePage.clickBtnRightDates();
        flightHomePage.clickBtnRightDates();
        flightHomePage.clickOnDay("13");
        flightHomePage.clickOnDay("26");
        flightHomePage.clickOnDone();
        flightHomePage.clickBtnTraveler();
        flightHomePage.clickBtnIncreaseAdultTraveler(1);
        flightHomePage.clickBtnSearch();
        chooseStayPage.verifyStayPage();
        chooseStayPage.clickBtnSortBy();
        chooseStayPage.clickBtnSortByPrice();
        chooseStayPage.clickBtnStarIndex(3);
        chooseStayPage.clickStayOption();
        chooseRoomPage.clickBtnReserve();
        chooseRoomPage.clickBtnDepartingFlight(1);
        chooseRoomPage.clickBtnReturningFlight(3);
        chooseRoomPage.clickBtnCarReserve();
        paymentPageWithCar.verifyPaymentPageWithCar();
    }
}
