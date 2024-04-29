package Project2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Search
{

    WebDriver driver = null;
    @Test
    public void search()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Saree");
        driver.findElement(By.id("submit_search")).click();


        List<WebElement> Saree = driver.findElements(By.xpath("//div[contains(@class, 'Saree')]"));
        boolean allVisible = true;
        for (WebElement sareeProductElement : Saree)
        {
            if (!sareeProductElement.isDisplayed()) {
                allVisible = false;
                break;
            }
        }
        if (allVisible) {
            System.out.println("All products related to the search are visible.");
        } else {
            System.out.println("Not all products related to the search are visible.");
        }
        driver.quit();
    }
}
