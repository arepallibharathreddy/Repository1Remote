Feature: I am Automating OrangeHRM Website

Background: Common Steps

Given User Launches Chrome Browser
Then User Enters URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario: TC01_Nationality -I am creating a Nationality Record

And User enters a Credentials 
      |Admin|admin123|
      
Then user clicks a admin button 
Then user clicks a Nationality button
Then it Goes to nationality page
Then user enters nationality records
      |Indian234|
      |Indian123|
      |Indian345|