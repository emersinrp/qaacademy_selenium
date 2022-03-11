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
        driver.findElement(By.xpath("//input[@id='input_comp-k37gdip8']")).click();
        driver.findElement(By.xpath("//input[@id='input_comp-k37gdip8']")).sendKeys("Teste QA Academy"); //Insere texto na tela

        driver.findElement(By.xpath("//input[@id='input_comp-k37gdiq1']")).click();
        driver.findElement(By.xpath("//input[@id='input_comp-k37gdiq1']")).sendKeys("teste@gmail.com");
        driver.findElement(By.xpath("//*/form[1]/div[1]/div[1]/div[7]/button[1]")).click();

    }
}
