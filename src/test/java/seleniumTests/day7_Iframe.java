package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day7_Iframe {

    /*
    Create class IFrame
    go to url https://the-internet.herokuapp.com/tinymce
    enter text in the text editor
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");
// cant locate webElement its iframe (html inside html), so we need to  switch iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
                   driver.switchTo().frame(iframe);
// now we can locate element and clean the text
        driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();
// now we write our text message "Hello from Vlad"
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello from Vlad");

// in order to click on sign Elemental Selenium we should switch back to parent Frame
        driver.switchTo().parentFrame();
// now we can find element
        driver.findElement(By.linkText("Elemental Selenium")).click();

        driver.close();
        driver.quit();
    }
}
