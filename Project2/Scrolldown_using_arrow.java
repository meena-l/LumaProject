package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Scrolldown_using_arrow
{
    WebDriver driver = null;

    @Test
    public void arrow_down()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        Actions act = new Actions(driver);

        while (!isPageBottomReached(driver))
        {
            // Scroll down by pressing the arrow down key
            act.sendKeys(Keys.ARROW_DOWN).perform();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
         String pagedown = driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
         System.out.println(pagedown);
         if (pagedown.contains("Subscription"))
        {
            System.out.println("TC executed perfectly");
        }
        else
        {
            System.out.println("Failed");
        }
        driver.quit();
    }

    // Method to check if the bottom of the page is reached
    static boolean isPageBottomReached(WebDriver driver)
    {

        return false;
    }


}


