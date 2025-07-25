package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("usuario");
    private By passwordField = By.id("clave");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.id("mensaje-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ingresarCredenciales(String usuario, String clave) {
        driver.findElement(usernameField).sendKeys(usuario);
        driver.findElement(passwordField).sendKeys(clave);
        driver.findElement(loginButton).click();
    }

    public boolean loginFallido() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
