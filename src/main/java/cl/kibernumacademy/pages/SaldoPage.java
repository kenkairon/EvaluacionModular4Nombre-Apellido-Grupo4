package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaldoPage {
    private WebDriver driver;

    // Localizadores
    private By inputCuenta = By.id("cuenta");
    private By botonConsultar = By.tagName("button");
    private By resultadoSaldo = By.id("saldoResultado");

    public SaldoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void consultarSaldo(String cuenta) {
        driver.findElement(inputCuenta).clear();
        driver.findElement(inputCuenta).sendKeys(cuenta);
        driver.findElement(botonConsultar).click();
    }

    public boolean saldoVisible() {
        return driver.findElement(resultadoSaldo).isDisplayed();
    }
}
