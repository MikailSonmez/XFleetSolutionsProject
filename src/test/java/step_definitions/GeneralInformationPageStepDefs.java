package step_definitions;

import pages.GeneralInformationPage;
import pages.VehiclesPage;
import utilities.BrowserUtils;
import utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GeneralInformationPageStepDefs {

    GeneralInformationPage generalInformationPage = new GeneralInformationPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.get());


    @Then("user should be on General Information page")
    public void user_should_be_on_General_Information_page() {
        Assert.assertEquals("Header is not as expected","General Information",generalInformationPage.generalInformationHeader.getText());

    }

    @When("user clicks Eye icon to navigate to General Information page")
    public void user_clicks_Eye_icon_to_navigate_to_General_Information_page() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(3);
        actions.moveToElement(vehiclesPage.anyThreeDot).perform();
        vehiclesPage.eyeIcon.click();

    }

    @Then("user should see Edit, Delete and Add Event buttons")
    public void user_should_see_Edit_Delete_and_Add_Event_buttons() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertTrue("Edit button is not displayed",generalInformationPage.editButton.isDisplayed());
        Assert.assertTrue("Delete button is not displayed",generalInformationPage.deleteButton.isDisplayed());
        Assert.assertTrue("Add Event button is not displayed",generalInformationPage.addEventButton.isDisplayed());

    }

    @Then("verify that information on the vehicles page are same as the information on the General Information page")
    public void verify_that_information_on_the_vehicles_page_are_same_as_the_information_on_the_General_Information_page() {
        BrowserUtils.waitForPageToLoad(10);

        List<String> vehiclesInfo = BrowserUtils.getElementsText(vehiclesPage.anyRowInformationList);


        for (int i = 1; i < vehiclesPage.anyRowInformationList.size()-1; i++) {
//            System.out.println(vehiclesInfo.get(i));
            vehiclesInfo.set(i,vehiclesInfo.get(i).replace(",",""));
        }

        vehiclesPage.anyRowInformationList.get(1).click();

        List<String> generalInfo = BrowserUtils.getElementsText(generalInformationPage.generalInformationList);

        for (int i = 0; i < 19; i++) {
//            System.out.println(generalInfo.get(i));
            generalInfo.set(i,generalInfo.get(i).replace(",",""));
        }

        for (int i = 0; i < 19; i++) {
            if(generalInfo.get(i).equals("N/A")){
                generalInfo.set(i,"");
            }
            Assert.assertEquals("Information is not same",vehiclesInfo.get(i+1),generalInfo.get(i));

        }

    }

}