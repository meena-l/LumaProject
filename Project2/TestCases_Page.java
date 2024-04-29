package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases_Page
{
   WebDriver driver = null;
    @Test
    public void TC_Page()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        String text = driver.findElement(By.xpath("//span[contains(text(), 'Automation')]")).getText();
        System.out.println(text);
        //verify home page
        Assert.assertEquals(text,"Automation");
        driver.findElement(By.linkText("Test Cases")).click();
        String TC = driver.findElement(By.linkText("Test Cases")).getText();
        //verify TC page
        System.out.println("To verify clicked page, this is we got:=\n" + TC);
        if (TC.contains("Test Cases"))
        {
            System.out.println("TC is passed");
        }
        else
        {
            System.out.println("Tc is failed");
        }
    }
}
