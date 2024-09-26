package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnicornTest {
    @BeforeAll
    public static void setupTest() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/4ade6a443ec445739711807d0791f95e";
    }

    //Создание сущности
    @Test
    void userShouldBeAbleCreateUnicorn() {
        Unicorn unicorn = new Unicorn("Uni", "Pink");
        UnicornRequests.createUnicorn(unicorn.toJson());
    }

    //Удаление сущности
    @Test
    public void userShouldBeAbleDeleteUnicorn() {
// Создаем сущность
        Unicorn unicorn = new Unicorn("Uni", "Pink");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());
//Удаляем сущность
        UnicornRequests.deleteUnicorn(id);
//Проверяем удаление сущности
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

    //Изменение цвета хвоста сущности
    @Test
    public void userShouldBeAbleChangeTailColorUnicorn() {
// Создаем сущность
        Unicorn unicorn = new Unicorn("Uni", "Pink");
        String id = UnicornRequests.createUnicorn(unicorn.toJson());
//Изменение цвета хвоста сущности
        UnicornRequests.updateUnicornTailColor(id, "Violet");
//Проверяем цвет хвоста сущности
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tailColor", equalTo("Violet"));
    }
}
