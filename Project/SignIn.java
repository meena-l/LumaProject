package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
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
}