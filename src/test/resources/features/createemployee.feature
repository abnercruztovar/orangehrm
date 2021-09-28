#Author: abnercruztovar@gmail.com
Feature: Create a Employee in OrangeHRM

	Scenario Outline: Create a Employee in OrangeHRM
    Given The user is on the Orange HRM/PIM page
    When User adds information about new employee <firstName> <middleName> <lastName> <id>
    Then The user verifies that user Personal Details is displayed
    
    Examples:
    	|firstName	|middleName	|lastName	|id |
    	|"Abner"	|""	|"Cruz"	|"999555111" |
    	|"Carolina"	|""	|"Amaya"	|"666777555" |