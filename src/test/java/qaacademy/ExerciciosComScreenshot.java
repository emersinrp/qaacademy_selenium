package qaacademy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExerciciosComScreenshot {
    
    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void iniciaTeste() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.setHeadless(true); //Seta o chrome headless (segundo plano)
        options.setAcceptInsecureCerts(true); // Executa os testes mesmo com algum certificado inseguro
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
    }

    public void screenShot(String nomeScreenShot)throws IOException{
        TakesScreenshot screenshot = (TakesScreenshot) driver; // Convertendo o driver(navegador) em TakeScreenshot
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);// Tira o screenshot e transforma para file
        FileUtils.copyFile(arquivo, new File("output" + File.separator + nomeScreenShot + "_screenshot.jpg")); //Grava os bytes do arquivo no sistema operacional
    }

    @Test
    public void testeMudarJanelas() throws IOException {
        driver.findElement(By.linkText("click")).click();
        Object[] janelas = driver.getWindowHandles().toArray(); //mapeando janelas abertas
        driver.switchTo().window(janelas[1].toString());
        Assert.assertTrue(driver.getPageSource().contains("Selenium automates"));
        screenShot("TesteMudarJanela");
        driver.getCurrentUrl().equals("https://selenium.dev");
    }

    @After // Roda apos de todos os testes da classe
    public void closeBrowser() {
        driver.quit();
    }

}
