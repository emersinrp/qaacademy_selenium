package qaacademy;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ExerciciosSelenium {

    static ChromeOptions options;
    static WebDriver driver;

    @Before
    public void before() {
        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
    }

    @Test
    public void preencheFormulario() {
        // options.addArguments("--headless");
        // options.addArguments("start-maximized");
        // options.addArguments("disable-infobars");
        // options.addArguments("disable-popup-blocking");
        // options.addArguments("--no-sandbox");
        // options.addArguments("--force-device-scale-factor=1.0");

        //Close Toolbar
        WebElement adToolbar = driver.findElement(By.cssSelector("body > ins:nth-child(8) > ins.ee > span > svg > path"));
        if (adToolbar.isDisplayed()) {
            adToolbar.click();
        }
        else{
            System.out.println("WebElement não esta presente");
        }    

        // Full name-First
        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).sendKeys("Emerson"); // Somente com o sendkeys ja envia o texto, sem necessidade do click
        
        // Full name-Last
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).sendKeys("Teste");

        // Address
        driver.findElement(By.xpath("//form[1]/div[2]/div[1]/textarea[1]")).sendKeys("Rua do Teste Selenium WebDriver");

        // Email
        driver.findElement(By.xpath("//form[1]/div[3]/div[1]/input[1]")).sendKeys("testeqa@teste.com");

        // Phone
        driver.findElement(By.xpath("//form[1]/div[4]/div[1]/input[1]")).sendKeys("996212169");

        // Select gender
        driver.findElement(By.xpath("//*/form[1]//label[1]/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*/form[1]//label[1]/input[1]")).isSelected());

        // Select Hobbies
        driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkbox2']")).isSelected());

        // Select lista
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Norwegian')]")).click();
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[7]/div/multi-select/div[2]/ul/li[3]/a")).click();
        boolean norwegianIsDisplayed = driver.findElement(By.xpath("//div[contains(text(),'Norwegian')]")).isDisplayed();
        boolean catalanDisplayed = driver.findElement(By.xpath("//div[contains(text(),'Catalan')]")).isDisplayed();
        Assert.assertTrue(norwegianIsDisplayed && catalanDisplayed);

        // Select lista skills tipo <options>
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByVisibleText("Java");

        // Select lista paises tipo <li>
        driver.findElement(By.xpath("//div[1]/span[1]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("//li[contains(text(),'United States of America')]")).click();

        // Select aniversario tipo <options>
        WebElement selectAnoAniversario = driver.findElement(By.xpath("//select[@id='yearbox']"));
        Select anoAniversario = new Select(selectAnoAniversario);
        anoAniversario.selectByVisibleText("1992");

        WebElement selectMesAniversario = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select mesAniversario = new Select(selectMesAniversario);
        mesAniversario.selectByVisibleText("December");

        WebElement selectDiaAniversario = driver.findElement(By.xpath("//select[@id='daybox']"));
        Select diaAniversario = new Select(selectDiaAniversario);
        diaAniversario.selectByVisibleText("22");

        // Password
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("123456");

        // Confirm Password
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("123456");

        // Submit Button
        driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

        String contemLanguage = "Catalan";
        Assert.assertTrue("Linguagem não localizada", driver.getPageSource().contains(contemLanguage)); // getPageSource busca o codigo da pagina toda.
        
    }

    @AfterClass // Roda apos de todos os testes da classe
    public static void after() {
        driver.quit();
    }

}
