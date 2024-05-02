package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignIn {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Sign In")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        TestBase signin = new TestBase(driver);

        signin.enterUsername("meena.laxman@gmail.com");
        signin.enterPassword("Selenium1234");
        signin.clickLoginButton();


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        //Verifying Home Page
        String Title = driver.getTitle();
        System.out.println(Title);
        if (driver.getTitle().contains("Home Page")) {
            System.out.println("Test Case 1: Homepage loaded successfully - PASSED");
        } else {
            System.out.println("Test Case 1: Homepage failed to load - FAILED");
        }
    }
}