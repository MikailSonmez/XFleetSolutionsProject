@FLTAPS-1203
Feature: Default

  @FLTAPS-1156 @FLTAPS-1210 @smoke
  Scenario: User can see delete button
    Given the user is on the login page
    When the user logged with "storemanager85" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    Then the user can see delete feature

    Given the user is on the login page
    When the user logged with "salesmanager120" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    Then the user can see delete feature

  @FLTAPS-1158
  Scenario: Users should see "Delete Confirmation" pop up
    Given the user is on the login page
    When the user logged with "storemanager85" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    And the user clicks delete button
    Then the user should see "Delete Confirmation" pop up

    Given the user is on the login page
    When the user logged with "salesmanager120" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    And the user clicks delete button
    Then the user should see "Delete Confirmation" pop up

  @FLTAPS-1184 @FLTAPS-1210 @smoke
  Scenario: Driver can't see "You do not have permission to perform this action"
    Given the user is on the login page
    When the user logged with "user10" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    And the user clicks delete button
    Then the user should see "You do not have permission to perform this action" message

  @FLTAPS-1185
  Scenario: "Item deleted" message should be displayed
    Given the user is on the login page
    When the user logged with "storemanager85" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    And the user clicks delete button any row of car
    Then the user can delete any car in the list

    Given the user is on the login page
    When the user logged with "salesmanager120" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks three dot button
    And the user clicks delete button any row of car
    Then the user can delete any car in the list

  @FLTAPS-1186
  Scenario: 'Sales Manager' and 'Store Manager' can delete any car in 'General Information' page
    Given the user is on the login page
    When the user logged with "storemanager85" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks any car row
    And the user clicks delete button in the 'General Information' page
    Then the user should see "Car deleted" message

    Given the user is on the login page
    When the user logged with "salesmanager120" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user clicks any car row
    And the user clicks delete button in the 'General Information' page
    Then the user should see "Car deleted" message

  @FLTAPS-1187 @kaan
  Scenario: Deleted car should be removed
    Given the user is on the login page
    When the user logged with "storemanager85" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user deleted any car
    Then the user car should be deleted

    Given the user is on the login page
    When the user logged with "salesmanager120" "UserUser123"
    And the user clicks Fleet,Vehicles module
    And the user deleted any car
    Then the user car should be deleted