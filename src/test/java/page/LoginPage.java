package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String campoEmail = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]";
    public String campoSenha = "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]";
    public String btnAcessar = "//button[contains(text(),'Acessar')]";

    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();
    }

    public void preencherCampo(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void validarLogin() {
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:3000/home"));
    }
}
