@RunWith
Feature: Website is deployed Properly

Scenario: Website is deployed and loading
    Given I have opened the browser
    When i visit website
    Then website returns content