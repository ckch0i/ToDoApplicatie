package com.test.todo.cucumber.stepdefs;

import com.test.todo.cucumber.domain.ToDoResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class ToDoStepDefs {
    private static final String BASE_URL = "http://localhost:8080/todo";
    private String uniekeId;
    private String omschrijving;
    private ToDoResponse toDoResponse;

    @Given("ik een Todo met omschrijving {string} verstuur")
    public void ikEenTodoMetOmschrijvingVerstuur(String omschrijving) {
        this.omschrijving = omschrijving;
        RestAssured.baseURI = "http://localhost:8080/todo";
        RequestSpecification request = RestAssured.given()
                .body("{\"omschrijving\" : \"" + omschrijving + "\"}")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        Response response = request.post();

        // Unieke ID vasthouden in eigen string
        uniekeId = response.path("uniekeId");
    }

    @When("ik een response terug krijg, sla ik deze op")
    public void ik_een_response_terug_krijg_sla_ik_deze_op() {
        Response ingevoerdeToDo = RestAssured.given().get(BASE_URL + "?uniekeId=" + uniekeId);
        toDoResponse = ingevoerdeToDo.then().extract().as(ToDoResponse.class);
    }

    @Then("verrifieer ik dat de waarde gelijk is aan de omschrijving")
    public void verrifieer_ik_dat_de_waarde_gelijk_is_aan_de_omschrijving() {
        // Verify omschrijving met verwachte result
        Assertions.assertEquals(toDoResponse.getOmschrijving(), omschrijving);
        System.out.println("Assertion passed! " + toDoResponse.getOmschrijving() + " komt overeen met " + omschrijving);
    }
}