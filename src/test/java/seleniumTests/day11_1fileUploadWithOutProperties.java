package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class day11_1fileUploadWithOutProperties {

 //****************************************************************************************************
 // Vlad need to exam how sendKey to fileInputStreem. And how its work. Dont forget!!!!!!!!!!!!!!!!!
 //****************************************************************************************************


    /*go to https://the-internet.herokuapp.com/upload
      * upload file
       click upload
       verify text uploaded
      */
   @Test
   public void fileUpWithOutProp() throws FileNotFoundException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/upload");
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

       WebElement fileUp = driver.findElement(By.id("file-upload"));

// open file for uploading in our computer
       File file = new File("C:\\Users\\Vlad\\IdeaProjects\\com.VladSelenium\\src\\Test.docx");

//check if its exists
       System.out.println(file.exists());   // true

// reading file
       FileInputStream fileInputStream = new FileInputStream(file);

      String f = "C:\\Users\\Vlad\\IdeaProjects\\com.VladSelenium\\src\\Test.docx";

      fileUp.sendKeys(f);


//Locate WebElement "Upload" to submit our uploading
       driver.findElement(By.id("file-submit")).click();

       driver.close();
       driver.quit();
}
}
