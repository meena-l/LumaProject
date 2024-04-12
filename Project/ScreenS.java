package Project;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenS {
    WebDriver driver = null;
    @BeforeMethod
    public void precondition()
    {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 1)
    public <ITesseract> void checkAccount() throws IOException, TesseractException
    {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("meena.laxman@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium1234");
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();

        File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f1.toPath(), new File("C:\\Users\\meena\\IdeaProjects\\First\\src\\test\\java\\Project\\Welcome.jpg").toPath());


        String pageSource = driver.getPageSource();
       // System.out.println(pageSource);


        if (pageSource.contains("welcome"))
        {
            System.out.println("Signin successfull");
        } else {
            System.out.println("Signin failed");
        }

    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
