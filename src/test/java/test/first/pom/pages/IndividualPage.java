package test.first.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.first.pom.base.BasePage;

public class IndividualPage extends BasePage {
    private final By individualInfo = By.id("individualMainData");
    private final By searchFld = By.id("input-search");
    private final By searchBtn = By.id("search-button");

    public IndividualPage(WebDriver driver) {
        super(driver);
    }

    public void shouldAppear() {
        waitUntilLoadingSpinnerDisappears();
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(individualInfo)).isDisplayed();
    }

    public IndividualPage enterTextInSearchFld(String txt) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public SelectedIndividualPage clickSearchBtn() {
        waitUntilLoadingSpinnerDisappears();
        waitShort.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return new SelectedIndividualPage(driver);
    }
}