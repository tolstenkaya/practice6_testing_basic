package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {
    @Test
    void loginAPI_shouldReturn200(){
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("x-api-key","reqres-free-v1")
                .body("{\"email\":\"eve.holt@reqres.in\", \"password\":\"cityslicka\"}")
                .post("https://reqres.in/api/login");

        System.out.println("Status: " + response.statusCode());
        System.out.println("Response: " + response.asString());

        assertEquals(200, response.statusCode());
    }

    @Test
    void loginAPI_wrongLogin(){
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("x-api-key","reqres-free-v1")
                .body("{\"email\":\"qwe@qwe.ua\", \"password\":\"password\"}")
                .post("https://reqres.in/api/login");

        response.then().statusCode(400).body("error", equalTo("user not found"));
    }

}
