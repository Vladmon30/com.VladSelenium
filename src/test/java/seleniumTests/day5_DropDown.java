package seleniumTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day5_DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
                  driver.get("https://amazon.com");

// 1. we have to locate an element with tag select  (Account)
    WebElement dropDown = driver.findElement(By.tagName("select"));
// 2. create select object using the webelement
        Select list = new Select(dropDown);
// 3. print the selected option
        String selectOptions = list.getFirstSelectedOption().getText();
        System.out.println(selectOptions);
// 4. print all available options

        List<WebElement> options = list.getOptions();
        System.out.println("options.size() = " + options.size());

            for (WebElement option:options) {
              System.out.println(option.getText());
        }


// 5.  select different options
          // 1. by visible text
                list.selectByVisibleText("Baby");
                System.out.println("Selected ByVisibleText: " + list.getFirstSelectedOption().getText());

          // 2. by visible index, count is 0 based
                list.selectByIndex(1);
                System.out.println("SelectedByIndex: " + list.getFirstSelectedOption().getText());

          // 3. by value attribute
                //<select aria-describedby="searchDropdownDescription" class=".......
                //       <option value="search-alias=computers">Computers</option>
                list.selectByValue("search-alias=computers");
                System.out.println("SelectByValue: " + list.getFirstSelectedOption().getText());
        driver.close();
        driver.quit();
    }

}
