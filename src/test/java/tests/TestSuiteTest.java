package tests;

import models.TestSuite;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import pages.TestSuiteManagementPage;

import java.util.concurrent.TimeUnit;



public class TestSuiteTest {

    WebDriver driver;

    @BeforeTest
    public void userLogin() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new User());
    }


    @Test
    public void positiveTestSuiteTest() {
        TestlinkHomePage homepage = new TestlinkHomePage(driver);
        TestSuiteManagementPage testSuiteManagementPage = homepage.openTestSuiteManagementPage();
        TestSuiteEditPage testSuiteEditPage = testSuiteManagementPage.testSuiteCreate();


        TestSuite testSuite = new TestSuite();
        testSuiteEditPage.createTestSuite(testSuite);
    }
}

