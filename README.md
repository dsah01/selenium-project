# selenium-project
selenium project to test login functionality

Website is created according to project document and is hosted on github https://dsah01.github.io/

This project is created in TestNG framework using Selenium Webdriver
Maven is used as build automation tool.

Following scenarios are covered
1) If you enter correct email address and password, show message 'You have logged in successfully'
2) If you enter wrong email address, Show message ‘Wrong email address’
3) If you enter wrong password, Show message ‘Email address and password doesn’t match’
4) If you enter wrong password three times, Show message ‘Email address and password doesn’t match. You only have one more chance. Please contact RightEye Support at 800-301-0803.’
5) If you enter wrong password four times, Show message ‘Your Email address is locked and invalid. Please contact RightEye Support at 800-301-0803.’
6) Need Help link takes to FAQs page

Note : Configure path of geckodriver to run locally
