# TestContainers in action
Testing complex dockerized microservices system with Selenide e2e integration tests based on TestContainers Selenium
remote web-driver

Status: IN PROGRESS

```
                                 TestContainers
                         Spring    Remote Web                Micro Profile   Spring            PG
    +-----------+ Maven +------+     Driver     +----------+  REST client  +---------+ R2DBC +----+
    | CI runner | <---> | E2E  | <------------> | Frontend | <-----------> | Backend | <---> | DB |
    +-----------+       +------+    Selenide    +----------+     HTTP      +---------+       +----+
      Travis CI           Boot                     Quarkus                    Boot             H2
```

## resources
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Data R2DBC [Experimental]](https://docs.spring.io/spring-data/r2dbc/docs/1.0.x/reference/html/#reference)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [R2DBC example](https://github.com/spring-projects-experimental/spring-boot-r2dbc/tree/master/spring-boot-example-h2)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [R2DBC Homepage](https://r2dbc.io)
