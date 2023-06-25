Feature: I can find a city inside a state

"Test de tablas de ejemplos. Scenario Outline permite parámetros"
@List
Scenario Outline: As a Test Engineer, I want to validate that a text is presented
  Given I navigate to the list page
  When I search <state> in the list
  Then I can find <city> in the list

  Examples:
  |state        |city                  |
  |Washington   |Seattle, Washington   |
  |Chicago      |Chicago, Illionis     |


