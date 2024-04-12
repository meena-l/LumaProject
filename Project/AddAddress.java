package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAddress {
    WebDriver driver = null;

    @BeforeMethod
    public void precondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 1)
    public void Myaccount() throws InterruptedException
    {

        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();


        WebElement dropdownElement = driver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        dropdownElement.click();
        driver.findElement(By.xpath("//a[contains(text(), 'My Account')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(), 'Address Book')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("telephone")).sendKeys("1234567890");
        Thread.sleep(2000);

        driver.findElement(By.id("street_1")).sendKeys("Main Road");
        Thread.sleep(2000);
        driver.findElement(By.id("street_2")).sendKeys("1st Cross");
        Thread.sleep(2000);
        driver.findElement(By.id("street_3")).sendKeys("5th main");
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("BTM Layout");
        Thread.sleep(2000);
        driver.findElement(By.id("zip")).sendKeys("560780");
        Thread.sleep(2000);

        WebElement dropdown1 = driver.findElement(By.id("country"));
        Select ss = new Select(dropdown1);
        ss.selectByVisibleText("India");

        WebElement dropdown2 = driver.findElement(By.id("region_id"));
        Select s2 = new Select(dropdown2);
        s2.selectByVisibleText("Karnataka");

//Save the address
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Save Address')]")).click();


        WebElement check = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div"));
        String add = check.getText();

        System.out.println("This sentence is to verify" + " " + add);
        if (add.contains("You saved the address")) {
            System.out.println("Saving the adress is succesfull");
        } else {
            System.out.println("TC is failed");
        }


    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
