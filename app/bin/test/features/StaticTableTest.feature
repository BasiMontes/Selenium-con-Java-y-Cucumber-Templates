Feature: Test different actions on a static table Page.

"YA NO ES NECESARIO ESCRIBIR EL MISMO GIVEN EN AMBOS ESCENARIOS"
Background: Navigate to Table web app.
  Given I navigate to the static table

"Regla por la que los escenarios entran dentro de las HU/Business"
Rule: The user can return values from the table and validate them.

"@Test, es un tag, para agrupar los tests por etiquetas"

Scenario: As a Test Engineer, I want to retrieve the value of an static table
  "Given I navigate to the static table"
  Then I can return the value I wanted


Scenario: As a Test Engineer, I want to validate that a text is present inside the list
  "Given I navigate to the static page"
  Then I can validate the table is displayed