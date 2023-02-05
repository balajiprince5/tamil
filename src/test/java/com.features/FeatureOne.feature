Feature: amazon Feature One
  Scenario Outline: product Search
    Given user Launch Browser
    When select "<dropInput>" from Dropdown
    Then Send The Value "<searchInput>"
    And find The Exact Searchvalue In The Suggestion Click
    
    Examples:
    |dropInput|searchInput|
    |Baby|soft toys|
   