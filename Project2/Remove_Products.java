package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Remove_Products {
    WebDriver driver = null;

    @Test
    public void order() {
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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@data-product-id='39']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.linkText("View Cart")).click();

        driver.findElement(By.cssSelector(".cart_delete")).click();
        String remove = driver.findElement(By.xpath("//b[text()='Cart is empty!']")).getText();
        System.out.println(remove);

        if(remove.contains(" empty"))
        {
            System.out.println("TC is working fine");
        }
        else
        {
            System.out.println("Failed");
        }
    }
}
