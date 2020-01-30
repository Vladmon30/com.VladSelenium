package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day8_Alert_PopUp {
    @Test
    public void alert_PopUp_HTML_Webbased() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
// locate HTML alert like regular webElement and click on it
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
//locate button "No" in this alert and click "No"
        WebElement clickNo = driver.findElement(By.xpath("//span[.='No']"));
        clickNo.click();

        driver.close();
        driver.quit();
    }

    @Test
    public void alert_PopUp_HTML_Webbasedalert_PopUp_JavaScript() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
//locate HTML alert like regular webElement and click on it
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
//locare button and click "OK"
        driver.findElement(By.xpath("//button[.='OK']")).click();

    }

    @Test
    public void alertJSAccept() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");

//locate webElement and click on it
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();

//its a alert without html so we must create Alert class and switch to this alert
             Alert alert = driver.switchTo().alert();
                   alert.accept();
    }

    @Test
    public void alertJSDismiss() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
//locate webElement and click on it
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

//Create Alert class to switch to alert
             Alert alert = driver.switchTo().alert();
                   alert.dismiss();
    }

    @Test
    public void alertJSText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

//Create Alert class to switch to alert
            Alert alert = driver.switchTo().alert();
                  alert.sendKeys("Hello from Vlad");
                  alert.accept();
        driver.close();
        driver.quit();
    }

}