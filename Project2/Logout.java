package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Logout
{
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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.linkText("logout")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.quit();

    }

}
