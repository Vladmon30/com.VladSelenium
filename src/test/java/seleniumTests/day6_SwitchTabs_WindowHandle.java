package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class day6_SwitchTabs_WindowHandle {


    @Test
    public void SwitchTabs(){

    /*
      go to  https://the-internet.herokuapp.com/windows
      click on "click here"
      verify that the new title is a new window
      verify that a new title is not "Internet"
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
                  driver.get("https://the-internet.herokuapp.com/windows");
                  driver.findElement(By.linkText("Click Here")).click();
// check how many tabs are open
        System.out.println(driver.getWindowHandles().size()); //2 tabs are open

// for switch between tabs we use Set<String>
              Set<String> handles =  driver.getWindowHandles();
                  for(String handle:handles) {
                      System.out.println(handle);
                      // we switch tabs one by one
                      driver.switchTo().window(handle);
                      System.out.println(driver.getTitle());

                      // To veerify if current tab equals new tab
                      if (driver.getTitle().equalsIgnoreCase("New Window")) {
                          System.out.println("Pass");
                          break;
                      }else{
                          System.out.println("Fail");
                      }
                  }


                  Assert.assertEquals(driver.getTitle(),"New Window");


                    driver.close();
                    driver.quit();
   }
    @Test
    public void SwitchTabs2(){
    /*  go to https://www.w3schools.com/html/
        click on "Try it Yourself"
        verify the url of the new tab contains "default"
    */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@target='_blank'][@class='w3-btn w3-margin-bottom']")).click();
        System.out.println("Current Title: " + driver.getCurrentUrl());

        Set<String> windows = driver.getWindowHandles();
            for(String win:windows){
             //(String win:driver.getWindowHandles){   same as in top
                driver.switchTo().window(win);
                System.out.println("Current URL:" + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains("default"))
              {
                System.out.println("Verification is pass");
                break;
              }
            }
            Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Tryit Editor v3.6"));

        driver.close();
        driver.quit();
    }
}


