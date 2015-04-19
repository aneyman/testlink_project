package pages;

import models.TestPlan;
import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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



    public void createTestCase(TestSuite testSuite, TestPlan testPlan) {

        String name = testSuite.name;
        final By selectTestSuite = By.xpath("//a/span/span[contains(text(),'" + name + "')]");
        final By openTestSuiteControls = By.xpath("html/body/div[1]/img[2]");
        final By createTestPlanButton = By.id("create_tc");
        final By testCaseNameField = By.id("testcase_name");
        final By testCaseCreateButton = By.id("do_create_button");
        final By testStepCreateButton = By.name("create_step");

        final By testStepDescriptionField = By.xpath(".//*[@id='cke_contents_steps']");

        final By testStepSaveAndExitButton = By.id("do_update_step_and_exit");




        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("treeframe")
                .findElement(selectTestSuite).click();

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                .findElement(openTestSuiteControls).click();

        driver.findElement(createTestPlanButton).click();
        driver.findElement(testCaseNameField).sendKeys(testPlan.name);
        driver.findElement(testCaseCreateButton).click();
        driver.findElement(testStepCreateButton).click();
        driver.findElement(testStepSaveAndExitButton).click();
    }

}

