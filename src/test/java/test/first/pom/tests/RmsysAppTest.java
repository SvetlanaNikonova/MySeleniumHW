package test.first.pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.first.pom.base.BaseTest;
import test.first.pom.pages.*;
import test.first.pom.utils.ConfigLoader;

public class RmsysAppTest extends BaseTest {

    @Test
    public void loggingToRMSysAndCheckingEmployee() {
        String searchForPerson = "svetlana nikonova";
        String searchForLocation = "Vilnius";

        LoginPage loginPage = new LoginPage(getDriver()).load();
        loginPage.login(ConfigLoader.getInstance().getEmail(), ConfigLoader.getInstance().getPassword());

        Assert.assertTrue(loginPage.microsoftIsDisplayed(), "Microsoft page is not displayed");

        HomePage homePage = new HomePage(getDriver());
        homePage.shouldAppear();

        IndividualPage individualPage = homePage.clickOnIndividualMenuLink();
        individualPage.shouldAppear();
        individualPage.enterTextInSearchFld(searchForPerson);

        SelectedIndividualPage selectedIndividualPage = individualPage.clickSearchBtn();
        Assert.assertEquals(selectedIndividualPage.getTitle(), "Nikonova, Svetlana");
        Assert.assertTrue(selectedIndividualPage.photoIsDisplayed(), "Photo is not displayed");

        OfficePage officePage = selectedIndividualPage.clickOnOffice();
        officePage.shouldAppear();
        officePage.enterTextInSearchField(searchForLocation);
        officePage.searchForOffice();
        Assert.assertEquals(officePage.getTitle(), "Vilnius");

        System.out.println("Number of employees in Vilnius: " + officePage.countEmployees());

        Assert.assertTrue(officePage.checkMyDeskIsDisplayed(), "My desk number is not displayed");
        System.out.println("My desk number: " + officePage.getDeskNumber());

        System.out.println("Selected employee: " + officePage.selectAnyEmployee());
        Assert.assertTrue(officePage.checkRandomEmployeeIsDisplayed(), "Selected employee is not displayed");

        officePage.closeEmployeePopup();
        System.out.println("Number of employees in Vilnius after checking random employee info: " +
                officePage.countEmployees());

        officePage.clickWorkplace();

        Assert.assertTrue(officePage.checkMyDeskIsDisplayed(), "My desk number is not displayed");
        System.out.println("My desk number in Workplace: " + officePage.getMyDeskNumber());
        Assert.assertTrue(officePage.checkMyInfoInWorkplace(), "My info is not correct");

        officePage.clickMyPhoto();
        Assert.assertEquals(officePage.checkPhotoInPopup(), selectedIndividualPage.photoIsDisplayed(),
                "Photos are not equal");

        officePage.clickWorkplaceInPopup();
        Assert.assertEquals(officePage.isWorkplaceUrInEmployeeDisplayed(), officePage.isWorkplaceUrlDisplayed(),
                "Urls are not match!");
    }
}