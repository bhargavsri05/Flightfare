Feature: The user can check for available flights

  Scenario Outline: The user can search for cheapest and quicket flight
    Given the user is on the flight search page
    When the user enters  <departure city>
    And the user enters  <destination city>
    And the user selects the travel date
    And clicks search
    Then the user is able to navigate to the seach result page
    And the user sorts for cheapest and quickest flight
    Then the user finds the sorted search

    Examples: 
      | departure city | destination city |
      | Hyderabad           | Chennai          |
