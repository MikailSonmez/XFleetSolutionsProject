@FLTAPS-1139 @regression
Feature: As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page

  # ESALKAN xFleet Project Features STARTS HERE
  # 1- User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
  @FLTAPS-1137 @FLTAPS-1139 @smoke @FLTAPS-1210
  Scenario Outline: View Per Page Button Options Feature
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    And view per page dropdown should have the following options:
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
      | storemanager85  | UserUser123 | Dashboard |

  # 2- The value of 'View Per Page' should be '25' by default
  @FLTAPS-1138 @FLTAPS-1139 @smoke @FLTAPS-1210
  Scenario Outline: View Per Page Dropdown Default Value Feature
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    And view per page default value should be "25"
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
      | storemanager85  | UserUser123 | Dashboard |


  # 3- 'View Per Page' includes the values shown as below and the user can select each of them:
  @FLTAPS-1151 @FLTAPS-1139
  Scenario Outline: View Per Page DropDown Options
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    And view per page dropdown should have the following options:
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    Then user select each following options one by one and verify the records displayed
      | 10  |
      | 25  |
      | 50  |
      | 100 |
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
      | storemanager85  | UserUser123 | Dashboard |


    # 4- User can sort a column in ascending or descending order by clicking the column name
    # 5- User can remove all sorting and filtering on the page by using the reset button
  @FLTAPS-1152 @FLTAPS-1139 @smoke @FLTAPS-1210
  Scenario Outline: All Cars Page Table Sorting Feature
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"
    And user navigate to the "Fleet" "Vehicles" page
    Then user should see the "All Cars" page
    And user click on a tab for sorting records
    Then user click on the reset button
    Examples:
      | username        | password    | title     |
      | salesmanager120 | UserUser123 | Dashboard |
      | storemanager85  | UserUser123 | Dashboard |











  # ESALKAN xFleet Project Features ENDS HERE