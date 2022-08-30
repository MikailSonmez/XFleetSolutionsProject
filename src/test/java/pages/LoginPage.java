package pages;

import utilities.ConfigurationReader;
import utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "_username")
    public WebElement usernameInpt;

    @FindBy(name = "_password")
    public WebElement passwordInpt;

    @FindBy(name = "_submit")
    public WebElement loginBtn;

    @FindBy(css = ".alert-error")
    public WebElement alertMessage;

    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    public WebElement rememberMeLink;

    @FindBy(css = "li>a.dropdown-toggle")
    public WebElement actualName;

    public LoginPage(){PageFactory.initElements(Driver.get(),this);}


    public void login(String username, String password) {
        usernameInpt.sendKeys(username);
        passwordInpt.sendKeys(password);
        loginBtn.click();

    }

    public void loginWithEnter(String username, String password) {
        usernameInpt.sendKeys(username);
        passwordInpt.sendKeys(password + Keys.ENTER);
    }

    public boolean popUpMessage(String message) {
        boolean flag = false;
        if (usernameInpt.getText().equals("")){
            if(usernameInpt.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(passwordInpt.getText().equals("")){
            if(passwordInpt.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        return flag;
    }

    public void loginAsStoreManager(){
        login(ConfigurationReader.get("store_manager_username"),ConfigurationReader.get("store_manager_password"));
    }
    public void loginAsSalesManager(){
        login(ConfigurationReader.get("sales_manager_username"),ConfigurationReader.get("sales_manager_password"));
    }
    public void loginAsDriver(){
        login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
    }

    public void loginAsUser(String userType) {
        switch (userType.toLowerCase()){
            case "driver":
                loginAsDriver();
                break;
            case "sales manager":
                loginAsSalesManager();
                break;
            case "store manager":
                loginAsStoreManager();
                break;
            default:
                throw new RuntimeException("Unknown user type!");
        }
    }
    public void loggedAs (String userType){
        Driver.get().get(ConfigurationReader.get("url"));

        String username ="";
        String password ="";

        if(userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")){
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }else if(userType.equals("store manager")){
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        new LoginPage().login(username,password);
    }

}