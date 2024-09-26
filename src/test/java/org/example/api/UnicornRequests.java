package org.example.api;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn (String body) {
        return given()
                .body(body)
                .contentType(ContentType.JSON)
         .when()
                .post("/unicorn")
          .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract().path("_id");
    }

    public static void deleteUnicorn(String id) {
        given().delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static void updateUnicornTailColor(String id, String newTailColor) {
        given()
                .body("{\n" +
                        " \"tailColor\": \"" + newTailColor + "\"\n" +
                        "}")
                    .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
