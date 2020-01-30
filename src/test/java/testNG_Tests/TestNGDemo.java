package testNG_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGDemo {
    /*
        @ BeforeClass
        @ Before Method
        @ Test
        @ After Method
        @ After Class
    */

    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }
    @Test
    public void testAmazon(){
        String actTitle = driver.getTitle();
        System.out.println(actTitle);

        String expTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

        Assert.assertEquals(actTitle,expTitle);
//        String expTitle="Amazon";
//        Assert.assertEquals(actTitle,expTitle);


    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();

    }

}
