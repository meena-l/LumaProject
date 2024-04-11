package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckCart {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        Actions act1 = new Actions(driver);

        WebElement Women = driver.findElement(By.xpath("//span[text()='Women']"));
        act1.moveToElement(Women).perform();

        WebElement Bottoms = driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/women/bottoms-women.html')]"));
        act1.moveToElement(Bottoms).perform();

        driver.findElement(By.xpath("//span[text()='Pants']")).click();
        driver.findElement(By.xpath("//img[@class='product-image-photo'and @alt='Deirdre Relaxed-Fit Capri']")).click();
        driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-172\"]")).click();
        driver.findElement(By.xpath("//div[@class='swatch-option color' and @aria-label='Green']")).click();
        driver.findElement(By.xpath("//button[@type='submit' and @title='Add to Cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")).click();
        Thread.sleep(5000);

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
        driver.quit();
    }
}

