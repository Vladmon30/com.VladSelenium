package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class day10_Action extends TestBase {

    //************************************Action********************************************************



    //************************************doubleClick method********************************************************
    @Test
    public void doubleClick() {

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");
//create actions object
        Actions actions=new Actions(driver);
//we will identify the webelement on which we double click
        WebElement text=driver.findElement(By.id("demo"));
// double click on element
// we need to act perform at the end of any action
        actions.doubleClick(text).perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));

    }

//************************************dragAndDrop method ********************************************************


    @Test
    public  void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
//pass the variable in the correct order, first one is source
//second one is target
        actions.dragAndDrop(source, target).perform();
    }

    @Test
    public  void dragAndDrop2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
//write the steps for doing drag and drop operation
//without using DragAndDrop() method

//when we use multiple actions we need to add build()before perform

//actions.clickAndHold(source).moveToElement(target).release().build().perform();

        actions.clickAndHold(source).moveToElement(target)
                .release().build()
                .perform();


    }
    //*********************************************moveTo method**************************************************************

    @Test
    public void moveTo(){
        driver.get("https://www.amazon.com/");
        WebElement signIn=driver.findElement(By.xpath("//span[.='Hello, Sign in']"));
        //moving the mouse on the top of given element
        actions.moveToElement(signIn).perform();
        WebElement logIn = driver.findElement(By.xpath("//span[.='Your Hearts']"));
                   logIn.click();

//        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test
    public  void moveTo2() throws InterruptedException {
        driver.get("https://www.amazon.com/");
// We use it  for scroll down a page to find WebElement on the bottom of this page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,4000)");

//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(2000);

// To find element on the bottom of the page we must use page_Down method or JavaScript Executor

        WebElement help=driver.findElement(By.xpath("//a[@class='nav_a'][contains(text(),'Help')]"));
// perfom() --> execute steps as one statement
        actions.moveToElement(help).perform();

    }


 }

