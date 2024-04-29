package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Add_Review {
    WebDriver driver = null;

    @Test
    public void review() {
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

        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("name")).sendKeys("Meena");
        driver.findElement(By.id("email")).sendKeys("meena123@gmail.com");
        driver.findElement(By.name("review")).sendKeys("Quality is not good");
        driver.findElement(By.id("button-review")).click();
        String success = driver.findElement(By.cssSelector(".alert-success.alert")).getText();
        System.out.println(success);

        if (success.contains("Thank"))
        {
            System.out.println("pass");
        }
        else
        {
            System.out.println("failed");
        }
    }
}
