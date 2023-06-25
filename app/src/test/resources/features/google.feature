Feature: Test Google search functionality

  Scenario: As a user, I enter a search query
    Given I am on the Google search page
    When I enter a search query
    And click on the search button
    Then I should see the search results
