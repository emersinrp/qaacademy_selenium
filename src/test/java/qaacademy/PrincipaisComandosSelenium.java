package qaacademy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrincipaisComandosSelenium {
    
    @Test
    public void testeSeleniumClick() throws InterruptedException{

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Abrir navegador maximizado
        options.addArguments("--desktop-window-1080p"); // Seleciona o display com a resolução informada
        options.addArguments("disable-infobars"); // Desabilita barra de informações
        options.addArguments("--disable-extensions"); // Desabilita extensoes
        options.addArguments("--no-sandbox"); // Ignora o modelo de seguranca do SO
        options.addArguments("--force-device-scale-factor=0.9"); // Zoom navegador

        WebDriver driver = new ChromeDriver(options); //Abrir o browser
        driver.get("https://qaacademy.com.br");
        Thread.sleep(3000);// add espera de 3 segundos
        driver.findElement(By.xpath("//button[contains(text(),'Aceitar')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*//div[1]/div[5]/ul[1]/li[2]/a[1]/wix-image[1]/img")).click();
    }
}
