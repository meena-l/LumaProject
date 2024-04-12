package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BagsShopping
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
        public void bag ()
        {
            Actions action = new Actions(driver);
            WebElement Men = driver.findElement(By.xpath("//span[text()='Gear']"));
            action.moveToElement(Men).perform();
            driver.findElement(By.xpath("//span[text()='Bags']")).click();
            driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Overnight Duffle']")).click();
            driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart']")).click();

        }

        @BeforeMethod
    public void close()
        {
            driver.close();
        }
    }

