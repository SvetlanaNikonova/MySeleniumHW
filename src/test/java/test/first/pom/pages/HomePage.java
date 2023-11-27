package test.first.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.first.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By logOutBtn = By.cssSelector("a.logout-block");
    private final By individualMenuLink = By.xpath("(//a[normalize-space()='Individual'])[1]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void shouldAppear() {
        waitSuperLong.until(ExpectedConditions.visibilityOfElementLocated(logOutBtn)).isDisplayed();
    }

    public IndividualPage clickOnIndividualMenuLink() {
        waitLong.until(ExpectedConditions.elementToBeClickable(individualMenuLink)).click();
        return new IndividualPage(driver);
    }
}