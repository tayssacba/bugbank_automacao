package scenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class SaldoInicialTest {
    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    HomePage homePage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testeSaldoInicial() {
        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValor(cadastroPage.campoEmail, "teste@hotmail.com");
        cadastroPage.preencherValor(cadastroPage.campoNome, "Tayssa");
        cadastroPage.preencherValor(cadastroPage.campoSenha, "Teste123");
        cadastroPage.preencherValor(cadastroPage.campoConfSenha, "Teste123");
        cadastroPage.clicarToogleSaldo();
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarCadastroConta();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);

        loginPage.preencherCampo(loginPage.campoEmail, "teste@hotmail.com");
        loginPage.preencherCampo(loginPage.campoSenha, "Teste123");
        loginPage.clicarPorXpath(loginPage.btnAcessar);
        loginPage.validarLogin();

        homePage.validarSaldo();
    }

    @After
    public void after() {
        driver.quit();
    }
}
