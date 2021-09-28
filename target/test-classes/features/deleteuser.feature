#Author: abnercruztovar@gmail.com
Feature: Delete a User From OrangeHRM

	Scenario Outline: Delete a User From OrangeHRM
    Given The user is on the Orange HRM/Admin page
    When User adds information about the user to delete <userName>
    Then The user confirms that the user were deleted
    
    Examples:
    	|userName	|
    	|"acruz"|
    	|"camaya"|