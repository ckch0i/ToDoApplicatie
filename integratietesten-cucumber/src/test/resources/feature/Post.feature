Feature: ToDo

Scenario: test-post
  Given ik een Todo met omschrijving "vuilnis ophalen" verstuur
  When ik een response terug krijg, sla ik deze op
  Then verrifieer ik dat de waarde gelijk is aan de omschrijving
