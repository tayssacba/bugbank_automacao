package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public String elementoSaldo = "//p[@id='textBalance']";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validarSaldo() {
        String esperado = driver.findElement(By.xpath(elementoSaldo)).getText();
        String atual = "Saldo em conta R$ 1.000,00";
        Assert.assertEquals(atual, esperado);
    }
}
