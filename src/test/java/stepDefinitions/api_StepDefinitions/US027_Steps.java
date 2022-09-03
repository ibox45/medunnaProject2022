package stepDefinitions.api_StepDefinitions;

import base_url.MedunnaBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.C_MessageGetId;
import pojos.C_MessagePost;
import utilities.ConfigurationReader;


import java.io.IOException;

import static io.restassured.RestAssured.*;
import static utilities.Authentication.generateToken;

public class US027_Steps extends MedunnaBaseUrl {
    /*
    {
    "id": 263358,
    "name": "Ben",
    "email": "q@q.com",
    "subject": "Bu mesaji",
    "message": "Dogrulama yapmak icin kullanacagim"
}
     */
    static Faker faker = new Faker();
    static C_MessageGetId mGetId;
    static C_MessagePost mPost;
    static Response response;
    static ObjectMapper objectMapper = new ObjectMapper();

    @Given("Kullanici istedigi ileti icin GET method'unu kullanir")
    public void kullanici_istedigi_ileti_icin_get_method_unu_kullanir() {
        response = given().
                headers("Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                get(ConfigurationReader.getProperty("cMessageGetId"));

        response.prettyPrint();


    }

    @Then("Kullanici ileti bilgilerini dogrular")
    public void kullanici_ileti_bilgilerini_dogrular() throws IOException {


        mGetId = new C_MessageGetId("q@q.com", 263358, "Dogrulama yapmak icin kullanacagim", "Ben", "Bu mesaji");

        C_MessageGetId mGetIdEx = objectMapper.readValue(response.asString(), C_MessageGetId.class);

        Assert.assertEquals(mGetId.getEmail(), mGetIdEx.getEmail());
        Assert.assertEquals(mGetId.getName(), mGetIdEx.getName());
        Assert.assertEquals(mGetId.getId(), mGetIdEx.getId());
        Assert.assertEquals(mGetId.getMessage(), mGetIdEx.getMessage());
        Assert.assertEquals(mGetId.getSubject(), mGetIdEx.getSubject());
        response.then().assertThat().statusCode(200);

    }


    @When("Kullanici ileti olusturmak icin POST Method'unu kullanir")
    public void kullanici_ileti_olusturmak_icin_post_method_unu_kullanir() {

        mPost = new C_MessagePost(
                faker.internet().emailAddress(),
                faker.harryPotter().quote(),
                faker.harryPotter().character(),
                faker.book().author());


        response = given().
                headers("Authorization",
                        "Bearer" + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                contentType(ContentType.JSON).
                body(mPost).
                when().
                post(ConfigurationReader.getProperty("cMessagePostRequest"));
        response.prettyPrint();

    }

    @Then("Kullanici olusturdugu iletiyi dogrular")
    public void kullanici_olusturdugu_iletiyi_dogrular() throws IOException {

        C_MessagePost mPostEx = objectMapper.readValue(response.asString(), C_MessagePost.class);
        //  Assert.assertEquals(mPost.getEmail());
        Assert.assertEquals(201, response.getStatusCode());
        Assert.assertEquals(mPost.getName(), mPostEx.getName());
        Assert.assertEquals(mPost.getEmail(), mPostEx.getEmail());
        Assert.assertEquals(mPost.getSubject(), mPostEx.getSubject());
        Assert.assertEquals(mPost.getMessage(), mPostEx.getMessage());

    }


}
