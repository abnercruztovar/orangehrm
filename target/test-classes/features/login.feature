#Author: abnercruztovar@gmail.com
Feature: Login in OrangeHRM

  Scenario Outline: Login to OrangeHRM
    Given The user is on the Orange HRM page
    When input user credentials <user> <pass>
    Then the user verifies that Dashboard Page is displayed
    
    Examples:
		| user          | pass          |
		| "Admin" |     "admin123" |
		| "admin" |     "admin123" |
		| "admin" |     "" |
		| "" |     "admin123" |
		| "admrin" |     "admin1r23" |
		| "" |     "" |