# springboot Buy Used Cars Services

## Requirements

For building and running the application you need:

- [JDK 1.8](hhttps://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3.6.0](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.buycars.warehouse.BuyCarsApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```