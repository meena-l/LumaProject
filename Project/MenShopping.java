package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shopping
{
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    //TC for Men's shopping
    @Test(priority = 1)
    public void ShoppingMen() throws InterruptedException
    {
        Actions action = new Actions(driver);
        WebElement Men = driver.findElement(By.xpath("//span[text()='Men']"));
        action.moveToElement(Men).perform();
        WebElement Tops = driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]"));
        action.moveToElement(Tops).perform();
        driver.findElement(By.xpath("/html/body")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Montana Wind Jacket']")).click();
        driver.findElement(By.xpath("//div[@class='swatch-option text' and @aria-label='S']")).click();
        driver.findElement(By.xpath("//div[@class='swatch-option color' and @aria-label='Black']")).click();
        driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart']")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")).click();
        Thread.sleep(6000);
    }

    //TC for Men's shopping
   @Test(priority = 2)
 public void WomenShopping()
   {
       Actions act1 = new Actions(driver);

       WebElement Women = driver.findElement(By.xpath("//span[text()='Women']"));
       act1.moveToElement(Women).perform();

       WebElement Bottoms = driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/women/bottoms-women.html')]"));
       act1.moveToElement(Bottoms).perform();

       driver.findElement(By.xpath("//span[text()='Pants']")).click();
       driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Deirdre Relaxed-Fit Capri']")).click();
       driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-172\"]")).click();
       driver.findElement(By.xpath("//div[@class='swatch-option color' and @aria-label='Green']")).click();
       driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart']")).click();

   }
    @Test(priority = 3)
    public void Cart() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")).click();
        Thread.sleep(5000);
    }
   //Close the browser
   @Test(priority = 4)
    public void close()
   {
       driver.close();
   }
}




