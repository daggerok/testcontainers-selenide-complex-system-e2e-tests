package testcontainers_selenide_maven_multi_boot;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
@AllArgsConstructor(onConstructor_ = @Autowired)
class E2eApplicationTests {

    @Test
    void e2eTest() {
        // TODO: Add selenide + TestContainer + Spring Boot Test...
    }
}
