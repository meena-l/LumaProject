package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Review {
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 1)
    public void addReview() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id = 'search']")).sendKeys("Shorts");
        driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();
        driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Erika Running Short']")).click();
        driver.findElement(By.linkText("Add Your Review")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[@class=\"rating-1\"]")).click();
        driver.findElement(By.id("nickname_field")).sendKeys("manu");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id=\"summary_field\"]"))
                .sendKeys("Size Issue and colour ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@id=\"review_field\"]"))
                .sendKeys("Recieved the Faded and Large size ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class=\"action submit primary\"]"))
                .click();
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}