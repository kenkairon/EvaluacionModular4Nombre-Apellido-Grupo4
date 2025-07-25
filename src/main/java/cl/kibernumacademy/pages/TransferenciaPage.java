package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferenciaPage {
    private WebDriver driver;

    private By cuentaDestino = By.id("cuentaDestino");
    private By monto = By.id("monto");
    private By botonTransferir = By.id("transferir");
    private By mensajeExito = By.id("mensajeExito");

    // Constructor corregido
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void realizarTransferencia(String cuenta, String valor) {
        driver.findElement(cuentaDestino).sendKeys(cuenta);
        driver.findElement(monto).sendKeys(valor);
        driver.findElement(botonTransferir).click();
    }

    public boolean transferenciaExitosa() {
        return driver.findElement(mensajeExito).isDisplayed();
    }
}
