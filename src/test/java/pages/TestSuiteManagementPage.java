package pages;

import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Tester on 17.04.2015.
 */
public class TestSuiteManagementPage {


    private WebDriver driver;

    private static final By openTestSuiteEditPanel = By.xpath("html/body/div[1]/img");
    private static final By createTestSuiteButton = By.id("new_testsuite");


    public TestSuiteManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestSuiteEditPage testSuiteCreate() {
        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                .findElement(openTestSuiteEditPanel).click();

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                .findElement(createTestSuiteButton).click();

        return new TestSuiteEditPage(driver);
    }
}

