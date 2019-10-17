# ViewUserProfileFeature Feature
# language: en
@UserProfileScenario
Feature: UserHistoryProfileFeature
	As an user of Shop and buy
	I want to view other user profile
	I can view list of sales and order history

Background: User navigates to Shop and Buy user profile page
	Given I am on the item page
	
	Scenario: Successfully view user profile "Chenkun"
	Then I should see Sales and Order history buttons
	
	Scenario Outline: Failed to view user profile "Chenkun"
	Then I should see request login page
