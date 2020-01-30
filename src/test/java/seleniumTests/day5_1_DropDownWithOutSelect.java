package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day5_1_DropDownWithOutSelect {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
                  driver.get("https://amazon.com");
                  driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
                  driver.findElement(By.linkText("Prime Video")).click();



        driver.close();
        driver.quit();
    }
}
