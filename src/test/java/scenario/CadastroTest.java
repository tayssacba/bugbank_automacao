package scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;

import java.time.Duration;

public class CadastroTest {
    WebDriver driver;
    CadastroPage cadastroPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testeCadastro() {
        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValor(cadastroPage.campoEmail, "tayssa.asakawa@hotmail.com");
        cadastroPage.preencherValor(cadastroPage.campoNome, "Tayssa");
        cadastroPage.preencherValor(cadastroPage.campoSenha, "Teste123");
        cadastroPage.preencherValor(cadastroPage.campoConfSenha, "Teste123");
        cadastroPage.clicarPorXpath(cadastroPage.campoContaSaldoToggle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarCadastroConta();
    }

    @After
    public void after() {

    }

}
