package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaldoPage {
    private WebDriver driver;
    private By saldoTexto = By.id("saldo");

    public SaldoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean saldoVisible() {
        return driver.findElement(saldoTexto).isDisplayed();
    }

    public String obtenerSaldo() {
        return driver.findElement(saldoTexto).getText().trim();
    }
}
