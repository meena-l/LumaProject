package Project2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class My_Reference{

    //Programm for my refernce
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        //for closing adds
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert = function(){};");

        //driver.switchTo().alert().dismiss();

        WebElement right = driver.findElement(By.cssSelector(".material-icons.card_travel"));
        Actions act = new Actions(driver);

         //Doing right click and opening new tab
        act.moveToElement(right).keyDown(Keys.CONTROL).click().perform();
        Thread.sleep(2000);
        Set<String> handles  = driver.getWindowHandles();
        Iterator it = handles.iterator();

        String parent = (String) it.next();
        String child = (String) it.next();

        driver.switchTo().window(child);
        driver.quit();

    }
}
