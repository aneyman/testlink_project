package pages;

import models.TestPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TestplanManagementPage {

    private WebDriver driver;

    private static final By createButton = By.name("create_testplan");

    public TestplanManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestplanEditPage createTestPlan() {
        driver.findElement(createButton).click();
        return new TestplanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan) {
        return driver.findElement(By.linkText(testPlan.name)) != null;
    }

    public void deleteTestPlan(TestPlan testPlan) {
        String testPlanName = testPlan.name;
        driver.findElement(By.xpath("//img[contains(@onclick, testPlanName)]")).click();
        driver.findElement(By.id("ext-gen20")).click();
    }
}
