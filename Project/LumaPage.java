package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LumaPage
{
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    //TC-1 Creating an account and Signingout
    @Test(priority = 1)
    public void createAccount() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Meena");
        driver.findElement(By.id("lastname")).sendKeys("Laxman");
        driver.findElement(By.name("email")).sendKeys("meena.laxman99@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Selenium1234");
        driver.findElement(By.name("password_confirmation")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
        Thread.sleep(3000);

        WebElement dropdownElement = driver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        dropdownElement.click();
        driver.findElement(By.cssSelector("[data-label='or']")).click();
        Thread.sleep(3000);

    }

    //TC-2 Signing in and verifying Homepage
    @Test(priority = 1)
    public void SigninAndVerify()
    {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
        //Verifying Home Page
        String Title = driver.getTitle();
        System.out.println(Title);
        if (driver.getTitle().contains("Home Page")) {
            System.out.println("Test Case 1: Homepage loaded successfully - PASSED");
        } else {
            System.out.println("Test Case 1: Homepage failed to load - FAILED");
        }
    }

    //Closing Browser
    @AfterMethod
    public void Close()
    {
        driver.close();
    }
}



