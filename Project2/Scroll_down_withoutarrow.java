package Project2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static Project2.Scrolldown_using_arrow.isPageBottomReached;

public class Scroll_down_withoutarrow {
    WebDriver driver = null;

    @Test
    public void scroll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        while (!isPageBottomReached(driver)) {
            js.executeScript("window.scrollBy(0, -100)");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }

    }
}
