package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class GetIframes {
    WebDriver driver = null;

    @BeforeMethod
    public void precondition() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public <List> void Scroll() throws InterruptedException {

        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);

        List iframes = (List) driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes found: " + iframes);


        driver.switchTo().frame((Integer) iframes);
        Thread.sleep(3000);

        driver.quit();
    }
}
