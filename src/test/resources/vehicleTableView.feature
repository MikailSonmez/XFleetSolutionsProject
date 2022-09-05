@wip @regression
Feature: As a user, I should be able to see all vehicle information in a table under Fleet-Vehicle page

  @FLTAPS-1195 @smoke @FLTAPS-1210
  Scenario Outline: All user types can see all vehicle information under 'Fleet-Vehicles' module

    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then verify that user should see Table Headers and information

      | LICENSE PLATE        |
      | TAGS                 |
      | DRIVER               |
      | LOCATION             |
      | CHASSIS NUMBER       |
      | MODEL YEAR           |
      | LAST ODOMETER        |
      | IMMATRICULATION DATE |
      | FIRST CONTRACT DATE  |
      | CVVI                 |
      | SEATS NUMBER         |
      | DOORS NUMBER         |
      | COLOR                |
      | TRANSMISSION         |
      | FUEL TYPE            |
      | CO2 EMISSIONS        |


    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |

  @FLTAPS-1196
  Scenario Outline:  User can see the total page number
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then verify that user should see the total page number
    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |


  @FLTAPS-1197
  Scenario Outline: User can go to next page clicking ">" button and can go to previous page clicking "<" button
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    And verify that user should go next page clicking > button
    Then verify that user should go previous page clicking < button


    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |

  @FLTAPS-1198
  Scenario Outline: User can see total recordings of vehicles
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then verify that total recording of vehicles
    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |

  @FLTAPS-1199
  Scenario Outline: User can download table data in XLS or CSV format
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    And the user navigates to "Fleet" "Vehicles"
    Then verify that user should download table data in XLS or CSV format


    Examples:
      | username        | password    |
      | user10          | UserUser123 |
      | salesmanager127 | UserUser123 |
      | storemanager100 | UserUser123 |
