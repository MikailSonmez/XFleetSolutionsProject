@regression
Feature: Default

  Background:
		#@FLTAPS-997
    Given the user is on the login page
    Then the user logged with "salesmanager120" "UserUser123"
    When the user navigates to "Fleet" "Vehicles"

  @FLTAPS-1135 @FLTAPS-1210 @smoke
  Scenario: as a salesmanager sould add event
    Then user should select any car or row
    Then user should display add event button

  @FLTAPS-1154
  Scenario: Only sales and storemanager can see "add Event"

    Then user should select any car or row
    Then user can click add event button

  @FLTAPS-1155
  Scenario:  Add Event should open as a pop up.(auto ercan)

    Then user should select any car or row
    Then user can click add event button
    Then user should display add event pop up

  @FLTAPS-1159 @FLTAPS-1161 @FLTAPS-1210 @smoke
  Scenario: mandatory fields in add Event (auto ercan)

    Then user should select any car or row
    Then user can click add event button
    And mandatory fields should display with * symbol
      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start Date             |
      | End Date               |


  @FLTAPS-1160 @FLTAPS-1161
  Scenario: Mandotary fields should filled

    Then user should select any car or row
    Then user can click add event button
    Then if any compulsary fields empty, error message should display