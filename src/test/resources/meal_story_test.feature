Feature: As a user i need to search meal on the list


  @SearchByName
  Scenario: Search by Name
    Given mealName
    When Search by Name "Hamburger"
    Then Name should be in list