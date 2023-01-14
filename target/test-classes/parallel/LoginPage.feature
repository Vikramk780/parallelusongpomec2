Feature: login page Test

Scenario: get login page title
Given user is on login page
When user gets title
Then title should be "Botprise Staging"