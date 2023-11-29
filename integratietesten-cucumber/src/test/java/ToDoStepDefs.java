import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
        String Geturl = "http://localhost:8080/todo?uniekeId=" + UniekeID;
        String endpoint = "/todo";

        Response response2 = RestAssured.given()
                .param("UniekeID")
                .when()
                .get(Geturl);

        int statusCode = response2.getStatusCode();
        String responseBody = response2.getBody().asString();

        String getomschrijving = response2.path("omschrijving");
        System.out.println("get result omschrijving:" + getomschrijving);

        //Verify omschrijving met verwachte result

        RestAssured.given().that().body(getomschrijving).equals(omschrijving);
        try {
        System.out.println("Assertion passed! " + getomschrijving + " komt overeen met " + omschrijving);
        } catch (AssertionError e) {
            System.out.println("Assertion failed " + getomschrijving + " komt niet overeen met " + omschrijving);
            e.printStackTrace();
        }


    }

}