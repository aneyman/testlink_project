package pages;

import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestlinkHomePage {

    private WebDriver driver;

    private static final By TestPlanManagementLink = By.xpath("//*[@id='test_plan_mgmt_topics']/a[1]");
    private static final By Logout = By.xpath("//img[contains(@src,'gui/themes/default/images/computer_go.png')]");
    private static final By editTestsLink = By.xpath(".//*[@id='testspecification_topics']/a[1]");

    public TestlinkHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TestplanManagementPage openTestPlanManagementPage() {
        driver.switchTo().frame("mainframe").findElement(TestPlanManagementLink).click();
        return new TestplanManagementPage(driver);
    }

    public TestSuiteManagementPage openTestSuiteManagementPage(){
        driver.switchTo().frame("mainframe").findElement(editTestsLink).click();
        return new TestSuiteManagementPage(driver);
    }


}


