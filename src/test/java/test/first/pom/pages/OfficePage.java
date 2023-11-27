package test.first.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.first.pom.base.BasePage;

import java.util.List;

import static test.first.pom.utils.TestUtils.getRandomNumber;


public class OfficePage extends BasePage {
    private final By inputFld = By.id("input-search");
    private final By searchBtn = By.id("search-button");
    private final By officeTitle = By.cssSelector("div.title");
    private final By employees = By.id("individualName");
    private final By myDeskNum = By.xpath("//td[normalize-space()='61']");
    private final By randomEmployeePopup = By.cssSelector("div#individualData");
    private final By closeEmployeePopup = By.cssSelector("span.ui-button-text");
    private final By workplaceIcon = By.xpath("//img[@title='View office layout plan']");
    private final By workplaceIconInPopup = By.xpath("//img[@id='img_office_chart_icon']");
    private final By myDeskNumWorkplace = By.xpath("// span[contains(., '1-61')]");
    private final By myElementInWorkplace = By.xpath("//img[contains(@title, 'Nikonova, Svetlana')]");
    private final By myPhotoInPopup = By.xpath("//img[@class='small-image']");


    public OfficePage(WebDriver driver) {
        super(driver);
    }

    public void shouldAppear() {
        waitUntilLoadingSpinnerDisappears();
        waitLong.until(ExpectedConditions.urlContains("/Office/"));
    }

    public OfficePage enterTextInSearchField(String text) {
        waitLong.until(ExpectedConditions.visibilityOfElementLocated(inputFld)).sendKeys(text);
        return this;
    }

    public OfficePage searchForOffice() {
        waitUntilLoadingSpinnerDisappears();
        waitLong.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public String getTitle() {
        waitUntilLoadingSpinnerDisappears();
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(officeTitle)).getText();
    }

    public int countEmployees() {
        return waitLong.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employees)).size();
    }

    public boolean checkMyDeskIsDisplayed() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(myDeskNum)).isDisplayed();
    }

    public String getDeskNumber() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(myDeskNum)).getText();
    }

    public String getMyDeskNumber() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(myDeskNumWorkplace)).getText().substring(2);
    }

    public String selectAnyEmployee() {
        List<WebElement> employees = waitLong.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("individualName")));
        int countEmployees = employees.size();
        WebElement employee = employees.get(getRandomNumber(countEmployees - 1));
        employee.click();
        return employee.getText();
    }

    public boolean checkRandomEmployeeIsDisplayed() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(randomEmployeePopup)).isDisplayed();
    }

    public OfficePage closeEmployeePopup() {
        waitShort.until(ExpectedConditions.elementToBeClickable(closeEmployeePopup)).click();
        return this;
    }

    public OfficePage clickWorkplace() {
        waitShort.until(ExpectedConditions.elementToBeClickable(workplaceIcon)).click();
        return this;
    }

    public boolean isWorkplaceUrlDisplayed() {
        return waitShort.until(ExpectedConditions.urlContains("/Office/Index#id-682d69"));
    }

    public OfficePage clickWorkplaceInPopup() {
        waitShort.until(ExpectedConditions.elementToBeClickable(workplaceIconInPopup)).click();
        return this;
    }

    public boolean isWorkplaceUrInEmployeeDisplayed() {
        return waitLong.until(ExpectedConditions.urlContains("/Office/Index#id-682d69"));
    }

    public boolean checkMyInfoInWorkplace() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(myElementInWorkplace)).isDisplayed();
    }

    public OfficePage clickMyPhoto() {
        waitLong.until(ExpectedConditions.elementToBeClickable(myElementInWorkplace)).click();
        return this;
    }

    public boolean checkPhotoInPopup() {
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(myPhotoInPopup)).isDisplayed();
    }
}