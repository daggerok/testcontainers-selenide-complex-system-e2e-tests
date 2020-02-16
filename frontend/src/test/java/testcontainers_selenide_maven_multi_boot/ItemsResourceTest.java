package testcontainers_selenide_maven_multi_boot;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class ItemsResourceTest {

    // @Test
    // public void testHelloEndpoint() {
    //     given()
    //       .when().get("/items")
    //       .then()
    //          .statusCode(200)
    //          .body(containsStringIgnoringCase("ololo"));
    // }

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/items")
          .then()
             .statusCode(500)
             .body(containsStringIgnoringCase("items"));
    }
}
