# ProductMicroserviceApplication
Product Microservices Application including Product, Price, Inventory & Currency Exchange.
A very basic microservices architecture project for understanding.

	- User SignUp and SignIn and SSO pluggable application.
	- Tech Stack
		- Java 8
		- Maven
		- Spring Boot
		
	- Functionalities
		- Fetch product details from product Id.
		- Fetch price details from product Id.
		- Fetch inventory details from product Id.
		- Fetch currency exchange.
		- Added ControllerAdvice class to be invoked on to a certain custom exception, which returns the exception message as a response to a request.
		- Added a simple test case to validate.
		- Created an application.yml, with three different docs in a single file separated by "---".
		- Also created multiple spring profiles.
		- Create jar using the "mvn clean install" command which cleans the directory & installs the jar package in the target folder.
		
		
## Sping Configuration

	- Spring cloud
		- To host multiple services.
	
	- Spring Actuator
		- To see basic features pre implemented by Spring.
	
	- Libraries Added:
		- lombok.jar 
			= To the dependencies to create getters, setters, constructors at compile time.
