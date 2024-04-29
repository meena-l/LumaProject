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

public class AddProducts
{
    WebDriver driver = null;
    @Test
    public void search() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Saree");
        driver.findElement(By.id("submit_search")).click();
        driver.findElement(By.xpath("//a[@data-product-id='39']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[@class='text-center'][1]"));
        driver.findElement(By.xpath("//button[contains(text(), 'Continue Shopping')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        //second product

        Actions act = new Actions(driver);

        WebElement second = driver.findElement(By.xpath("//h2[contains(text() , \"3500\")]"));
        act.moveToElement(second).perform();
        driver.findElement(By.xpath("//a[@data-product-id='40']")).click();

        driver.findElement(By.tagName("u")).click();
        String cart = driver.findElement(By.xpath("//a[contains(text(), 'Proceed To Checkout')]")).getText();


       if(cart.contains("Proceed"))
       {
           System.out.println("Adding items to cart is sucesfull");
       }
       else
       {
           System.out.println("Failed");
       }

    }
}
