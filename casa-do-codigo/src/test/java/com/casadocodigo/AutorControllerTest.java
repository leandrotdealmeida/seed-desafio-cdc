package com.casadocodigo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AutorControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/autor")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}