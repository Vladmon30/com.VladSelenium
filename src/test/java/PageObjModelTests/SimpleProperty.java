package PageObjModelTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utilities.ConfigReader.properties;


public class SimpleProperty extends TestBase {
    @Test
    public void propTest() throws IOException, InterruptedException {

        driver.get("https://Gmail.com");
// locate our config.properties file in IntellJ its "config.properties file.
        FileInputStream file = new FileInputStream("C:\\Users\\Vlad\\IdeaProjects\\com.VladSelenium\\config.properties");

//Read config.properties file using  java.util.Properties class.
        Properties prop = new Properties();

//read all information from config.properties file what inside our IntelliJ.
        prop.load(file);
        System.out.println(prop.getProperty(String.valueOf(file)));


        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(prop.getProperty("email2"));

        WebElement click = driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
        click.click();
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(properties.getProperty("password2"));
        WebElement click2 = driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])[1]"));
        click2.click();

// Show all our using properties

        System.out.println(properties.getProperty("email2"));
        System.out.println(properties.getProperty("password2"));



    }

}
