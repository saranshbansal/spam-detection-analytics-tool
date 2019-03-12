# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for a simple Note-Taking application using Spring Boot, Mysql, JPA and Hibernate.


![alt text](https://github.com/saranshbansal/spam-detection-analytics-tool/blob/master/img.png?raw=true)

## Requirements

1. Java - 1.8.x

2. Spring Boot - 2.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/saranshbansal/spam-detection-analytics-tool.git
```

**2. Create Mysql database**
```bash
create database testdb
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/spam-detector-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following APIs.

    GET /api/read-csv
    
    GET /api/estimate?key=
    

You can test them using postman or any other rest client.
