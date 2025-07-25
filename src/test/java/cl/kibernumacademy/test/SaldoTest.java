package cl.kibernumacademy.test;

import cl.kibernumacademy.pages.SaldoPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class SaldoTest {
    WebDriver driver;
    SaldoPage saldoPage;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/mi-carpeta-html/saldo.html");
        saldoPage = new SaldoPage(driver);
    }

    @Test
    void saldoEsVisibleYCorrecto() {
        Assertions.assertTrue(saldoPage.saldoVisible());
        Assertions.assertEquals("$50,000", saldoPage.obtenerSaldo());
    }

    @AfterEach
    void tearDown(TestInfo info) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(),
                new File("screenshots/" + info.getDisplayName() + ".png").toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        driver.quit();
    }
}
