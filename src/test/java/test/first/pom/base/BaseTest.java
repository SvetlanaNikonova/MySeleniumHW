package test.first.pom.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.first.pom.factory.DriverManager;

public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public void startDriver() {
        setDriver(new DriverManager().initializeDriver());
        System.out.println("CURRENT START THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    @AfterMethod
    public void quitDriver() {
        System.out.println("CURRENT END THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
        getDriver().quit();
    }
}