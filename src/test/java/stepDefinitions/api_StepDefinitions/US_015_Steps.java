package stepDefinitions.api_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Patient;
import pojos.PatientPojos.*;
import utilities.Authentication;
import utilities.ConfigurationReader;
import utilities.ReadTxt;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_015_Steps {

    static int itemId;

    Response response;

    // -----------------GET------------------
    @Given("URL'e Get Request gonder ve Response al")
    public void url_e_get_request_gonder_ve_response_al() {


        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("patientEndPoint") + "/" + ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"),1))
                .then().extract().response();


    }

    @Then("Status Code'un {int} oldugunu dogrula")
    public void status_code_un_oldugunu_dogrula(Integer statusCode) {
        response.then().assertThat().statusCode(200);
    }

    @Then("Response De-seralize et ve patient bilgilerini dogrula")
    public void response_de_seralize_et_ve_patient_bilgilerini_dogrula() {
        Patient actualPojo;
        Patient expectedPojo = new Patient();

        expectedPojo.setId(ReadTxt.readLastLinePatientInfoListInteger(ConfigurationReader.getProperty("patientInfo"),1));
        expectedPojo.setPhone(ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"), 2));
        expectedPojo.setEmail(ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"), 3));
        expectedPojo.setLastName(ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"), 4));
        expectedPojo.setFirstName(ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"), 5));


        actualPojo = response.as(Patient.class);

        assertEquals("first name dogrulamasi basarili", expectedPojo.getFirstName(), actualPojo.getFirstName());
        assertEquals("last name dogrulamasi basarili", expectedPojo.getLastName(), actualPojo.getLastName());
        assertEquals("email dogrulamasi basarili", expectedPojo.getEmail(), actualPojo.getEmail());
        assertEquals("phone dogrulamasi basarili", expectedPojo.getPhone(), actualPojo.getPhone());
        assertEquals("id dogrulamasi basarili", expectedPojo.getId(), actualPojo.getId());
    }



    // -----------------DELETE------------------

    @Given("URL'e Delete Request gonder, Response al ve dogrula")
    public void urlEDeleteRequestGonderResponseAlVeDogrula() {
        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .delete(ConfigurationReader.getProperty("patientEndPoint") + "/" + ReadTxt.readLastLinePatientInfoList(ConfigurationReader.getProperty("patientInfo"),1))
                .then().extract().response();


        // do assertion
        String actual = response.asString();

        response.then().assertThat().statusCode(204);

        assertTrue(actual.isEmpty());
    }


    // -----------------POST------------------


    @Given("URL'e Post Request gonder, Response al ve dogrula")
    public void urlEPostRequestGonderResponseAlVeDogrula() {
        PatientPojosCountry pojosCountry = new PatientPojosCountry(80065,"USA");
        PatientPojosCstate pojosCstate = new PatientPojosCstate(43522,"California");
        PatientPojosCountry2 pojosCountry2 = new PatientPojosCountry2(80065,"USA");
        PatientPojoUser pojoUser = new PatientPojoUser("vusalgasimov","2022-08-30T12:42:11.281952Z",116120,"yamangokhnan","Zemily","Shan","c@gmail.com",true,"eng",null,"2022-07-12T13:22:05.091170Z","668-83-4231");
        Faker faker = new Faker();
        PatientPojoFull pojoFull = new PatientPojoFull("admin_57team","2022-08-30T12:42:11.281952Z",faker.name().firstName(),faker.name().lastName(),"2022-12-08T21:00:00Z",faker.instance().number().digits(10),"FEMALE","ABpositive","",faker.internet().emailAddress(),"",pojoUser,null,null,pojosCountry,pojosCstate);



        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body(pojoFull)
                .when()
                .post(ConfigurationReader.getProperty("patientEndPoint")).then().extract().response();


        Patient actual = response.as(Patient.class);

        assertEquals(201,response.getStatusCode());

        assertEquals(pojoFull.getCreatedBy(),actual.getCreatedBy());
        assertEquals(pojoFull.getCreatedDate(),actual.getCreatedDate());
        assertEquals(pojoFull.getFirstName(),actual.getFirstName());
        assertEquals(pojoFull.getLastName(),actual.getLastName());
        assertEquals(pojoFull.getBirthDate(),actual.getBirthDate());
        assertEquals(pojoFull.getPhone(),actual.getPhone());
        assertEquals(pojoFull.getGender(),actual.getGender());
        assertEquals(pojoFull.getBloodGroup(),actual.getBloodGroup());
        assertEquals(pojoFull.getAdress(),actual.getAdress());
        assertEquals(pojoFull.getUser(),actual.getUser());

        JsonPath json = response.jsonPath();
        itemId=json.get("id");
    }


    // -----------------PUT------------------
    @Given("URL'e Put Request gonder, Response al ve dogrula")
    public void urlEPutRequestGonderResponseAlVeDogrula() {

        Faker faker = new Faker();
        PatientPutPojo requestBody = new PatientPutPojo("admin_57team","2022-08-30T12:45:13.552877Z",itemId,faker.name().firstName(),faker.name().lastName(),"2022-12-08T21:00:00Z",faker.instance().number().digits(10),"OTHER","ABpositive","",faker.internet().emailAddress(),"");


        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body(requestBody)
                .when()
                .put(ConfigurationReader.getProperty("patientEndPoint")).then().extract().response();


        Patient actualBody = response.as(Patient.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(requestBody.getCreatedBy(),actualBody.getCreatedBy());
        assertEquals(requestBody.getCreatedDate(),actualBody.getCreatedDate());
        assertEquals(requestBody.getFirstName(),actualBody.getFirstName());
        assertEquals(requestBody.getLastName(),actualBody.getLastName());
        assertEquals(requestBody.getBirthDate(),actualBody.getBirthDate());
        assertEquals(requestBody.getPhone(),actualBody.getPhone());
        assertEquals(requestBody.getGender(),actualBody.getGender());
        assertEquals(requestBody.getBloodGroup(),actualBody.getBloodGroup());
        assertEquals(requestBody.getAdress(),actualBody.getAdress());
        assertEquals(requestBody.getEmail(),actualBody.getEmail());
    }



}
