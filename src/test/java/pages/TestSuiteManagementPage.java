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

    /*  private static final By nameField = By.name("testplan_name");
      private static final By descriptionField = By.xpath("/html/body");//By.id("cke_contents_notes");
      private static final By activeCheckBox = By.name("active");
      private static final By isPublicCheckBox = By.name("is_public");
      private static final By createButton = By.name("do_create");


      */
    private static final By actions = By.xpath("html/body/div[1]/img");


    public TestSuiteManagementPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openPanelTestSuite() {
        driver.switchTo().defaultContent()
                .switchTo().frame("mainframe")
                .switchTo().frame("workframe")
                        .findElement(actions).click();

    }

}


 /*
        driver.findElement(nameField).sendKeys(testPlan.name);
        driver.switchTo().frame("mainframe").findElement(TestPlanManagementLink).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cke_contents_notes']/iframe")));
        driver.findElement(descriptionField).sendKeys(testPlan.description);
        driver.switchTo().defaultContent().switchTo().frame("mainframe");
        if (testPlan.active)
            driver.findElement(activeCheckBox).click();
        if (testPlan.pub)
            driver.findElement(isPublicCheckBox).click();
        driver.findElement(createButton).click();

        */
