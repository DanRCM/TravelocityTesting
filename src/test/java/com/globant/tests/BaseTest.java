package com.globant.tests;

import com.globant.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver = new ChromeDriver();
    String url = "https://www.travelocity.com/";
    HomePage homePage= new HomePage(driver, url);
    FlightPage flightPage = new FlightPage(driver);
    DepartureInitialPage departureInitialPage = new DepartureInitialPage(driver);
    DepartureEndPage departureEndPage = new DepartureEndPage(driver);
    FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);
    ChooseStayPage chooseStayPage = new ChooseStayPage(driver);
    ChooseRoomPage chooseRoomPage = new ChooseRoomPage(driver);
    CruisesPage cruisesPage = new CruisesPage(driver);
    OptionsCruisesPage optionsCruisesPage = new OptionsCruisesPage(driver);

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
//    }
}
