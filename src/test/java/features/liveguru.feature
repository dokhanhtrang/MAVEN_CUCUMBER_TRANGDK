@liveguru
Feature: Demo for scenario Outline/Datatable function

  Scenario Outline: Login to Live Guru site
    Given I open to live guru site
    And I open to my account page
    When I input to username textbox is "<Username>"
    And I input to password textbox is "<Password>"
    And I click to login button
    Then I verify homepage display
    When I click to Account Link
    And I click to logout link
    
    Examples:
    |Username                    |Password|
    |automationvalid@gmail.com   |111111  |
    |automationvalid_01@gmail.com|111111  |
    |automationvalid_02@gmail.com|111111  |
   
