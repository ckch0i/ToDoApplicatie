Feature: ToDo

Scenario: happy-flow
  Given ik een bericht verstuur naar test dan verwacht ik het volgende terug: "hello-world"

Scenario: test-post
  Given ik een bericht verstuur naar test dan verwacht ik het volgende terug: "hello-world"
  And status code zou moeten zijn: 200
  Then genereerd er een unieke ID voor het verstuurde bericht met omschrijving: "vuilnis ophalen"

