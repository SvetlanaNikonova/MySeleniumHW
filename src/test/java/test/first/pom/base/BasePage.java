package test.first.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.first.pom.utils.ConfigLoader;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait waitSuperLong;
    protected WebDriverWait waitLong;
    protected WebDriverWait waitShort;
    private final By LOADING_SPINNER = By.id("spinner");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitSuperLong = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitUntilLoadingSpinnerDisappears() {
        waitLong.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_SPINNER));
    }
}