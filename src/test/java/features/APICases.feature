 @api
Feature: Title of your feature
  

Scenario: To generate token
 Given I set the base url for token
 When I set the headers for request as Content-Type as application/json
 And I add the request body to request
 And I execute the post request for GenerateToken
 Then I verify the status code as 200
 And I verify the token generated
  

  ###############################Books API
  
  Scenario: get all the books
 Given I set the base url for books
 When I set the headers for request as Content-Type as application/json
 And I execute the get request for BookStore/v1/Books
 Then I verify the status code as 200
 And I print the all the books
 And I print all the headers
 
 ###############################reqres Api###########################
 Scenario: create user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 When I set the headers for request as Content-Type as ContentType.JSON
 And I add the createUser.json file to request body
 And I execute the post request for api/users
 Then I verify the status code as 201
 And I get id from the response generated 
 
 Scenario: update user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 When I set the headers for request as Content-Type as ContentType.JSON
 And I add the updateUser.json file to request body
 And I execute the update put request having userId for api/users/ 
 Then I verify the status code as 200
 And I get updatedAt from the response generated 
 And I get job from the response generated

 
 Scenario: update user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 When I set the headers for request as Content-Type as ContentType.JSON
 And I add the updateUserJob.json file to request body
 And I execute the update patch request having userId for api/users/ 
 Then I verify the status code as 200
 And I get updatedAt from the response generated 
 And I get job from the response generated
 
 Scenario: delete user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 When I set the headers for request as Content-Type as ContentType.JSON
 And I execute the update delete request having userId for api/users/ 
 Then I verify the status code as 204
 
 Scenario: get delete user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 When I set the headers for request as Content-Type as ContentType.JSON
 And I execute the update get request having userId for api/users/ 
 Then I verify the status code as 404
 
 Scenario: get list of user
 Given I set the base url for reqres
 When I set the headers for request as Content-Type as application/json
 And I add the query parameter as page 2
 And I execute the get request for api/users
 Then I verify the status code as 200
 And I get per_page from the response generated
 And I get total from the response generated
 And I print all the details from the response of all users