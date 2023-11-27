package test.first.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import test.first.pom.constants.DriverType;


public class DriverManager {
    public WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        switch (DriverType.valueOf(browser)) {
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(option);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}