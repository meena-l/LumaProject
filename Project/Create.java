package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Create {
    WebDriver driver = null;

    @BeforeMethod
    public  void precondition()
    {
        driver = new ChromeDriver();

    }

    @Test(priority = 1)
    public  void createAccount() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Meena");
        driver.findElement(By.id("lastname")).sendKeys("Laxman");
        driver.findElement(By.name("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Selenium1234");
        driver.findElement(By.name("password_confirmation")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
        Thread.sleep(3000);
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")));
        Thread.sleep(3000);
        dropdown.selectByVisibleText("Sign Out");
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void SignIn() throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();

        WebElement dropdownElement = driver.findElement(By.cssSelector("[data-toggle='dropdown']"));
        dropdownElement.click();
        driver.findElement(By.cssSelector("[data-label='or']")).click();
    }
    @Test(priority = 2)
    public void ShoppingMen() throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
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
    }

    @Test(priority = 3)
    {
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        Actions action = new Actions(driver);

        WebElement Women = driver.findElement(By.xpath("//span[text()='Women']"));
        action.moveToElement(Women).perform();

        WebElement Bottoms = driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/women/bottoms-women.html')]"));
        Bottoms.click();


    }
}
