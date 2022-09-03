package stepDefinitions.api_StepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.Staff;
import utilities.Authentication;
import utilities.ConfigurationReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class US_019_Steps {


    Response response;
    Staff staff;
    public static RequestSpecification spec;


    @Given("admin medunna {string} endpointini olusturur")
    public void adminMedunnaEndpointiniOlusturur(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("medunnaUrl")).build();
        spec.pathParams("first", "api", "second", "staff","third",id);

    }
    @And("admin {string} bilgileri  icin Get request gonderir ve response alir")
    public void adminBilgileriIcinGetRequestGonderirVeResponseAlir(String id) {
        String endpoint="https://medunna.com/api/staff/"+id;
        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept",ContentType.JSON).when().get(endpoint);
        response.prettyPrint();
    }
    @Given("admin Status Code {int} oldugunu dogrular")
    public void admin_status_code_oldugunu_dogrular(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

    }


    @And("admin gelen json staff bilgilerini javaya donusturur")
    public void adminGelenJsonStaffBilgileriniJavayaDonusturur() throws IOException {
        ObjectMapper object=new ObjectMapper();
        staff=object.readValue(response.asString(),Staff.class);
        
    }

    @And("admin API ile gelen bilgilerin {string} olduğunu goruntuler")
    public void adminAPIIleGelenBilgilerinOlduğunuGoruntuler(String id) {
        Assert.assertEquals(Integer.parseInt(id),staff.getId());
    }



}
