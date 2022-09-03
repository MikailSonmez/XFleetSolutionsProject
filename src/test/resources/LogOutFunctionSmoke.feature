@FLTAPS-982 @regression
Feature: LogOutFunctionSmoke

  Background:
		#@FLTAPS-986
    Given the user is on the login page
    When the user logged with "user1" "UserUser123"



  @FLTAPS-975 @FLTAPS-981 @smoke @FLTAPS-1210
  Scenario: Verify Logged out
    When users click the "Logout" button
    Then verify page title "Login"


  @FLTAPS-977 @FLTAPS-981
  Scenario: Verify Logged out after click step back
    When users click the "Logout" button
    Then verify page title "Login"
    And click step back button
    Then verify page title "Login"


  @FLTAPS-978 @FLTAPS-981
  Scenario: Verify Logged out with close tab
    When close the tab
    Then go to url of dashboard page
    Then verify page title "Login"