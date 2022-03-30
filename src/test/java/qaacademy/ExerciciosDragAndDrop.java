package qaacademy;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ExerciciosDragAndDrop {
    
    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void iniciaTeste() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Static.html");
        driver.manage().window().maximize();        
    }

    @Test
    public void testeDragAndDrop() {
        WebElement elementoInicial = driver.findElement(By.id("node")); //Elemento inicial
        WebElement areaDestino = driver.findElement(By.id("droparea")); //Area final
        Actions actionProvider = new Actions(driver); //Instancia do ActionProvider
        actionProvider.dragAndDrop(elementoInicial, areaDestino).build().perform();
    }

    @Test
    public void uploadFoto(){
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.xpath("//input[@id='imagesrc']"))
        .sendKeys("/Users/emersonrodrigues/projects/qaacademy/qaacademy_selenium_tests/qaacademy_selenium/src/test/java/qaacademy/Foto_upload.png");
    }

    @AfterClass // Roda apos de todos os testes da classe
    public static void after() {
        driver.quit();
    }
}

