#Author: abnercruztovar@gmail.com
Feature: Create a App User in OrangeHRM

	Scenario Outline: Create a Employee in OrangeHRM
    Given The admin is on the Orange HRM/User page
    When User adds information about new User <employeeName> <password> <role> <status> <username>
    Then The user verifies that user exist in the results
    
    Examples:
    	|employeeName	|password	|role	|status |username	|
    	|"Abner Cruz"	|"ac784.df45"	|"Admin"	|"Enabled" |"acruz"|
    	|"Carolina Amaya"	|"tyv54.tf37"	|"Admin"	|"Enabled" |"camaya"|