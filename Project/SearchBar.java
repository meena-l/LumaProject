package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchBar
{
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void search() throws InterruptedException
    {
       WebElement Search = driver.findElement(By.id("search"));
       Search.sendKeys("Pants for women");
       Search.submit();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Validate the search results
        List<WebElement> searchResults = driver.findElements(By.className("item"));
        if (!searchResults.isEmpty()) {
            System.out.println("Search results are displayed.");
        } else {
            System.out.println("No search results found.");
        }

    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
