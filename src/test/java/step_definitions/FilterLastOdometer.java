package step_definitions;

import pages.DashBoardPage;
import pages.GridPage;
import pages.VehiclesPage;
import utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilterLastOdometer {

    VehiclesPage vehiclesPage = new VehiclesPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("the user navigates to Fleet, Vehicles")
    public void the_user_navigates_to_Fleet_Vehicles() {
        dashBoardPage.navigateTo("Fleet", "Vehicles");
    }


    @When("user clicks the Filter button")
    public void user_clicks_the_Filter_button() {
        //  Thread.sleep(10000);
        //BrowserUtils.waitForVisibility(vehiclesPage.filterButton,10);
        vehiclesPage.waitUntilLoaderScreenDisappear();//Added By @CharlieAlfa
        BrowserUtils.waitForClickablility(vehiclesPage.filterButton, 15).click();
        //action.moveToElement(vehiclesPage.filterButton).click().perform();
    }

    @When("user clicks the Manage filters button")
    public void user_clicks_the_Manage_filters_button() {
        // Thread.sleep(10000);

        //BrowserUtils.waitForVisibility(vehiclesPage.manageFiltersButton,10);
        BrowserUtils.waitForClickablility(vehiclesPage.manageFiltersButton, 5).click();

    }

    @When("user clicks the Last Odometer button")
    public void user_clicks_the_Last_Odometer_button() {
        BrowserUtils.waitForClickablility(vehiclesPage.lastOdometerCheckBox, 5).click();
    }

    @Then("users should see the Last Odometer:All dropbox")
    public void users_should_see_the_Last_Odometer_All_dropbox() {
        Assert.assertTrue(vehiclesPage.lastOdometerDropOpener.isDisplayed());

    }

    @When("user clicks the Last Odometer:All button")
    public void user_clicks_the_Last_Odometer_All_button() {
        vehiclesPage.lastOdometerDropOpener.click();

    }


    @When("user clicks the method drop down button")
    public void user_clicks_the_method_drop_down_button() {
        vehiclesPage.lastOdometerDropDownToggle.click();

    }

    @Then("users should see the following list")
    public void users_should_see_the_following_list(io.cucumber.datatable.DataTable dataTable) {

        List<String> expectedLOMethodsOptions = new ArrayList<>();
        expectedLOMethodsOptions.add("Between");
        expectedLOMethodsOptions.add("Not Between");
        expectedLOMethodsOptions.add("Equals");
        expectedLOMethodsOptions.add("Not Equals");
        expectedLOMethodsOptions.add("More Than");
        expectedLOMethodsOptions.add("Less Than");
        expectedLOMethodsOptions.add("Equals Or More Than");
        expectedLOMethodsOptions.add("Equals Or Less Than");
        expectedLOMethodsOptions.add("Is Empty");
        expectedLOMethodsOptions.add("Is Not Empty");

        List<String> actualLOMethodsOptions = new ArrayList<>();

        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownBetween.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownNotBetween.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownEquals.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownNotEquals.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownMoreThan.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownLessThan.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownEqualsOrMoreThan.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownEqualsOrLessThan.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownIsEmpty.getText());
        actualLOMethodsOptions.add(vehiclesPage.lastOdometerDropDownIsNotEmpty.getText());


        Assert.assertEquals(actualLOMethodsOptions, expectedLOMethodsOptions);

    }

    @When("user selects between method and enters {string} and {string}")
    public void user_selects_method_and_enters_and(String string2, String string3) throws InterruptedException {


        vehiclesPage.lastOdometerDropDownBetween.click();
        vehiclesPage.lastOdometerLowRange.sendKeys(string2);
        vehiclesPage.lastOdometerTopRange.sendKeys(string3);
        // Thread.sleep(5000);
        vehiclesPage.lastOdometerUpdateButton.click();
        Thread.sleep(3000);
        BrowserUtils.waitForPresenceOfElement(By.cssSelector("td[data-column-label='Last Odometer']"), 10);

        int lowRange = Integer.parseInt(string2);
        int topRange = Integer.parseInt(string3);
        String actualRangeString = vehiclesPage.lastOdometerResults.getText();
        // System.out.println("actualRangeString = " + actualRangeString);

        actualRangeString = actualRangeString.replace(",", "");
        //System.out.println("actualRangeString = " + actualRangeString);


        int actualRange = Integer.parseInt(actualRangeString);

        if (actualRange >= lowRange && actualRange <= topRange) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


    }


    @And("user selects equals method on drop down")
    public void userSelectsEqualsMethodOnDropDown() {
        vehiclesPage.lastOdometerDropDownEquals.click();

    }


    @And("user enter {string}")
    public void userEnter(String arg0) throws InterruptedException {

        vehiclesPage.lastOdometerLowRange.sendKeys(arg0);
        vehiclesPage.lastOdometerUpdateButton.click();
        Thread.sleep(3000);
        BrowserUtils.waitForPresenceOfElement(By.cssSelector("td[data-column-label='Last Odometer']"), 10);
        int lowRange = Integer.parseInt(arg0);

        String actualRangeString = vehiclesPage.lastOdometerResults.getText();
        // System.out.println("actualRangeString = " + actualRangeString);

        actualRangeString = actualRangeString.replace(",", "");
        //System.out.println("actualRangeString = " + actualRangeString);


        int actualRange = Integer.parseInt(actualRangeString);

        if (actualRange == lowRange) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @And("user selects Is Empty method on drop down")
    public void userSelectsIsEmptyMethodOnDropDown() {
        vehiclesPage.lastOdometerDropDownIsEmpty.click();

        if (vehiclesPage.lastOdometerDropDownIsEmpty.getText().equals("")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }


}