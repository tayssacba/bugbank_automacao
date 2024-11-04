package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.xpath(campoContaSaldoToggle)).click();
    }

    public void validarCadastroConta() {
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }
}
