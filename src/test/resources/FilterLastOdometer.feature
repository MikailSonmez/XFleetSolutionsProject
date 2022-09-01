@lom @regression
Feature: Vehicle - Filters - Last Odometer filter menu

	#1- User can select "Last Odometer" filter under 'Fleet-Vehicles' page{color}

  @FLTAPS-1169 @FLTAPS-1189 @smoke @FLTAPS-1210
  Scenario: Vehicles_Filter_Last Odometer_selecting
    Given the user is on the login page
    And the user logged with "user1" "UserUser123"
    When the user navigates to Fleet, Vehicles
    When user clicks the Filter button
    And user clicks the Manage filters button
    When user clicks the Last Odometer button
    Then users should see the Last Odometer:All dropbox

	#*2- "Last Odometer" filter should provide the methods shown as below:{color}

  @FLTAPS-1170 @FLTAPS-1189
  Scenario: Vehicles_Filter_Last Odometer_methods
    Given the user is on the login page
    And the user logged with "user1" "UserUser123"
    When the user navigates to Fleet, Vehicles
    When user clicks the Filter button
    And user clicks the Manage filters button
    When user clicks the Last Odometer button
    And user clicks the Last Odometer:All button
    And user clicks the method drop down button
    Then users should see the following list
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals or More Than |
      | Equals or Less Than |
      | Is Empty            |
      | Is Not Empty        |


	#*3- When user selects "Between" method with numeric values, the results should be between the specified values*

  @FLTAPS-1171 @FLTAPS-1189
  Scenario Outline: Last Odometer Methods Range -- Between
    Given the user is on the login page
    And the user logged with "user1" "UserUser123"
    When the user navigates to Fleet, Vehicles
    When user clicks the Filter button
    And user clicks the Manage filters button
    When user clicks the Last Odometer button
    And user clicks the Last Odometer:All button
    And user clicks the method drop down button
    And user selects between method and enters "<low range>" and "<top range>"
    Examples:
      | low range | top range |
      | 50000     | 250000    |


	#4- When user selects "Equals" method with numeric values, the results should match the specified value exactly

  @FLTAPS-1172 @FLTAPS-1189
  Scenario: Last Odometer Methods Range -- Equals

    Given the user is on the login page
    And the user logged with "user1" "UserUser123"
    When the user navigates to Fleet, Vehicles
    When user clicks the Filter button
    And user clicks the Manage filters button
    When user clicks the Last Odometer button
    And user clicks the Last Odometer:All button
    And user clicks the method drop down button
    And user selects equals method on drop down
    And user enter "230650"




	#{color:#FF0000}7- When user selects "Is Empty" method, only empty values should be displayed.{color}

  @FLTAPS-1173 @FLTAPS-1189
  Scenario: Last Odometer Methods Range -- Is Empty
    Given the user is on the login page
    And the user logged with "user1" "UserUser123"
    When the user navigates to Fleet, Vehicles
    When user clicks the Filter button
    And user clicks the Manage filters button
    When user clicks the Last Odometer button
    And user clicks the Last Odometer:All button
    And user clicks the method drop down button
    And user selects Is Empty method on drop down