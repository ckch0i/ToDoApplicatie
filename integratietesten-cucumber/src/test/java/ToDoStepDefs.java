import com.test.todo.cucumber.domain.ToDoResponse;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class ToDoStepDefs {
    private static final String BASE_URL = "http://localhost:8080/todo";
    @Given("ik een Todo met omschrijving {string} verstuur")
    public void ikEenTodoMetOmschrijvingVerstuur(String omschrijving) {

        RestAssured.baseURI = "http://localhost:8080/todo";
        RequestSpecification request2 = RestAssured.given().body("{\"omschrijving\" : \"vuilnis ophalen\"}").accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        Response response = request2.post();
        System.out.println("Response is: " + response.asPrettyString());

        //TODO:Unieke ID vasthouden in eigen string
        String UniekeID = response.path("uniekeId");

        //Nieuwe Get request met deze unieke ID
        Response ingevoerdeToDo = RestAssured.given().get(BASE_URL+ "?uniekeId=" + UniekeID);
        ToDoResponse toDoResponse = ingevoerdeToDo.then().extract().as(ToDoResponse.class);

        //Verify omschrijving met verwachte result
        Assertions.assertEquals(toDoResponse.getOmschrijving(), omschrijving);
        System.out.println("Assertion passed! " + toDoResponse.getOmschrijving() + " komt overeen met " + omschrijving);



    }

}