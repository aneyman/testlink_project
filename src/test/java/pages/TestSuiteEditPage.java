package pages;


import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSuiteEditPage {

    private WebDriver driver;
    private static final By nameField = By.id("name");
    private static final By createTestSuiteButton = By.name("add_testsuite_button");

    public TestSuiteEditPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createTestSuite(TestSuite testSuite) {
        driver.findElement(nameField).sendKeys(testSuite.name);
        driver.findElement(createTestSuiteButton).click();
    }

}
