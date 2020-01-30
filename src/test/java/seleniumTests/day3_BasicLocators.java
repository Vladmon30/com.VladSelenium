package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3_BasicLocators {

/*
  Amazon.com
1. open browser
2. go to amazon
3. enter search term and submit
4. verify search box still contains the same search term
 */

    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        String searchTerm = "wooden spoon";
// 1 By id
//   <input type="text" id="twotabsearchtextbox" value="wooden spoon"
//                      name="field-keywords" autocomplete="off" placeholder=""
//                      class="nav-input" dir="auto" tabindex="19">

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys(searchTerm + Keys.ENTER);
        String actual = driver.findElement(By.id("twotabsearchtextbox"))
                .getAttribute("value");
        //System.out.println(actual);

        if (searchTerm.equals(actual)) {
            System.out.println("Test By Id is Pass");
        } else {
            System.out.println("Test by Id is Failed");
        }
//  2 By name
//  <input type="text" id="twotabsearchtextbox" value="wooden spoon"
//                     name="field-keywords" autocomplete="off" placeholder=""
//                     class="nav-input" dir="auto" tabindex="19">

        if (driver.findElement(By.name("field-keywords")).isEnabled()) {
            System.out.println("Test By name is Pass");
        } else {
            System.out.println("Test By name is Failed");
        }

//  3 By ClassName
//  <a href="/gp/goldbox?ref_=nav_cs_gb_azl"
//          class="nav-a  " tabindex="47">Today's Deals</a>

        if(driver.findElement(By.className("nav-a")).isEnabled()){
            System.out.println("Test By ClassName is Pass");
        } else {
            System.out.println("Test By ClassName is Failed");
        }



//   4 By xpath
//   <span class="nav-sprite nav-logo-base"></span>
        if (driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']")).isDisplayed()) {
            System.out.println("Test by xpath. Title verification is Pass");
        } else {
            System.out.println("Test by xpath. Title verification is Failed");
        }
//   5 By LinkText
//    <a href="/gp/help/customer/display.html?nodeId=508510&amp;ref_=nav_cs_customerservice"
//    class="nav-a  " tabindex="49">Customer Service</a>
        if (driver.findElement(By.linkText("Customer Service")).isDisplayed()) {
            System.out.println("Test by LinkText is Pass");
        }else{
            System.out.println("Test by LinkText is Failed");
        }

//  6  By  Partial LinkText
//    <a href="/gp/help/customer/display.html?nodeId=508510&amp;ref_=nav_cs_customerservice"
//    class="nav-a  " tabindex="49">Customer Service</a>

        if (driver.findElement(By.partialLinkText("Service")).isDisplayed()) {
            System.out.println("Test by PartialLinkText is Pass");
        }else{
            System.out.println("Test by PartialLinkText is Failed");
        }
//  7 By CSS
// <input type="text" id="twotabsearchtextbox" value="wooden spoon"
// name="field-keywords" autocomplete="off" placeholder=""
// class="nav-input" dir="auto" tabindex="19">
        if(driver.findElement(By.cssSelector("input[type=text]")).isDisplayed()){
            System.out.println("Test by CSS is Past");
        }else{
            System.out.println("Test by CSS is Failed");
        }
// 8 By TagName
// <input type="text" id="twotabsearchtextbox" value="wooden spoon"
//  name="field-keywords" autocomplete="off" placeholder=""
//  class="nav-input" dir="auto" tabindex="19">
        if (driver.findElement(By.tagName("input")).isEnabled()){
            System.out.println("Test by TagName is Pass");
        }else{
            System.out.println("Test by TagName is Failed");
        }

        driver.close();
        driver.quit();
    }

}
