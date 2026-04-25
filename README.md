# Online Banking REST API

A Spring Boot REST API for simulating online banking operations such as customer management, account creation, money transfers, credit card operations, loan processing, authentication, and event-based messaging.

This project was modified and extended as a backend learning project focused on Java, Spring Boot, PostgreSQL, JWT authentication, testing, Docker, and Kafka.

## Features

- Customer registration and management
- Bank account creation and account activity tracking
- Money transfer simulation
- Credit card creation, payment, and spending operations
- Loan application and loan payment handling
- JWT-based authentication
- Role-based API security using Spring Security
- REST API documentation with Swagger
- PostgreSQL database integration
- H2 database support for testing
- Unit and integration testing with JUnit and Mockito
- Kafka producer-consumer messaging simulation
- Docker support for Kafka and Zookeeper

## Tech Stack

- Java 11
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- H2 Database
- Maven
- Lombok
- MapStruct
- Swagger / OpenAPI
- JWT
- Kafka
- Docker
- JUnit
- Mockito

## Project Structure

```text
src/main/java/com/rutarj/onlinebankingrestapi
│
├── app
│   ├── acc       # Account module
│   ├── crd       # Credit card module
│   ├── cus       # Customer module
│   ├── gen       # Generic/shared classes
│   ├── kafka     # Kafka producer/consumer logic
│   ├── loa       # Loan module
│   ├── log       # Logging module
│   └── sec       # Security and authentication
│
├── sql           # Sample SQL data files
└── resources     # Application configuration
