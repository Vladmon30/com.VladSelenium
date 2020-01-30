package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class day12_Impl_Expl_Th_Wait extends TestBase {

    //**************************************************************************
    @Test
    public void ImplicitWait() {
// wait while trying to find element. we set it only once
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.cheapfansedge.info");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath(("//input[@type='submit']"))).click();
    }
//****************************************************************************

    @Test
    public void ExplicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//click on enable
        driver.findElement(By.xpath("//form[@id='input-example']//button")).click();
// Thread.sleep(10000);

// WebDriverWait class used for explicit wait
//just creating object, waiting does not happen yet
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
// wait.until(): this is when wait happens
//we are waiting for certain element this xpath to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")));

        //enter text
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//input")).sendKeys("hello world");

    }

    //****************************************************************************************************
    @Test
    public void ThreesWait() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        // We use it  for scroll down a page to find WebElement on the bottom of this page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,4000)");

        //        actions.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(2000);

        // To find element on the bottom of the page we must use page_Down method or JavaScript Executor
    }
}