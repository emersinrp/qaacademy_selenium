package qaacademy;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrimeiraClasseSelenium {
    

    @Test
    public void testeAberturaBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Abrir navegador maximizado
        options.addArguments("--desktop-window-1080p"); // Seleciona o display com a resolução informada
        options.addArguments("disable-infobars"); // Desabilita barra de informações
        options.addArguments("--disable-extensions"); // Desabilita extensoes
        options.addArguments("--no-sandbox"); // Ignora o modelo de seguranca do SO
        options.addArguments("--force-device-scale-factor=0.9"); // Zoom navegador

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qaacademy.com.br");
    }
}
