package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }


    public void sleep() {
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
