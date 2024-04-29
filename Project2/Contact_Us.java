package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Contact_Us
{
    WebDriver driver = null;
    @Test
    public void Contact()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        driver.findElement(By.cssSelector(".fa.fa-envelope")).click();
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Meena.L");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("meena123@gmail.com");
        driver.findElement(By.cssSelector("input[name='subject']")).sendKeys("Password ");
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Password is not generating when we click on forgot password");

        WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
        file.sendKeys("C:\\Users\\meena\\OneDrive\\Desktop\\File.png");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String success = driver.findElement(By.cssSelector(".status.alert.alert-success")).getText();
        System.out.println(success);
        if( success.contains("Success!"))
        {
            System.out.println("Succecfully done!");
        }
      else
        {
            System.out.println("Failed");
        }
        driver.quit();


    }

}
