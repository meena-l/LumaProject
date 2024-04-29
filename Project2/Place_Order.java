package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Place_Order {
    WebDriver driver = null;
    @Test
    public void order()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.cssSelector("input[name='email']:nth-child(2)")).sendKeys("meena1234@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ABCD123");
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//a[@data-product-id='39']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.linkText("View Cart")).click();
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
        //driver.findElement(By.xpath("//a[text()='Place Order']")).click();
        driver.findElement(By.name("name_on_card")).sendKeys("Mary");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("card_number")).sendKeys("123456789");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("cvc")).sendKeys("89");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("expiry_month")).sendKeys("89");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("expiry_year")).sendKeys("89");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        String placed = driver.findElement(By.xpath("//b[text()='Order Placed!']")).getText();
        System.out.println(placed);
        Assert.assertEquals(placed, "ORDER PLACED!");
        driver.quit();

    }
}
