package Project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollDownUp
{
    WebDriver driver = null;
    @BeforeMethod
    public void precondition()
    {

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void Scroll() throws InterruptedException
    {

        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scrolldown
        js.executeScript("window.scrollBy(0, 2000)");


        Thread.sleep(3000);
        //Scrollup
        js.executeScript("window.scrollBy(0, -1000)");
    }

  @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
