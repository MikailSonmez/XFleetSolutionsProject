package step_definitions;

import pages.DashBoardPage;
import pages.VehiclesPage;
import utilities.BrowserUtils;
import utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class DeleteCarStepDefinition {

    DashBoardPage dashBoardPage = new DashBoardPage();
    VehiclesPage vehiclePage = new VehiclesPage();
    Actions actions = new Actions(Driver.get());
    Random random = new Random();
    int totalNum;
    int totalNum2;

    @When("the user clicks Fleet,Vehicles module")
    public void the_user_clicks_Fleet_Vehicles_module() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateTo("Fleet","Vehicles");

    }

    @When("the user clicks three dot button")
    public void the_user_clicks_three_dot_button() {
        BrowserUtils.waitFor(3);
        actions.moveToElement(vehiclePage.anyThreeDot).perform();

    }

    @Then("the user can see delete feature")
    public void the_user_can_see_delete_feature() {
        BrowserUtils.waitFor(3);
        actions.moveToElement(vehiclePage.deleteIcon).perform();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(vehiclePage.deleteIcon.isDisplayed());
        vehiclePage.logOut();

    }

    @When("the user clicks delete button")
    public void the_user_clicks_delete_button() {
        BrowserUtils.waitFor(3);
        actions.moveToElement(vehiclePage.deleteIcon).perform();
        BrowserUtils.waitFor(3);
        vehiclePage.deleteIcon.click();

    }

    @Then("the user should see {string} pop up")
    public void the_user_should_see_pop_up(String string) {
        Assert.assertTrue(vehiclePage.deleteMessage.isDisplayed());
        vehiclePage.logOut();

    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String string) {
        BrowserUtils.waitFor(3);
        vehiclePage.deleteMessageYesBtn.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(vehiclePage.deletePermissionMessage.isDisplayed());
        vehiclePage.logOut();

    }

    @When("the user clicks delete button any row of car")
    public void the_user_clicks_delete_button_any_row_of_car() {
        BrowserUtils.waitFor(3);
        vehiclePage.deleteIcon.click();
        BrowserUtils.waitFor(3);
        vehiclePage.deleteMessageYesBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user can delete any car in the list")
    public void the_user_can_delete_any_car_in_the_list() {
        Assert.assertTrue(vehiclePage.itemDeletedMessage.isDisplayed());
        vehiclePage.logOut();

    }

    @When("the user clicks any car row")
    public void the_user_clicks_any_car_row() {
        BrowserUtils.waitFor(3);
        vehiclePage.anyCarRow.click();

    }

    @When("the user clicks delete button in the {string} page")
    public void the_user_clicks_delete_button_in_the_page(String string) {
        BrowserUtils.waitFor(3);
        vehiclePage.generalInfoPageDeleteBtn.click();
    }

    @When("the user deleted any car")
    public void the_user_deleted_any_car() {
        BrowserUtils.waitFor(3);
        String totalNumStr = vehiclePage.totalCarNumber.getText();
        String[] split = totalNumStr.split(" ");
        totalNum = Integer.parseInt(split[2]);
        BrowserUtils.waitFor(3);
        actions.moveToElement(vehiclePage.anyThreeDot).perform();
        BrowserUtils.waitFor(3);
        vehiclePage.deleteIcon.click();
        BrowserUtils.waitFor(2);
        vehiclePage.deleteMessageYesBtn.click();
        BrowserUtils.waitFor(2);
        String totalNumStr2 = vehiclePage.totalCarNumber.getText();
        String[] split2 = totalNumStr2.split(" ");
        totalNum2 = Integer.parseInt(split2[2]);

    }

    @Then("the user car should be deleted")
    public void the_user_car_should_be_deleted() {
        Assert.assertTrue(totalNum-1==totalNum2);

        vehiclePage.logOut();


    }

}