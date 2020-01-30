package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class day9_RadioButtons {
    @Test
    public void RadioButon(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
                  driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement blue = driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
            WebElement red = driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));

        System.out.println(blue.isSelected());
        System.out.println(red.isSelected());

            blue.click();
        System.out.println("Blue is selected: " + blue.isSelected());
            // red.click();
            // System.out.println("Red is selected: " + red.isSelected());
        driver.close();
        driver.quit();
    }
}