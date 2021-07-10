#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Searches
Feature: Flight Searches
  I want to use this template for my feature file

  @secondflightsearch @searches
  Scenario Outline: CP0001 Second flight search
    Given the user in on the Avianca.com page <fila>
      | Ruta Excel                                      | Pestana |
      | src/test/resources/data/AviancaCom.xlsx         | Flights |
    When the user completes the form
    Then the user validates information processed correctly

    Examples: 
      | fila    |
      | 1       |
      | 2       |

