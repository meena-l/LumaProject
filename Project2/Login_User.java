package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_User
{
    WebDriver driver = null;
    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

    }

    @Test(priority = 1)
    public void LoginwithValidCredentials()
    {
        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.cssSelector("input[name='email']:nth-child(2)")).sendKeys("meena1234@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ABCD123");
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        String text =driver.findElement(By.xpath("//b[text()='Meena_L']")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"Meena_L");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        //Logout
        driver.findElement(By.cssSelector("i.fa.fa-lock")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void LoginwithInvalidCredentials()
    {
        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.cssSelector("input[name='email']:nth-child(2)")).sendKeys("meena1234@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ABCD4123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String incorrect =driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).getText();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println(incorrect);
        Assert.assertEquals(incorrect,"Your email or password is incorrect!");
    }

    @AfterMethod()
            public void close()
    {
        driver.quit();
    }
}
