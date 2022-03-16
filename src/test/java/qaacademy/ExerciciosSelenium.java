package qaacademy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ExerciciosSelenium {

    ChromeOptions options;
    static WebDriver driver;

    @Test
    public void preencheFormulario() throws InterruptedException {

        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--desktop-window-1080p");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--force-device-scale-factor=0.9");

        driver = new ChromeDriver(options);
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(1500);

        //Full name-First
        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).sendKeys("Emerson"); //Somente com o sendkeys ja envia o texto, sem necessidade do click
        //Full name-Last
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).sendKeys("Teste");
        //Address
        driver.findElement(By.xpath("//form[1]/div[2]/div[1]/textarea[1]")).click();
        driver.findElement(By.xpath("//form[1]/div[2]/div[1]/textarea[1]")).sendKeys("Rua do Teste Selenium WebDriver");
        //Email
        driver.findElement(By.xpath("//form[1]/div[3]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//form[1]/div[3]/div[1]/input[1]")).sendKeys("testeqa@teste.com");
        //Phone
        driver.findElement(By.xpath("//form[1]/div[4]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//form[1]/div[4]/div[1]/input[1]")).sendKeys("16996212169");
        //Select gender
        driver.findElement(By.xpath("//*/form[1]//label[1]/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*/form[1]//label[1]/input[1]")).isSelected());
        //Select Hobbies
        driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkbox2']")).isSelected());
        //Select lista
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Norwegian')]")).click();
        Thread.sleep(1000);
        boolean norwegianIsDisplayed = driver.findElement(By.xpath("//*/form[1]/div[7]/div[1]/multi-select[1]/div[1]/div[1]")).isDisplayed();
        Assert.assertTrue(norwegianIsDisplayed);
    }

    @AfterClass //Roda apos de todos os testes da classe
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    
}
