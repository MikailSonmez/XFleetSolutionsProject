package pages;

import utilities.BrowserUtils;
import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();

    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }



    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(userName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        //     String moduleLocator2 = "//span[@class='title title-level-1' and contains(text(),'"+ module + "')]";

        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        //     String moduleLocator2 = "//span[@class='title title-level-2' and contains(text(),'"+ module + "')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }
    }

    @FindBy(css = ".open > .dropdown-toggle")
    public WebElement openDropdownToggle;

    public void actionWithRowNo(int rowNo, String typeOfAction) {
        // String rowNoLocator = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu']["+rowNo+"]";
        String rowNoLocator = "(//table//a[@class='dropdown-toggle'])["+rowNo+"]";
        String typeOfActionLocator = "(//li[@class='launcher-item']/a[@title='"+typeOfAction+"'])[last()]";



        try {
            BrowserUtils.waitForClickablility(By.xpath(rowNoLocator), 10);
            WebElement tabElement = Driver.get().findElement(By.xpath(rowNoLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(openDropdownToggle).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(rowNoLocator), 10);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(typeOfActionLocator), 10);
            BrowserUtils.waitForVisibility(By.xpath(typeOfActionLocator), 10);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(typeOfActionLocator)));
            Driver.get().findElement(By.xpath(typeOfActionLocator)).click();
        } catch (Exception e) {
            //       BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(typeOfActionLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(typeOfActionLocator)),  10);
        }
    }

}
