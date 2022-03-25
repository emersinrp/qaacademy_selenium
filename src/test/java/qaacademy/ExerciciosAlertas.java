package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ExerciciosAlertas {
    
    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void iniciaTeste() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testesAlertaSimples() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText(); 
        String mensagemEsperada = "I am an alert box!";
        Thread.sleep(2000);
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void testesAlertaComOkCancela() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText(); 
        String mensagemEsperada = "Press a Button !";
        Thread.sleep(2000);
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void testesAlertaComPrompt() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("QA Academy | Fomracao automatizacao de testes web");
        alert.accept();
    }

    @After // Roda apos de todos os testes da classe
    public void closeBrowser() {
        driver.quit();
    }
}
