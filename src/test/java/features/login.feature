
@account
Feature: CREATE ACCOUNT
  I want to create an account
  So that i can verify register function work well

  Scenario: Create an account
    Given I open browser
    And I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button
    And I get to username information
    And I get to password information
    And I open login page
    And I input to username textbox 
    And I input to password textbox 
    And I submit button
    Then I verify homepage welcome message displayed
    And I click to New Customer Page
    And I input all information in this page
    |Customer   |Gender|DateOfBirth  |Address|City |State|PIN   |Phone     |Email|Password   |
    |Khanh Trang|f     |28/06/1995   |HBT    |Hanoi| VN  |123456|0163842125|trangdk |123456  |
    And I click sub button
    And I close browser
