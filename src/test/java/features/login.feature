Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialise the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in


Examples:

|username           |password  |
|test@gmail.com     |123456    |
|testt@gmail.com    |1234      |