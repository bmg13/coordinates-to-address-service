Feature: COORDINATE-TO-ADDRESS-SERVICE

@CTAS
Scenario: Make a successful request to the API
Given The service call
And If the request is successful
Then The response should provide the map data