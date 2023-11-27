package test.first.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.first.pom.base.BasePage;


public class LoginPage extends BasePage {
    private final By emailFld = By.id("i0116");
    private final By passwordFld = By.id("i0118");
    private final By submitBtn = By.id("idSIButton9");
    private final By microsoftAuthentication = By.xpath("//img[@alt='Microsoft']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load() {
        load("/");
        return this;
    }

    public LoginPage enterEmail(String userEmail) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(emailFld)).sendKeys(userEmail);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        waitLong.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }


    public LoginPage login(String email, String password) {
        return enterEmail(email).
                clickLoginBtn().
                enterPassword(password).
                clickLoginBtn();
    }

    public boolean microsoftIsDisplayed() {
        return waitSuperLong.until(ExpectedConditions.visibilityOfElementLocated(microsoftAuthentication)).isDisplayed();
    }
}