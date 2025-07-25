package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferenciaPage {
    private WebDriver driver;

    private By cuentaDestino = By.id("cuentaDestino");
    private By monto = By.id("monto");
    private By botonTransferir = By.id("transferir");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mensajeExito")));
        return mensaje.isDisplayed();
    }
}
