package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test_Data
{
    private WebDriver driver;

    public Test_Data(WebDriver driver)
    {
        this.driver = driver;
    }
    public void Username(String username)
    {
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(username);
    }
    public void email(String email)
    {

        driver.findElement(By.xpath("//input[ @data-qa='signup-email']")).sendKeys(email);
    }

    public void password(String password)
    {
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }

    public  void signUpButton()
    {
        driver.findElement(By.xpath("//button[text()=\"Signup\"]")).click();
    }

}

