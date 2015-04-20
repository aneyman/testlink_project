package pages;

import models.TestCase;
import models.TestStep;
import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestSuiteManagementPage {


    private WebDriver driver;

    private static final By openTestSuiteEditPanel = By.xpath("html/body/div[1]/img");
    private static final By createTestSuiteButton = By.id("new_testsuite");
    private static final By createTestCaseButton = By.id("create_tc");
    private static final By testCaseNameField = By.id("testcase_name");
    private static final By testCaseCreateButton = By.id("do_create_button");
    private static final By testStepCreateButton = By.name("create_step");
    private static final By testStepSaveAndExitButton = By.id("do_update_step_and_exit");
    private static final By testStepDescription = By.xpath(".//*[@id='cke_contents_steps']/iframe");
    private static final By openTestSuiteControls = By.xpath("html/body/div[1]/img[2]");
    private static final By deleteTestSuiteButton = By.id("delete_testsuite");
    private static final By deleteTestSuiteSubmitButton = By.xpath("html/body/div[1]/form/input[3]");

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


    public void createTestCase(TestSuite testSuite, TestCase testCase, TestStep testStep) {

        String name = testSuite.name;
        final By selectTestSuite = By.xpath("//a/span/span[contains(text(),'" + name + "')]");

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("treeframe")
                .findElement(selectTestSuite).click();

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                .findElement(openTestSuiteControls).click();

        driver.findElement(createTestCaseButton).click();
        driver.findElement(testCaseNameField).sendKeys(testCase.name);
        driver.findElement(testCaseCreateButton).click();
        driver.findElement(testStepCreateButton).click();
        driver.findElement(testStepDescription).sendKeys(testStep.description);
        driver.findElement(testStepSaveAndExitButton).click();
    }


    public void deleteMyTestSuite(TestSuite testSuite) {

        String name = testSuite.name;
        final By selectTestSuite = By.xpath("//a/span/span[contains(text(),'" + name + "')]");

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("treeframe")
                .findElement(selectTestSuite).click();

        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                .findElement(openTestSuiteControls).click();

        driver.findElement(deleteTestSuiteButton).click();
        driver.findElement(deleteTestSuiteSubmitButton).click();
    }

}

