package PageObjModelTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static utilities.ConfigReader.properties;

public class POM_Using_ConfigPropFile  {

    @Test
    public void UseConfigProp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://Gmail.com");
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//locate webElement "email" to put our email in it
        WebElement Gmail = driver.findElement(By.xpath("//input[@type='email']"));

// Without properties --->  email.sendKeys("ivanov@gmail.com")

//Put inside "Email" field our email using config.properties

                   Gmail.sendKeys(properties.getProperty("email"));

// locate next webElement "Next" and click on it
        WebElement click = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
                   click.click();
        Thread.sleep(2000);

// locate webElement "password" to put our pasword in it
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

// Without properties -- > password.sendKeys("Kawasaki35");

// put inside "password" field our password from config.properties
                    password.sendKeys(properties.getProperty("password"));

// locate next webElement "Next" and click on it
        WebElement click2 = driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])[1]"));
                   click2.click();

// Show all our using properties
        System.out.println(properties.getProperty("urlforGmail"));
        System.out.println(properties.getProperty("email"));
        System.out.println(properties.getProperty("password"));

        driver.close();
        driver.quit();

    }
}
