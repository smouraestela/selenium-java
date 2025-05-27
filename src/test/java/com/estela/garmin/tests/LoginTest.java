package com.estela.garmin.tests;

import com.estela.garmin.utils.Config;
import com.estela.garmin.base.BaseTest;
import com.estela.garmin.pages.LoginPage;
import org.junit.Test;
import org.junit.Assert;

public class LoginTest extends BaseTest {

    @Test
    public void deveExibirPaginaDeLogin() {
        driver.get(Config.get("login.url"));
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue("Página de Login não identificada.", loginPage.estaNaPaginaDeLogin());
    }
    
    @Test
    public void deveExibirErroAoTentarLogarComDadosInvalidos() {
        driver.get(Config.get("login.url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.preencherUsuario(Config.get("usuario.invalido"));
        loginPage.preencherSenha(Config.get("senha.invalida"));
        loginPage.clicarEmEntrar();

        boolean erroVisivel = loginPage.mensagemDeErroInvalidoEstaVisivel();
        Assert.assertTrue("Mensagem de erro não foi exibida.", erroVisivel);
    }
}
