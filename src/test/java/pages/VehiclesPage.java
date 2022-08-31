package pages;

import utilities.BrowserUtils;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage {

    // ErcanEAK project code's line STARTS here
    @FindBy(xpath = "(//tbody//tr/td[2])[5]")
    public WebElement anyVehicles;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;    //#ui-id-1 id of pop up

    @FindBy(id = "ui-id-1 id of pop up")
    public WebElement AddEventpopUp;

    @FindBy(css = ".control-label.wrap")
    public List<WebElement> addEventPopUpInptLabels;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement getAddEventpopUpCancel;

    @FindBy(xpath = "//span[text()='This value should not be blank.']")
    public WebElement ErrorMsgOfAddEvent;

    @FindBy(css = "button[type='submit']")
    public WebElement addEventButtonSaveButton;

    public void checkMandatoryItems(List<String> expectedTitles) {
        try {
            for (WebElement e : addEventPopUpInptLabels) {
                if (expectedTitles.contains(e.getText())) {
                    Assert.assertEquals("required", e.getAttribute("class"));
                }
            }
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        } finally {
            getAddEventpopUpCancel.click();
        }
    }
    // ErcanEAK project code's line ENDS here


    // Eren project code's line STARTS here

    @FindBy(xpath = "//a[@title='View']")
    public WebElement eyeIcon;

    @FindBy(xpath = "(//a[@data-toggle='dropdown'])[11]")
    public WebElement anyThreeDot;

    @FindBy(xpath = "//tr[4]/td[contains(@class,'grid-cell')]")
    public List<WebElement> anyRowInformationList;

    // Eren project code's line ENDS heredf

    // Kaan project code's line STARTS here

    @FindBy(xpath = "(//li[@class='launcher-item']/a[@title='Delete'])[last()]")
    public WebElement deleteIcon;

    @FindBy(xpath = "//*[contains(text(),'Delete Confirm')]")
    public WebElement deleteMessage;

    @FindBy (xpath = "//*[contains(text(),'You do not have permission to perform this action.')]")
    public WebElement deletePermissionMessage;

    @FindBy(xpath = "//*[contains(text(),'Yes, Delete')]")
    public WebElement deleteMessageYesBtn;

    @FindBy(xpath = "//*[contains(text(),'Total of')]")
    public WebElement totalCarNumber;

    @FindBy(xpath = "//*[contains(text(),'Item deleted')]")
    public WebElement itemDeletedMessage;

    @FindBy(xpath = "(//*[@class='grid-row'])[5]")
    public WebElement anyCarRow;

    @FindBy(xpath = "//*[@class=' btn icons-holder-text no-hash remove-button']")
    public WebElement generalInfoPageDeleteBtn;

    // Kaan project code's line ENDS heredf


    // esalkan project code's line STARTS here

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div[starts-with(@class,'btn-group')]")
    public WebElement viewPerPageDropDownButton;

    @FindBy(xpath = "//*/ul/li/a[@class='dropdown-item']")
    public List<WebElement> dropDownOptions;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> vehicleRows;

    @FindBy(xpath = "//table/thead/tr/th/a/span[contains(text(),'Model Year')]")
    public WebElement modelYearTab;

    @FindBy(xpath = "//div[@class='pull-right grid-toolbar-tools']//a[@title='Reset']")
    public WebElement resetButton;

    public List<String> getDropdownOptionsText() {
        List<String> dropDownOptionsText = new ArrayList<>();
        viewPerPageDropDownButton.click();
        for (WebElement option : dropDownOptions) {
            dropDownOptionsText.add(option.getText());
        }
        return dropDownOptionsText;
    }

    public void tableSortResult() {
        int counter = vehicleRows.size();
        List<String> beforeSortRowCellData = new ArrayList<>();
        for (int i = 1; i <= counter; i++) {
            beforeSortRowCellData.add(Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]")).getText());
        }
        modelYearTab.click();
        BrowserUtils.waitFor(2);
        int sortCounter = vehicleRows.size();
        List<String> afterSortRowCellData = new ArrayList<>();
        for (int i = 1; i <= sortCounter; i++) {
            afterSortRowCellData.add(Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]")).getText());
            //return tableSortResult();
        }
        //Added By @CharlieAlfa
        for(int i = 1; i < sortCounter; i++){
            if (!afterSortRowCellData.get(i).equals("")) {
                if (!afterSortRowCellData.get(i - 1).equals("")) {
                    Assert.assertTrue(Integer.parseInt(afterSortRowCellData.get(i).trim()) >= Integer.parseInt(afterSortRowCellData.get(i - 1).trim()));
                }
            }
        }
    }
    // esalkan project code's line ENDS here

    // Erdem's codes starting

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextPageButton;

    @FindBy(xpath = "//i[@class='fa-chevron-left hide-text']")
    public WebElement previousPageButton;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement textOfTotalPage;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement fullText;

    @FindBy(xpath = "//div[@class='btn-group']//div")
    public WebElement exportGridButton;

    @FindBy(xpath = "//a[@title='CSV']")
    public WebElement csvFormat;

    @FindBy(xpath = "//a[@title='XLSX']")
    public WebElement xlsxFormat;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement exportVerificationMessage;


    public Integer getTotalPageNumber() {
        String text = textOfTotalPage.getText();
        String totalPageNumber = text.split(" ")[1];
        System.out.println(totalPageNumber);
        return Integer.parseInt(totalPageNumber);
    }

    public Integer getNumberOfCurrentPage() {
        for (int i = 1; i < getTotalPageNumber(); i++) {
            nextPageButton.click();
            BrowserUtils.waitFor(3);
        }
        String pageNumberText = pageNumber.getAttribute("value");
        System.out.println("pageNumberText = " + pageNumberText);
        return Integer.parseInt(pageNumberText);
    }

    public Integer getPageNumber() {
        return Integer.parseInt(pageNumber.getAttribute("value"));
    }

    public Boolean verificationMessageCSVIsDisplayed() {
        exportGridButton.click();
        csvFormat.click();
        BrowserUtils.waitFor(3);
        return exportVerificationMessage.isDisplayed();
    }

    public Boolean verificationMessageXLSXIsDisplayed() {

        exportGridButton.click();
        xlsxFormat.click();
        BrowserUtils.waitFor(3);
        return exportVerificationMessage.isDisplayed();
    }

    // Erdem's codes finished

    //burak's code begins here.....

    @FindBy(css = "[class='fa-filter hide-text']")
    //@FindBy(css = "a[class^='action btn mode-icon-only'][title='Filters']")

    //@FindBy(xpath = "//a[starts-with(@class,'action btn mode-icon-only')]")
    //@FindBy(linkText = "Filters")
    public WebElement filterButton;

    @FindBy(css = "a[class^='add-filter-button']")
    public WebElement manageFiltersButton;

    @FindBy(css = "input[id='ui-multiselect-0-0-option-6']")
    public WebElement lastOdometerCheckBox;

    @FindBy(xpath = "//div[contains(text(),'Last Odometer')]")
    public WebElement lastOdometerDropOpener;

    @FindBy(css = "button[class='btn dropdown-toggle']")
    public WebElement lastOdometerDropDownToggle;

    //All the methods on drop down menu.
    @FindBy(css = "a[class='dropdown-item choice-value']")
    public WebElement lastOdometerDropDownMenu;

    //Last odometer drop down toggles options/methods
    //xpath locaters for containing texts

    @FindBy(xpath = "//a[.='between']")
    public WebElement lastOdometerDropDownBetween;

    @FindBy(xpath = "//a[.='not between']")
    public WebElement lastOdometerDropDownNotBetween;

    @FindBy(xpath = "//a[.='equals']")
    public WebElement lastOdometerDropDownEquals;

    @FindBy(xpath = "//a[.='not equals']")
    public WebElement lastOdometerDropDownNotEquals;

    @FindBy(xpath = "//a[.='more than']")
    public WebElement lastOdometerDropDownMoreThan;

    @FindBy(xpath = "//a[.='less than']")
    public WebElement lastOdometerDropDownLessThan;

    @FindBy(xpath = "//a[.='equals or more than']")
    public WebElement lastOdometerDropDownEqualsOrMoreThan;

    @FindBy(xpath = "//a[.='equals or less than']")
    public WebElement lastOdometerDropDownEqualsOrLessThan;

    @FindBy(xpath = "//a[.='is empty']")
    public WebElement lastOdometerDropDownIsEmpty;

    @FindBy(xpath = "//a[.='is not empty']")
    public WebElement lastOdometerDropDownIsNotEmpty;

    //input boxes low and top values for the search range
    @FindBy(css = "input[name='value']")
    public WebElement lastOdometerLowRange;

    @FindBy(css = "input[name='value_end']")
    public WebElement lastOdometerTopRange;

    //last Odometer searching results
    @FindBy(css = "td[data-column-label='Last Odometer']")
    public WebElement lastOdometerResults;

    //Update button for low and top input search
    @FindBy(css = "button[class='btn btn-primary filter-update']")
    public WebElement lastOdometerUpdateButton;

    //for verify actual result. Locator show us a list of actual results.
    @FindBy(css = " td[class='number-cell grid-cell grid-body-cell grid-body-cell-LastOdometer']")
    public WebElement lastOdometerActualResult;

}