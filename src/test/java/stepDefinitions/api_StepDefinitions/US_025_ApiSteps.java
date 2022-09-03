package stepDefinitions.api_StepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Patient;
import pojos.User;
import utilities.Authentication;
import utilities.ConfigurationReader;


import static io.restassured.RestAssured.given;



public class US_025_ApiSteps {

    Patient hasta = new Patient();
    User hst = new User();
    Response response;

    @Given("kullanici medunna apiden {string} randevu bilgilerini dogrular")
    public void kullaniciMedunnaApidenRandevuBilgileriniDogrular(String url) {
        response= given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                get(ConfigurationReader.getProperty("hstappo")).
                then().
                extract().
                response();
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println(response.jsonPath().getString("id"));
        System.out.println(response.jsonPath().getString("createdBy"));

    }
}

