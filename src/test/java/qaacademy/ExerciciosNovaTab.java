package qaacademy;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExerciciosNovaTab {
    
    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void iniciaTeste() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testeMudarJanelas() {
        driver.findElement(By.linkText("click")).click();
        Object[] janelas = driver.getWindowHandles().toArray();
        driver.switchTo().window(janelas[1].toString());
        Assert.assertTrue(driver.getPageSource().contains("Selenium automates"));
        driver.getCurrentUrl().equals("https://selenium.dev");
    }


    @After // Roda apos de todos os testes da classe
    public void closeBrowser() {
        driver.quit();
    }
}
