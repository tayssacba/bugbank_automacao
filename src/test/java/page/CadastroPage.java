package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPage {
    WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public String btnRegistrar = "//button[contains(text(),'Registrar')]";
    public String campoEmail = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]";
    public String campoNome = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]";
    public String campoSenha = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]";
    public String campoConfSenha = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/input[1]";
    public String campoContaSaldoToggle = "//label[@id='toggleAddBalance']/..";
    public String btnCadastrar = "//button[contains(text(),'Cadastrar')]";
    public String btnFechar = "//a[@id='btnCloseModal']";

    public void preencherValor(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();
    }

    public void clicarToogleSaldo() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.findElement(By.xpath(campoContaSaldoToggle)).isDisplayed());
        driver.findElement(By.xpath(campoContaSaldoToggle)).findElement(By.tagName("span")).click();
    }

    public void validarCadastroConta() {
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }
}
