package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectCredentials {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.l@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();

        WebElement sentenceElement = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));

        String sentence = sentenceElement.getText();
        System.out.println("This sentence is to verify Failed login" + " " + sentence);
        if (sentence.contains("The account sign-in was incorrect"))
        {
            System.out.println("Login failed : Which means this -ve scenario passed");
        }
        else
        {
            System.out.println("TC is failed");
        }
        driver.quit();
    }
}
