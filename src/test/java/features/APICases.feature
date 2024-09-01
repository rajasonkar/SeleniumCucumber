

 @api
Feature: Title of your feature
  

Scenario: To generate token
 Given I set the base url for token
 When I set the headers for request
 And I add the request body to request
 And I execute the post request for GenerateToken
 Then I verify the status code as 200
 And I verify the token generated
  
  #################################Books API
  
  Scenario: get all the books
 Given I set the base url for books
 When I set the headers for request
 And I execute the get request for BookStore/v1/Books
 Then I verify the status code as 200
 And I print the all the books
 And I print all the headers