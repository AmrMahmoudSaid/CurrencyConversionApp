# CurrencyConversionApp
The currency conversion app aims to provide users with real-time and accurate currency conversion rates using Google's 
open APIs. It will support a wide range of currencies and offer a user-friendly interface.

## Prerequisites
    Java Development Kit (JDK) version : 17
    Spring version : 3.1.2
## Dependency
#### Spring Web Dependency  
``` 
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

#### Spring Boot Devtools
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
```
#### Spring boot starter validation
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
```
#### Lombok
```
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
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
#### Spring boot starter cache
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
            <version>3.1.2</version>
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
## API Reference
#### API DOC
```
    http://www.amrcurrencyconversion.site/swagger-ui/index.html
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
| `amount` | `double` | **Required**. amount went to convert             |
#### Currency Comparison
```
    GET /api/v1/comparison?amount={amount}&from={BaseCode}&list={[listOfCodes]}
```
| Parameter  | Type           | Description                                            |
|:-----------|:---------------|:-------------------------------------------------------|
| `BaseCode` | `string`       | **Required**. Code of Currency to fetch                |
| `listOfCodes` | `List<String>` | **Required**. List of comparing of Currencies to fetch |
| `amount` | `double`       | **Required**. amount went to convert                   |
