package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Favourite
{
    WebDriver driver = null;
    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void fav() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();

        Actions act2 = new Actions(driver);

        WebElement Women = driver.findElement(By.xpath("//span[text()='Women']"));
        act2.moveToElement(Women).perform();

        WebElement Bottoms = driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/women/bottoms-women.html')]"));
        act2.moveToElement(Bottoms).perform();

        driver.findElement(By.xpath("//span[text()='Shorts']")).click();
        driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Erika Running Short']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(), 'Add to Wish List')]")).click();
        Thread.sleep(3000);

        WebElement sentenceElement = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
        String sentence = sentenceElement.getText();
        System.out.println("This sentence is to verify" + " " + sentence);
        if (sentence.contains("has been added")) {
            System.out.println("Adding to My Wish List is succesfull");
        } else {
            System.out.println("Adding to cart is failed");
        }
    }

@AfterMethod
    public void close()
{
    driver.close();
}
}
