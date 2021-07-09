Spring Boot - Employee Management
===============================

Ứng dụng SpringBoot RESTfull API

Technology stack:

* Spring Boot
* Spring MVC
* Spring Data JPA
* JPA
* Hibernate 5.2
* OpenAPI
* Bootstrap
* Thymeleaf

## Requirements

* JDK 11
* Apache Maven

## Get the source codes

Get a copy of the source codes into your local system.

```
git clone https://github.com/truongvantuan/springboot-assignment-techmaster/tree/main/assignment_03/employeemanager
```

## Run the project

You can use one of the following approaches to run this project.

### Run frontend UI and backend respectively

1. Chạy ứng dụng backend restfull api.

   ```
   ./mvnw spring-boot:run
   ```

   Ứng dụng chạy tại [http://localhost:8080](http://localhost:8080/)

2. Chạy employee client.

   ```
   cd employee-client
   ./mvnw spring-boot:run
   ```
   Ứng dụng chạy tại [http://localhost:8080/employees](http://localhost:8080/employees)
