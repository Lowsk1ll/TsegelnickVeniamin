Feature: exercise 1
  Scenario: select and check elements on differentElementsPage
    Given I open JDI GitHub site
    And I login user with name 'Roman' and pass 'Jdi1234'
    And I open through 'headerSection' and 'service' different elements page
    When I select elements 'Water, Wind, Selen'
    And I select in dropdownmenu 'Yellow'
    Then I check that elements 'Water, Wind, Selen' are selected
    And I check that dropdownmenu is select 'Yellow'
    And I check that logrows is displayed elements 'Water, Wind, Selen, Yellow'
