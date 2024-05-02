package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestBase
{
    private WebDriver driver;


    public TestBase(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterUsername(String username)
    {
        driver.findElement(By.id("email")).sendKeys(username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(By.id("pass")).sendKeys(password);
    }
    public void clickLoginButton()
    {
        driver.findElement(By.id("send2")).click();
    }
}

