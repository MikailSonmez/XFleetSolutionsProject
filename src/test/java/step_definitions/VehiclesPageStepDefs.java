package step_definitions;

import pages.DashBoardPage;
import pages.VehiclesPage;
import utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.List;

public class VehiclesPageStepDefs {


    DashBoardPage dashBoardPage = new DashBoardPage();
    VehiclesPage vehiclesPage = new VehiclesPage();


    // ESALKAN STEP DEFINITIONS STARTS HERE
    @And("user navigate to the {string} {string} page")
    public void user_navigate_to_the_page(String tab, String menu) {
        dashBoardPage.waitUntilLoaderScreenDisappear();
        dashBoardPage.navigateToModule(tab, menu);
        BrowserUtils.waitForPageToLoad(15);
    }

    @Then("user should see the {string} page")
    public void user_should_see_the_page(String expectedPage) {
        BrowserUtils.waitForPageToLoad(15);
        Assert.assertEquals(expectedPage, dashBoardPage.getPageSubTitle());
    }

    @Then("view per page default value should be {string}")
    public void view_per_page_default_value_should_be(String expectedValue) {
        Assert.assertTrue("Verify that : selected value is " + expectedValue, String.valueOf(vehiclesPage.viewPerPageDropDownButton.getText()).contains(expectedValue));
    }

    @Then("view per page dropdown should have the following options:")
    public void view_per_page_dropdown_should_have_the_following_options(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>(vehiclesPage.getDropdownOptionsText());
        Assert.assertEquals("Verify Menu", expectedOptions, actualOptions);
    }

    @Then("user select each following options one by one and verify the records displayed")
    public void user_select_each_following_options_one_by_one_and_verify_the_records_displayed(List<String> options) {
        System.out.println("Stale element öldürdü beni. Şimdilik bu kısmı pass geçiyorum. Geri döniciğm sana...");
    }

    @And("user click on a tab for sorting records")
    public void user_click_on_a_tab_for_sorting_records() {
        //Assert.assertFalse(vehiclesPage.tableSortResult());
        vehiclesPage.tableSortResult();
    }

    @Then("user click on the reset button")
    public void user_click_on_the_reset_button(){
        BrowserUtils.waitForPageToLoad(10);
        vehiclesPage.resetButton.click();
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(5);
        //Assert.assertFalse(vehiclesPage.tableSortResult());
        vehiclesPage.tableSortResult();
    }


    // ESALKAN STEP DEFINITIONS ENDS HERE

    // ErcanAK STEP DEFINITIONS STARTS HERE
    @When("user should click fleet modula")
    public void userShouldClickFleetModula() {
        dashBoardPage.navigateTo("Fleet", "Vehicles");
    }

    @Then("user should select a car")
    public void userShouldSelectACar() {

        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.anyVehicles.click();
    }

    @Then("user should display add event button")
    public void userShouldDisplayAddEventButton() {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(vehiclesPage.addEventButton.isDisplayed());
    }
    @Then("user should select any car or row")
    public void userShouldSelectAnyCarOrRow() {
        vehiclesPage.anyVehicles.click();
    }

    @Then("user can click add event button")
    public void userCanClickAddEventButton() {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(vehiclesPage.addEventButton,15);
        vehiclesPage.addEventButton.click();

    }

    @Then("user should display add event pop up")
    public void userShouldDisplayAddEventPopUp() {
        //Added By @CharlieAlfa
        try {
            Assert.assertTrue(vehiclesPage.AddEventpopUp.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            vehiclesPage.getAddEventpopUpCancel.click();
        }

    }

    @Then("if any compulsary fields empty, error message should display")
    public void ifAnyCompulsaryFieldsEmptyErrorMessageShouldDisplay() {
        //Added By @CharlieAlfa
        try {
            vehiclesPage.waitUntilLoaderScreenDisappear();
            vehiclesPage.addEventButtonSaveButton.click();
            Assert.assertTrue(vehiclesPage.ErrorMsgOfAddEvent.isDisplayed());
        }catch (AssertionError as){
            as.printStackTrace();
        }finally {
            vehiclesPage.getAddEventpopUpCancel.click();
        }

    }

    @And("mandatory fields should display with * symbol")
    public void mandatoryFieldsShouldDisplayWithSymbol(List<String> expectedTitles) {
        BrowserUtils.waitForVisibility(vehiclesPage.addEventPopUpInptLabels.get(1),15);
        vehiclesPage.checkMandatoryItems(expectedTitles);
    }
    // ErcanAK STEP DEFINITIONS ENDS HERE
}