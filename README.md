# Rewards Application

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.   
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction


# Steps for Running the Application :

1)Right click on RewardsApplication.java and run as SpringBoot application. 
2)Once the springBoot application is started. See the port number from the console.

## Available endpoints

1. GET http://localhost:8080/rewards/customers/2
Rewards by input customer id<br>

2. JSON response as below
{"firstPoints":60.0,"secondPoints":66.0,"thirdPoints":0.0,"totalPoints":126.0,"customerId":2}

3. Invalid - http://localhost:8080/rewards/customers/10
No Transaction found for given id

## Additional Info about the Application :

1)If there are more than one transaction in a month all the points of that month will be added and displayed in that particular months response. 

2)If a requested customerId is not available in the data set. than it will return "No Transaction found for given id"
  
## Commands:

To run:

    mvn spring-boot:run

To compile, test:

    mvn clean install
