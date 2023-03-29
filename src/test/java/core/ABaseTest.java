package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

abstract public class ABaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void initBrowser() {
        String browserName = Objects.isNull(System.getProperty("browser"))
                ? getPropertiesValue("browser")
                : System.getProperty("browser");
        switch (browserName) {
            case "chrome":
                initChrome();
                break;
            case "firefox":
                initFirefox();
                break;
        }
    }

    public void initChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    public void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private String getPropertiesValue(String propName) {
        Properties prop = new Properties();
        try {
            FileInputStream fls = new FileInputStream("src/test/resources/data.properties");
            prop.load(fls);
        } catch (IOException ignored) {}
        return prop.getProperty(propName, "chrome");
    }
}





























