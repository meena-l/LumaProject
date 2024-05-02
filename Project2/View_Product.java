package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class View_Product
{
    WebDriver driver = null;

    @Test
    public  void product() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Actions a = new Actions(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        a.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        a.sendKeys(Keys.PAGE_UP).perform();

        String title = driver.findElement(By.cssSelector("h2[class='title text-center']")).getText();
        System.out.println(title);

        Assert.assertEquals(title, "ALL PRODUCTS");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,3500)", "");


        driver.findElement(By.xpath("//a[@href='/product_details/14']")).click();
        String details = driver.findElement(By.xpath("//b[contains(text(), 'Availability:')]")).getText();
        System.out.println(details);

        js.executeScript("window.scrollBy(0,500)", "");

        Assert.assertEquals(details, "Availability:");

        String brand = driver.findElement(By.xpath("//b[contains(text(), 'Brand:')]")).getText();
        System.out.println(brand);

        Assert.assertEquals(brand,"Brand:");

        String cond = driver.findElement(By.xpath("//b[contains(text(), 'Condition:')]")).getText();
        System.out.println(cond);

        Assert.assertEquals(cond,"Condition:");

        driver.quit();
    }
}
