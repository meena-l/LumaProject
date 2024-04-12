package Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class CheckOut
{
    WebDriver driver = null;
@BeforeMethod
public void precondition()
{
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://magento.softwaretestingboard.com/");

}

@Test(priority = 0)
public void login()
{
    driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
    driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
    driver.findElement(By.id("pass")).sendKeys("Selenium1234");
    driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
}
@Test(priority = 1)
public void ShoppingMen() throws InterruptedException
{

    Actions action = new Actions(driver);
    WebElement Men = driver.findElement(By.xpath("//span[text()='Men']"));
    action.moveToElement(Men).perform();
    WebElement Tops = driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]"));
    action.moveToElement(Tops).perform();
    driver.findElement(By.xpath("/html/body")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Montana Wind Jacket']")).click();
    driver.findElement(By.xpath("//div[@class='swatch-option text' and @aria-label='S']")).click();
    driver.findElement(By.xpath("//div[@class='swatch-option color' and @aria-label='Black']")).click();
    driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")).click();
    Thread.sleep(6000);

    driver.findElement(By.xpath("(//span[@class='counter qty'])[1]")).click();

    driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();


    //driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();

    //Checking out

    Thread.sleep(3000);
    driver.findElement(By.name("username")).sendKeys("meena.l@gmail.com");
    driver.findElement(By.name("firstname")).sendKeys("Meena");
    driver.findElement(By.name("lastname")).sendKeys("L");
    driver.findElement(By.name("street[0]")).sendKeys("Main Road");
    driver.findElement(By.name("street[1]")).sendKeys("1st Cross");
    driver.findElement(By.name("street[2]")).sendKeys("5th main");
    driver.findElement(By.name("city")).sendKeys("BTM Layout");

    driver.findElement(By.name("postcode")).sendKeys("560780");

    WebElement dropdown = driver.findElement(By.name("country_id"));
    Select s = new Select(dropdown);
    s.selectByVisibleText("India");

    WebElement dd = driver.findElement(By.name("region_id"));
    Select s1 = new Select(dd);
    s1.selectByVisibleText("Karnataka");

    driver.findElement(By.name("telephone")).sendKeys("1234567890");
    driver.findElement(By.name("ko_inque_1")).click();
    driver.findElement(By.xpath("1")).click();

    driver.findElement(By.xpath("//span[normalize-space()='Place Order']")).click();

    Thread.sleep(5000);

}
@AfterMethod
    public void quit()
{
    driver.quit();
}
}
