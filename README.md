# CurrencyConversionApp
The currency conversion app aims to provide users with real-time and accurate currency conversion rates using Google's 
open APIs. It will support a wide range of currencies and offer a user-friendly interface.
## our technology stack:
- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) as the main languages for all backend services
- [Spring Boot V : 3.1.2](https://spring.io/projects/spring-boot/) framework to handle http requests in the backend
- [Redis](https://redis.io/) for Cashing data
- [Swagger](http://www.amrcurrencyconversion.site/swagger-ui/index.html) to design and document our apis
- [AWS](https://eu-north-1.console.aws.amazon.com/console/home?region=eu-north-1) for deploy our project
## architecture patterns
- Restfull api architecture
- Circuit Breaker architecture
- Retry architecture
- Rate limiter architecture
## API Reference
#### API DOC
```
    http://www.amrcurrencyconversion.site/swagger-ui/index.html
```
#### Actuator Endpoint
```
    http://amrcurrencyconversion.site/actuator/health
```
#### Get all currencies
```
    http://www.amrcurrencyconversion.site/api/v1
    GET /api/v1
```
#### Convert between different currencies
```
    GET /api/v1/conversion?from={BacsCode}&to={ConvertedCode}&amount={amount}
```
| Parameter  | Type     | Description                                      |
|:-----------|:---------|:-------------------------------------------------|
| `BaseCode` | `string` | **Required**. Code of Currency to fetch          |
| `ConvertedCode` | `string` | **Required**. ConvertedCode of Currency to fetch |
| `amount` | `double` | **NotRequired**. amount went to convert             |
#### Currency Comparison
```
    GET /api/v1/comparison?amount={amount}&from={BaseCode}&list={[listOfCodes]}
```
| Parameter  | Type           | Description                                            |
|:-----------|:---------------|:-------------------------------------------------------|
| `BaseCode` | `string`       | **Required**. Code of Currency to fetch                |
| `listOfCodes` | `List<String>` | **Required**. List of comparing of Currencies to fetch |
| `amount` | `double`       | **NotRequired**. amount went to convert                |
## sequence diagram
![Convert sequence](https://drive.google.com/file/d/1xA0tTqn97rN0339U_JCd4d_M02cxYRXt/view)
![compare sequence](https://drive.google.com/file/d/1HMAhSNYSphf2Pi414-a5tlPAtuFCvtkU/view?usp=sharing)


## Spring boot Dependency
#### Spring Web Dependency  
``` 
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
#### Spring boot starter validation
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
```
#### Spring boot starter test
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
#### Spring cloud starter openfeign
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>4.0.4</version>
        </dependency>
```
#### Spring boot starter data redis
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
            <version>3.1.2</version>
        </dependency>
```
#### resilience4j-spring-boot3
```
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>2.0.2</version>
        </dependency>
```
#### spring-boot-starter-actuator
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
            <version>3.1.2</version>
        </dependency>
```