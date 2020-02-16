package testcontainers_selenide_maven_multi_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class E2eApplication {
    public static void main(String[] args) {
        SpringApplication.run(E2eApplication.class, args);
    }
}
