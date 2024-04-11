package Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveItem {
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 0)
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
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")).click();
        Thread.sleep(6000);

        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath("//a[@title='Remove item']")).click();


        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        if (alertText.contains("You have no items in your shopping cart"))
        {
            System.out.println("Removing Item from Cart is successfull");
        } else
        {
            System.out.println("Failed");
        }
       
    }
    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
