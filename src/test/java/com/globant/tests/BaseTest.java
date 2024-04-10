package com.globant.tests;

import com.globant.pages.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver = new ChromeDriver();
    String url = "https://www.travelocity.com/";
    HomePage homePage= new HomePage(driver, url);
    FlightHomePage flightHomePage = new FlightHomePage(driver);
    DepartingFlightPage departingFlightPage = new DepartingFlightPage(driver);
    ReturningFlightPage returningFlightPage = new ReturningFlightPage(driver);
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);
    PaymentPageWithCar paymentPageWithCar = new PaymentPageWithCar(driver);
    ChooseStayPage chooseStayPage = new ChooseStayPage(driver);
    ChooseRoomPage chooseRoomPage = new ChooseRoomPage(driver);
    CruisesOptionsPage cruisesOptionsPage = new CruisesOptionsPage(driver);
    OptionsCruisesPage optionsCruisesPage = new OptionsCruisesPage(driver);
    CruisePage cruisePage = new CruisePage(driver);

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeTest
    public void setUp(){
        homePage = new HomePage(getDriver(), url);
    }

//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//        Allure.getLifecycle().fireReport();
//    }
}
