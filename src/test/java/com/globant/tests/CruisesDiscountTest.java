package com.globant.tests;

import org.testng.annotations.Test;

public class CruisesDiscountTest extends BaseTest {

    @Test
    public void DiscountTest(){
        homePage.clickBtnCruises();
        cruisesPage.clickBtnGoingTo();
        cruisesPage.sendKeysGoingTo("Europe");
        cruisesPage.clickOptionGoingTo();
        cruisesPage.clickDoneGoingTo();
        cruisesPage.clickBtnDates();
        cruisesPage.clickBtnRightDates();
        cruisesPage.clickOnDay("13");
        cruisesPage.clickOnDay("26");
        cruisesPage.clickBtnDoneDates();
        cruisesPage.clickBtnDuration();
        cruisesPage.SendMinDuration("10");
        cruisesPage.SendMaxDuration("14");
        cruisesPage.clickBtnDoneDuration();
        cruisesPage.clickBtnSearch();
        optionsCruisesPage.verifyDiscountsCruises();
        optionsCruisesPage.clickOptionCruise(1);
    }
}
