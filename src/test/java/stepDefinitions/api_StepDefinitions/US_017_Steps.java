package stepDefinitions.api_StepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.TestItemId;
import pojos.TestItemPost;
import utilities.Authentication;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class US_017_Steps {


    /*ihtiyacımız olan şeyler
    1. endpoint (ConfigurationReader.getProperty("getTestItemEndPoint"))
    2. Response ihtiyacim var class seviyesinde ihtiyacımız var()
    3. Datamız()*/
    Response response;
    TestItemPost testItemPost = new TestItemPost();
    TestItemId[] testItemId;// dataların hepsini içine koymak için bir (birden fazla array )
    TestItemId testItemIdd;// tek obje için


    @Given("kullanici testItem icin get request yapar")
    public void kullaniciTestItemIcinGetRequestYapar() {
        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .get(ConfigurationReader.getProperty("getTestItemEndPoint"));
        /*datalar response'in içinde JSON formatında*/
        // response.prettyPrint();
        /*
        json formatında ve birden fazla olduğu için array içerisinde
        [{
        "createdBy": "ogunes",
        "createdDate": "2022-07-21T14:00:10.086367Z",
        "id": 132000,
        "name": "cccs",
        "description": "ok",
        "price": 20.00,
        "defaultValMin": "15",
        "defaultValMax": "45"
    },
    {
        "createdBy": "admin",
        "createdDate": "2021-12-04T22:24:09.835288Z",
        "id": 1402,
        "name": "Urea",
        "description": "",
        "price": 12.00,
        "defaultValMin": "17",
        "defaultValMax": "49"
    },
    {
        "createdBy": "team_88_admin",
        "createdDate": "2022-07-21T17:48:49.157569Z",
        "id": 132770,
        "name": "gsh",
        "description": "Thyroid Hormone",
        "price": 50.00,
        "defaultValMin": "13",
        "defaultValMax": "26"
    }] bu bir array*/
    }

    @And("kullanici gelen json test item datalari javaya donustur")
    public void kullaniciGelenJsonTestItemDatalariJavayaDonustur() throws IOException {
        /*JSON formatında olanları Java formatına çevireceğiz*/
        ObjectMapper obj = new ObjectMapper();
        testItemId = obj.readValue(response.asString(), TestItemId[].class);
        /*elimde kaçtane testItem Objesi var*/
        System.out.println("kaç testItemObjesi var : " + testItemId.length);
        //   System.out.println(testItemId[904].getName());
        //   for (int i = 0; i < testItemId.length; i++) {
        //       System.out.println(testItemId[i].getDescription());
        //       System.out.println(testItemId[i].getPrice());
        //       System.out.println(testItemId[i].getId());
        //   }
//

    }

    @And("kullanici  testItem datasini dogrular")
    public void kullaniciTestItemDatasiniDogrular() {
        response.then().assertThat().statusCode(200);
      //1 validation
        TestItemId[] testItemIdActual = response.as(TestItemId[].class);

        for (int i = 0; i < testItemId.length; i++) {
           // System.out.println(testItemId[i].getName());
           // System.out.println(  testItemIdActual[i].getName());

            assertEquals(testItemId[i].getName(), testItemIdActual[i].getName());
            if (testItemIdActual[i].getName().contains("Grazyna test")) {
                System.out.println("test pass");
            }
        }

    }


    @Given("kullanici testItem icin post request yapar")
    public void kullaniciTestItemIcinPostRequestYapar() {

        //Set The Expected data / istenilen datayi ekle (POST yapılacak data)
        /* Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "post01");
        expectedData.put("description", "team57");
        expectedData.put("price", 120.00);
        expectedData.put("defaultValMin", "40");
        expectedData.put("defaultValMax", "100");
        boyle yaparsak body(expectedData) koymalıyız*/

        testItemPost.setName("altiliVa");
        testItemPost.setDescription("Team57");
        testItemPost.setPrice(200.0F);
        testItemPost.setDefaultValMin("200");
        testItemPost.setDefaultValMax("1000");

        response = given().headers("Authorization", "Bearer " + Authentication.generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).when().contentType(ContentType.JSON).body(testItemPost).post(ConfigurationReader.getProperty("postTestItemEndPoint"));
        response.prettyPrint();


    }


    @And("kullanici post request validation yaparr")
    public void kullaniciPostRequestValidationYaparr() throws IOException {
        //1 inci validation (body)
        response.then().assertThat().statusCode(201);
        response.then().assertThat().
                body("name", equalTo("altiliVa")).
                body("description", equalTo("Team57")).
                body("price", equalTo(200.0F)).
                body("defaultValMin", equalTo("200")).
                body("defaultValMax", equalTo("1000"));
        // 2 nci validation JSON PATH

        JsonPath jsonPath = response.jsonPath();
        assertEquals(testItemPost.getName(), jsonPath.getString("name"));

        // 3'üncü validation MAOP
        Map<String, Object> actualMapData = response.as(HashMap.class);
        assertEquals(testItemPost.getDescription(), actualMapData.get("description"));

        // 4'uncu validation POJO
        TestItemPost testItemPostActual1 = response.as(TestItemPost.class);
        assertEquals(testItemPost.getPrice(), testItemPostActual1.getPrice(),0.00001);

        // 5'nci validation OBJECTMAPPER
        ObjectMapper obj = new ObjectMapper();
        TestItemPost testItemPostActual2 = obj.readValue(response.asString(), TestItemPost.class);
        assertEquals(testItemPost.getDefaultValMin(), testItemPostActual2.getDefaultValMin());

        //6'ncı validation GSON
        Gson gson = new Gson();

        TestItemPost testItemPostActual3 = gson.fromJson(response.asString(), TestItemPost.class);
        //exception vermez kendi içince handle ediyor
        assertEquals(testItemPost.getDefaultValMax(), testItemPostActual3.getDefaultValMax());

    }
}
