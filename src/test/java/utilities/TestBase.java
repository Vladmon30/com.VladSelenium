package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void tearDownMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
        Driver.closeDriver();
        softAssert.assertAll();
    }
}