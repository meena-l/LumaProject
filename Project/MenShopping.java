package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenShopping
{
    WebDriver driver = null;

    @BeforeMethod
    public void precondition()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    //TC for Men's shopping
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

        //Check weather item is added or not

        WebElement sentenceElement = driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
        String sentence = sentenceElement.getText();
        System.out.println("This sentence is to verify" + " " + sentence);
        if (sentence.contains("Proceed to Checkout"))
        {
            System.out.println("Adding to cart is succesfull");
        }
        else
        {
            System.out.println("Adding to cart is failed");
        }
    }

   //Close the browser
   @AfterMethod
    public void close()
   {
       driver.close();
   }
}




