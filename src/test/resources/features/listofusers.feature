#Author: abnercruztovar@gmail.com
Feature: Get User List from OrangeHRM

	Scenario Outline: Get a users list from OrangeHRM by Role
    Given The user is on the Search Users page Orange HRM
    When Read a Excel File with the information about Roles
    Then The user verifies that the list of users is wrote in excel file
    
    Examples:
    	|roleName	|
    	|"test"|
