@FLTAPS-979 @regression
Feature: LoginPageSmoke


  @FLTAPS-968 @FLTAPS-980 @smoke @FLTAPS-1210
  Scenario Outline: Login Function With Valid Credentials
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pageTitle should be "<title>"

    Examples:
      | username        | password    | title           |
      | user1           | UserUser123 | Quick Launchpad |
      | salesmanager120 | UserUser123 | Dashboard       |
      | storemanager85  | UserUser123 | Dashboard       |


  @FLTAPS-969 @FLTAPS-980 @smoke @FLTAPS-1210
  Scenario Outline: Login Function With Invalid Credentials
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the message should be "<alertMessage>"

    Examples:
      | username         | password     | alertMessage                  |
      | wuser1           | UserUser123  | Invalid user name or password. |
      | user1            | wUserUser123 | Invalid user name or password. |
      | wsalesmanager120 | UserUser123  | Invalid user name or password. |
      | salesmanager120  | wUserUser123 | Invalid user name or password. |
      | wstoremanager85  | UserUser123  | Invalid user name or password. |
      | storemanager85   | wUserUser123 | Invalid user name or password. |


  @FLTAPS-970 @FLTAPS-980
  Scenario Outline: Login Function With Empty Inputs
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the pop up message should be "<fillMessage>"


    Examples:
      | username | password    | fillMessage                 |
      |          | UserUser123 | Please fill out this field. |
      | user1    |             | Please fill out this field. |
      |          |             | Please fill out this field. |



  @FLTAPS-971 @FLTAPS-980
  Scenario: Verify Forgot Password Page
    Given the user is on the login page
    When the user clicked "Forgot your password?" button
    Then verify page title "Forgot Password"


  @FLTAPS-972 @FLTAPS-980
  Scenario: Verify Remember Link
    Given the user is on the login page
    When verify the link Remember Me is exist
    Then verify the link Remember Me is clickable


  @FLTAPS-973 @FLTAPS-980 @smoke @FLTAPS-1210
  Scenario Outline: Verify Enter Key
    Given the user is on the login page
    When the user logged with enter key "<username>" "<password>"
    Then the pageTitle should be "<title>"


    Examples:
      | username        | password    | title           |
      | user1           | UserUser123 | Quick Launchpad	|
      | salesmanager120 | UserUser123 | Dashboard       |
      | storemanager85  | UserUser123 | Dashboard       |


  @FLTAPS-974 @FLTAPS-980
  Scenario Outline: Verify Username displayed
    Given the user is on the login page
    When the user logged with "<username>" "<password>"
    Then the username "<name>" is displayed


    Examples:
      | username        | password    | name     |
      | user1           | UserUser123 | John Doe |
      | salesmanager120 | UserUser123 | John Doe |
      | storemanager85  | UserUser123 | John Doe |

  @FLTAPS-991 @FLTAPS-980
  Scenario:Verify Password Bullet Sign
    Given the user is on the login page
    When verify password input bullet sign