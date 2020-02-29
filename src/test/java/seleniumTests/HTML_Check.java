package seleniumTests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class HTML_Check extends TestBase {

    @Test
    public void CheckIfContains(){
/*
Check using webdriver  that  p  contains  "SomeText"
..
<div>
<a href=""someLink""></a>
<p>SomeText</p>
</div>
...
 */
/*
     <a class="gb_g" data-pid="23" href="https://mail.google.com/mail/?tab=wm&authuser=0&ogbl"
        wrc_done="true">Gmail</a>\
 */
        driver.get("file:///C:/Users/Vlad/Desktop/SDET/2.%20SELENIUM,Cucumber,JUnit,TestNG/1.HTML/practice%20vlad.html");

//a[@id='nav-hamburger-menu']
        WebElement text = driver.findElement(By.xpath("/html/body/div/p"));
        System.out.println(text.getText());
        Assert.assertTrue(text.getText().contains("sometext"));

    }
}
