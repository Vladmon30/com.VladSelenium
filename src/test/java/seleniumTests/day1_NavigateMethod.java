package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1_NavigateMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vlad\\Selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
                  driver.get("https://google.com");
            driver.manage().window().maximize();
                  driver.getTitle();
    //       String title = driver.getTitle();
    //       System.out.println(title);



    // Selenium navigation methods:
                    driver.navigate().to("https://amazon.com");
                    driver.navigate().back();
                    driver.navigate().forward();
                    driver.navigate().refresh();

        driver.close();
        driver.quit();
    }
}
