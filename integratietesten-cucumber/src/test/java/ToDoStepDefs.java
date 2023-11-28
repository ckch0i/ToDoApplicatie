import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ToDoStepDefs {
    private static final String BASE_URL = "http://localhost:8080/test";
    @Given("ik een Todo met omschrijving {string} verstuur")
    public void ikEenTodoMetOmschrijvingVerstuur(String omschrijving) {

        RestAssured.baseURI = "http://localhost:8080/test";
        RequestSpecification request2 = RestAssured.given();
        Response response = request2.post();
        System.out.println("Response is: " + response.asPrettyString());
    }

}