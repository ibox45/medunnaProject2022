package utilities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {

        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }


    public static String generateToken() {
        String username = "admin_57team";
        String password = "ortakKullan.2022";

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("rememberme", "true");

        String endPoint = "https://www.medunna.com/api/authenticate";

        Response response1 = given().contentType(ContentType.JSON).body(map).when().post(endPoint);

        JsonPath token = response1.jsonPath();

        return token.getString("id_token");
    }

   /* public static String generateToken1() {
        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("medunnaUrl")).build();
        spec.pathParams("first", "api", "second", "authenticate");

          Map<String,Object>expectedData=new HashMap<>();
          expectedData.put("username","Med-pro");
          expectedData.put("password","ortakKullan.2022");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(map).when().post("/{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();


         return jsonPath.getString("id_token");

    }
*/
   public static String generateTokenPatient() {
       String username = "patient_57team";
       String password = "ortakKullan.2022";

       Map <String, Object> map = new HashMap<>();
       map.put("username", username);
       map.put("password",password);
       map.put("rememberme","true");

       String endPoint = "https://www.medunna.com/api/authenticate";

       Response response1 = given().contentType(ContentType.JSON).body(map).when().post(endPoint);

       JsonPath token = response1.jsonPath();

       return token.getString("id_token");
   }

}