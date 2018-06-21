
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
    Then I get to usernam information
    And I get to password information
    And I open login page
    And I input to password textbox 
    And I input to password textbox 
    And I submit button
    And I verify homepage welcome message displayed
