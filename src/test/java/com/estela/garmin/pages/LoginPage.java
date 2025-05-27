package com.estela.garmin.pages;

import com.estela.garmin.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Mapeamento dos elementos da página
    private By campoUsuario = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.cssSelector("button[data-testid='g__button']");
    private By mensagemErroLogin = By.xpath("//span[contains(text(),'error') or contains(text(),'Invalid')]");

    // Mapeamento das ações disponíveis nesta página

    public void preencherUsuario(String usuario) {
        WaitUtils.waitUntilClickable(driver, campoUsuario);
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        WaitUtils.waitUntilClickable(driver, campoSenha);
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEmEntrar() {
        WaitUtils.waitUntilClickable(driver, botaoLogin);
        driver.findElement(botaoLogin).click();
    }

    public void fazerLogin(String usuario, String senha) {
        preencherUsuario(usuario);
        preencherSenha(senha);
        clicarEmEntrar();
    }

    //Checagens 

    // Checa se está na página de login
    public boolean estaNaPaginaDeLogin() {
        return driver.getTitle().contains("Garmin SSO Portal");
    }

    public boolean mensagemDeErroInvalidoEstaVisivel() {
        try {
            WaitUtils.waitUntilVisible(driver, mensagemErroLogin);
            return driver.findElement(mensagemErroLogin).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
