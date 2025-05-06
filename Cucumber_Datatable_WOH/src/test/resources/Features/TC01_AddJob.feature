Feature: I am Automating OrangeHRM Website

Background: Common Steps

Given User Launches Chrome Browser
Then User Enters URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario: TC02_AddJob - I am creating job record

And user enters the Credentials
     |Admin|admin123|
Then it goes to job page
Then user enters job records
     |Selenium11|Selenium12|Selenium13|
     |Selenium21|Selenium22|Selenium23|
     |Selenium31|Selenium32|Selenium33|
Then user clicks logout button 