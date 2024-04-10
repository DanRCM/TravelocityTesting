package com.globant.tests;

import org.testng.annotations.Test;

public class CruisesDiscountTest extends BaseTest {

    @Test
    public void DiscountTest(){
        homePage.selectBarOptionIndex(6);
        cruisesOptionsPage.clickBtnGoingTo();
        cruisesOptionsPage.sendKeysGoingTo("Europe");
        cruisesOptionsPage.clickOptionGoingTo();
        cruisesOptionsPage.clickDoneGoingTo();
        cruisesOptionsPage.clickBtnDates();
        cruisesOptionsPage.clickBtnRightDates();
        cruisesOptionsPage.clickOnDay("13");
        cruisesOptionsPage.clickOnDay("26");
        cruisesOptionsPage.clickBtnDoneDates();
        cruisesOptionsPage.clickBtnDuration();
        cruisesOptionsPage.SendMinDuration("10");
        cruisesOptionsPage.SendMaxDuration("14");
        cruisesOptionsPage.clickBtnDoneDuration();
        cruisesOptionsPage.verifyMinAndMaxDuration("10","14");
        cruisesOptionsPage.clickBtnSearch();
        optionsCruisesPage.verifyDiscountsCruises();
        optionsCruisesPage.clickBtnSort();
        optionsCruisesPage.clickBtnSortByPrice();
        optionsCruisesPage.clickOptionCruise(1);
        optionsCruisesPage.switchWindow();
        cruisePage.verifyResultCruisesPage();
    }
}
