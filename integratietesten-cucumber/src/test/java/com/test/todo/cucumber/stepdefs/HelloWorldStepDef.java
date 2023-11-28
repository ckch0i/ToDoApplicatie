package com.test.todo.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class HelloWorldStepDef {

    private static final String BASE_URL = "http://localhost:8080/test";

    @Given("ik een bericht verstuur naar test dan verwacht ik het volgende terug: {string}")
    public void ikEenBerichtVerstuur(String verwachtteResultaat) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get();

        String jsonString = response.asString();

        Assertions.assertEquals(verwachtteResultaat, jsonString);
    }
    @And("status code zou moeten zijn: {int}")
        public void statusCodeZouMoetenZijn ( int arg0){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get();

        String jsonString = response.asString();

        Assertions.assertEquals(200, response.getStatusCode());
        }
}
