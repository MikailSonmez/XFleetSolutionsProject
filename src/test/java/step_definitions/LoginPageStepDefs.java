package step_definitions;

import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPageStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user logged with {string} {string}")
    public void the_user_logged_with(String username, String password) {
        loginPage.login(username, password);
        BrowserUtils.waitForPageToLoad(20);
    }

    @Then("the pageTitle should be {string}")
    public void the_pageTitle_should_be(String expectedTitle) {
        BrowserUtils.waitForVisibility(loginPage.actualName,20);
        String actualTitle = Driver.get().findElement(By.cssSelector(".oro-subtitle")).getText().trim();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the message should be {string}")
    public void theMessageShouldBe(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.alertMessage.getText());
    }

    @When("the user clicked {string} button")
    public void theUserClickedButton(String button) {
        Driver.get().findElement(By.linkText(button)).click();
    }

    @Then("verify page title {string}")
    public void verifyPageTitle(String expectedTitle) {
        BrowserUtils.waitForPageToLoad(15);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("verify the link Remember Me is exist")
    public void verifyTheLinkRememberMeIsExist() {
        Assert.assertTrue(loginPage.rememberMeLink.isDisplayed());
    }

    @Then("verify the link Remember Me is clickable")
    public void verifyTheLinkRememberMeIsClickable() {
        Assert.assertTrue(loginPage.rememberMeLink.isEnabled());
    }


    @When("the user logged with enter key {string} {string}")
    public void theUserLoggedWithEnterKey(String username, String password) {
        loginPage.loginWithEnter(username,password);
    }

    @Then("the username {string} is displayed")
    public void theUsernameIsDisplayed(String expectedName) {
        BrowserUtils.waitForVisibility(loginPage.actualName,15);
        Assert.assertEquals(expectedName,loginPage.actualName.getText().trim());
    }

    @Then("the pop up message should be {string}")
    public void thePopUpMessageShouldBe(String popMessage) {
        Assert.assertTrue(loginPage.popUpMessage(popMessage));
    }

    @When("verify password input bullet sign")
    public void verifyPasswordInputBulletSign() {
        Assert.assertEquals("password",loginPage.passwordInpt.getAttribute("type"));
    }
}