package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2_Verify_URL_Title {
    public static void main(String[] args) throws InterruptedException {
//        1. Open chrome browser
//        2. go to url "https://google.com"
//        3. Verify url
//        Expected url: "https://www.google.com/"

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vlad\\Selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
                  driver.get("https://google.com");
                  //driver.manage().window().maximize();

                  String url = driver.getCurrentUrl();
                      System.out.println(url);
                  String expUrl = "https://www.google.com/";

                  if(url.equalsIgnoreCase(expUrl)){
                      System.out.println("Pass");
                  }else{
                      System.out.println("Fall");
                  }
        driver.close();
        driver.quit();
    }
}

