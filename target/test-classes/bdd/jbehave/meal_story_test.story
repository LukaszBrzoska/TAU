Scenario: Get meals by regexp
Given initialize meals list
When user wanna meals with burger in name
Then user get all meals with burger in name

Scenario: Get meals by price
Given initialize meals list
When user wanna meals with price 10
Then user get all meals with price 10

Scenario: Delete meal by regexp
Given add meals to list:
When user wanna delete meals with burger
Then user remove all meals contains burger