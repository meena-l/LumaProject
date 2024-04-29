package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class UserRegistration {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Meena_L");
        driver.findElement(By.xpath("//input[ @data-qa='signup-email']")).sendKeys("meena1234@gmail.com");
        driver.findElement(By.xpath("//button[text()=\"Signup\"]")).click();
        //driver.findElement(By.cssSelector("#id_gender2")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ABCD123");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dropdownDays = driver.findElement(By.xpath("//select[@id='days']"));
        Select drop = new Select(dropdownDays);
        drop.selectByVisibleText("28");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dropdownmonth = driver.findElement(By.xpath("//select[@id='months']"));
        Select dropMonth = new Select(dropdownmonth);
        dropMonth.selectByVisibleText("March");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dropdownyear = driver.findElement(By.xpath("//select[@id='years']"));
        Select dropyear = new Select(dropdownyear);
        dropyear.selectByVisibleText("1999");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#first_name")).sendKeys("MEENA");
        driver.findElement(By.cssSelector("#last_name")).sendKeys("LAXMAN");
        driver.findElement(By.cssSelector("#address1")).sendKeys("Marathahalli");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Country = driver.findElement(By.cssSelector("#country"));
        Select dropCountry = new Select(Country);
        dropCountry.selectByVisibleText("India");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#state")).sendKeys("Karnataka");
        driver.findElement(By.cssSelector("#city")).sendKeys("Bengaluru");
        driver.findElement(By.cssSelector("#zipcode")).sendKeys("560018");
        driver.findElement(By.cssSelector("#mobile_number")).sendKeys("123457890");
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();

        WebElement Account = driver.findElement(By.xpath("//b[text()='Account Created!']"));

        String Actual = Account.getText();
        System.out.println(Actual);

        if (Actual.equals("ACCOUNT CREATED!"))
        {
            System.out.println("Account is created succesfully");
        } else
        {
            System.out.println("Account creation is failed");
        }
        driver.quit();
    }


}
