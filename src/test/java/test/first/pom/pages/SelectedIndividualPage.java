package test.first.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.first.pom.base.BasePage;

public class SelectedIndividualPage extends BasePage {
    private final By title = By.cssSelector(".personFullName.ellipsis-full-container-hidden");
    private final By officeBtn = By.xpath("//a[@id='officeMenu']");
    private final By myPhoto = By.xpath("//img[@class='small-image']");

    public SelectedIndividualPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public boolean photoIsDisplayed() {
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(myPhoto)).isDisplayed();
    }

    public OfficePage clickOnOffice() {
        waitLong.until(ExpectedConditions.elementToBeClickable(officeBtn)).click();
        return new OfficePage(driver);
    }
}