package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class day11_fileUpload extends TestBase {
    /*go to https://the-internet.herokuapp.com/upload
    * upload file
      click upload
      verify text uploaded
     */

    @Test
    public void upLoad(){
        driver.get("https://the-internet.herokuapp.com/upload");

// located webElement "ChoiseFile" to open folder where we can chise file to upload
        WebElement file = driver.findElement(By.xpath("//input[@id='file-upload']"));

// find file in our computer to choise for upload
        String path ="C:\\Users\\Vlad\\IdeaProjects\\com.VladSelenium\\src\\Test.docx";

// Connect file to upload with webElemnt
        file.sendKeys(path);

//Locate WebElement "Upload" to submit our uploading
        driver.findElement(By.id("file-submit")).click();

// Check if file was uploaded successfuly and you see the sign "File Uploaded!"
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
