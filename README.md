#Application
Spring Boot project to perform operation on contact

#Modules used
-Spring Boot Rest controller
-H2 DB (in memory database)
-Swagger
-Logging
-Validations
-Unit Tests
-Actuator
-Spring Security (For Actuator only)

#How to run?
-This application has been hosted on pivotal.io
-API can be hit using swagger-ui using url "https://contact-info-app.cfapps.io/swagger-ui.html"
-Swagger is used here only to access the API.

#How to run on local system?
-checkout project from github "https://github.com/piyushanjikar/contact-information".
-import project to eclipse.
-if you are getting errors for setters and getters then install lombok.jar in eclipse.
-run application as java project.
-Hit below api's from postman or use swagger-ui.

#API
1. List Contact : only active contact will be listed
	Type : GET
	URL  : http://localhost:9090/contact/list
	Response :
		[
		  {
			"contactId": 0,
			"email": "string",
			"firstName": "string",
			"lastName": "string",
			"phoneNumber": "string",
			"status": "string"
		  }
		]
	
2. Add Contact :
	Type : POST
	URL  : http://localhost:9090/contact/add
	Body : 
		{
			"firstName":"John",
			"lastName":"Martin",
			"email":"john@testmail.com",
			"phoneNumber":"0123456789"
		}
	Response : 201 Created
		{
			"timestamp": "2020-05-18T01:49:43.423+0000",
			"code": 201,
			"status": "201 CREATED",
			"message": "Entity created successfully"
		}
		
3. Update Contact :
	Type : PUT
	URL  : http://localhost:9090/contact/update/3
	Body : 
		{
			"firstName":"John",
			"lastName":"Martin",
			"email":"john@testmail.com",
			"phoneNumber":"1112223334"
		}
	Response : 200 OK
		{
			"contactId": 3,
			"firstName": "John",
			"lastName": "Martin",
			"email": "john@testmail.com",
			"phoneNumber": "0123456789",
			"status": "Active"
		}
		
4. Delete/Inactive Contact :
	Type : DELETE
	URL  : http://localhost:9090/contact/delete/1
	Response : 200 OK
		{
			"timestamp": "2020-05-18T01:56:35.862+0000",
			"code": 200,
			"status": "200 OK",
			"message": "Entity deleted successfully"
		}

#Package Structure
-com.piyush.contact
				|_ config
				|_ constants
				|_ controller
				|_ entity
				|_ exception
				|_ model
				|_ repository
				|_ service
				
com.piyush.contact : Entry point of application
constant : Application Constants/enums
controller : Rest API
entity : Entities
exception : User defined exceptions and Controller Advices
model : DTO classes
repository : repository to perform DB operation
service : services to get data from repository and perform business logic

#H2 DB
-Here H2 DB (in memory database) is used.
-To access the db hit url "http://localhost:9090/h2-console" when application running on console.
-Use below details to connect to DB:
	Setting Name: Generic H2 (Embedded)
	Driver Class: org.h2.Driver
	JDBC URL    : jdbc:h2:mem:contact
	User Name   : admin
	Password    : admin
-The above details are configured in application.properties.
-Schema defination is declared in schema.sql.
-Initially couple of entries are inserted into DB which are declared in data.sql.

#Swagger:
-Swagger is configured here to access api from browser.
-Swagger API documentation part is not handled here hence default API details will be loaded by swagger based on Controllers.
-Swagger is configured in SwaggerConfig.java. 

#Logs:
-Logs are available in app.log file
-Logging configuration is available in application.properties.

#Validations
-While adding or updating contacts fields has been validated.
-This validation messages are define in messages.properties.
-Configuration to load this propety file is declared in MessageSourceConfig.java.

#Unit Tests :
Unit test cases are written in src/test/java.

#Actuator(Monitoring application):
-You can check application health , logs using actuator.
-Spring security has been provided to actuator.
-Use firefox for better view of actuator:
Url : https://contact-info-app.cfapps.io/actuator
username : admin
password : admin
