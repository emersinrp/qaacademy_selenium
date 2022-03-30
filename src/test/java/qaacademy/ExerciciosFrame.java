package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExerciciosFrame {
    
    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void iniciaTeste() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();        
    }

    @Test
    public void testeIframeSimples() {
        driver.switchTo().frame("singleframe"); //muda o contexto do driver para o frame
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Teste QA Academy");
        driver.switchTo().defaultContent();// voltar para o contexto anterior
    }

    @AfterClass // Roda apos de todos os testes da classe
    public static void after() {
        driver.quit();
    }
}
