package cl.kibernumacademy.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import cl.kibernumacademy.pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/mi-carpeta-html/login.html"); // Cambiar a tu URL real
        loginPage = new LoginPage(driver);
    }

    @Test
    void loginCorrecto() {
        loginPage.ingresarCredenciales("usuario", "1234");
        Assertions.assertTrue(driver.getTitle().contains("Panel"));
    }

    @Test
    void loginIncorrecto() {
        loginPage.ingresarCredenciales("invalido", "incorrecto");
        Assertions.assertTrue(loginPage.loginFallido());
    }

    // Anotación de JUnit que indica que este método se ejecutará después de cada
    // prueba (test)
    @AfterEach
    void tearDown(TestInfo info) throws IOException {

        // Crear el directorio "screenshots" si no existe, para guardar las capturas de
        // pantalla
        Path screenshotsDir = Paths.get("screenshots");
        if (!Files.exists(screenshotsDir)) {
            Files.createDirectories(screenshotsDir); // Se crea la carpeta
        }

        // Toma una captura de pantalla del navegador actual
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Copia la captura al directorio creado con el nombre del test actual
        // Ejemplo: "screenshots/testName.png"
        Files.copy(
                screenshot.toPath(), // Ruta origen (captura)
                screenshotsDir.resolve(info.getDisplayName() + ".png"), // Ruta destino con el nombre del test
                StandardCopyOption.REPLACE_EXISTING // Sobrescribe si ya existe una imagen con ese nombre
        );

        // Cierra el navegador (comentado, pero se recomienda activarlo si deseas cerrar
        // después de cada test)
        driver.quit();
    }

}
