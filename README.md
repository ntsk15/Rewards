# Rewards Application


## Problem Statement

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase as follows:

For every dollar spent over $50 on the transaction, the customer receives one point.

In addition, for every dollar spent over $100, the customer receives another point.

Ex: for a $120 purchase, the customer receives

`(120 - 50) x 1 + (120 - 100) x 1 = 90 points`


Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and the total. 




## Introduction

- Java JDK-1.8 
- Spring Boot Embedded Tomcat Start local server
- Spring Data JPA
- H2 DB


# Steps for Running the Application :

1) Import the code as a Maven project
2) Maven Build - mvn clean install
3) Start local server: mvn run or Right-click on RewardsApplication.java and run as SpringBoot application.
5) Once the spring-boot application is started. See the port number from the console.

## Available endpoints

1. GET http://localhost:8080/rewards/customers/2
Rewards by input customer id<br>

2. JSON response as below
{"firstPoints":60.0,"secondPoints":66.0,"thirdPoints":0.0,"totalPoints":126.0,"customerId":2}

3. Invalid - http://localhost:8080/rewards/customers/10
No Transaction found for given id

## Additional Info about the Application :

1)If there is more than one transaction in a month all the points of that month will be added and displayed in that particular month's response. 

2)If a requested customerId is not available in the data set, then it will return "No Transaction found for given id"
  
## Commands:

To run:

    mvn spring-boot: run

To compile, test:

    mvn clean install
