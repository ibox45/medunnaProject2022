package stepDefinitions.api_StepDefinitions;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import pojos.Patient;
import utilities.Authentication;
import utilities.ConfigurationReader;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;


public class US_009_Step {

    Response response;
    Patient patient;
    public static RequestSpecification spec;

    @Given("Kullanici Medunna patient API endpointini {string} ile olusturur")
    public void kullanici_medunna_patient_api_endpointini_ile_olusturur(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("medunnaUrl")).build();
        spec.pathParams("first", "api", "second", "patient", "third", id);


    }

    @Given("Kullanici patient icin get request gonderir ve response alir")
    public void kullanici_patient_icin_get_request_gonderir_ve_response_alir() {
       String andpoint="https://medunna.com/api/patients/154140";
        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type",ContentType.JSON,
                "Accept",ContentType.JSON)
                .when()
                .get(andpoint);
        response.prettyPrint();
    }

    @Then("Kullanici statuscode {int} oldugunu dogrular")
    public void kullanici_statuscode_oldugunu_dogrular(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("Kullanici gelen Json patient datalarini javaya donusturur")
    public void kullanici_gelen_json_patient_datalarini_javaya_donusturur() throws IOException {
        ObjectMapper obj=new ObjectMapper();
        patient=obj.readValue(response.asString(),Patient.class);
    }

    @Then("Kullanici API ile gelen bilgileri {string} dogrular")
    public void kullanici_api_ile_gelen_bilgileri_dogrular(String string) {
        Assert.assertEquals(154140, patient.getId());

    }
}