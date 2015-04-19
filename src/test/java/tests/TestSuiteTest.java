package tests;

import models.TestCase;
import models.TestPlan;
import models.TestSuite;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
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

        TestCase testCase = new TestCase();
        testSuiteManagementPage.createTestCase(testSuite, testCase);

        deleteMyTestSuite(testSuite);
    }

    @AfterTest
    public void shutEnv() {
        if (driver != null) driver.quit();
    }


    public void deleteMyTestSuite(TestSuite testSuite){
        TestSuiteManagementPage testSuiteManagementPage = new TestSuiteManagementPage(driver);
        testSuiteManagementPage.deleteMyTestSuite(testSuite);
    }
}



