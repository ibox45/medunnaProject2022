package stepDefinitions.db_StepDefinitions;

import io.cucumber.java.en.*;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.getColumnData;

public class US_017_DB_Steps {

    String queryTestItem = "select * from public.c_test_item";
    String testItemId = "src/test/resources/testData/TestItemId.txt";
    String testItemName = "src/test/resources/testData/TestItemName.txt";

    @Given("kullanici data base ile baglanti kurar")
    public void kullanici_data_base_ile_baglanti_kurar() {
        DatabaseUtility.createConnection();

    }

    @Then("kullanici query tanimlar")
    public void kullanici_query_tanimlar() {
        System.out.println(DatabaseUtility.getColumnNames(queryTestItem) + "\n");

    }

    @Then("kullanici tum test ıtem bilgilerine ulasir ve kaydeder")
    public void kullanici_tum_test_ıtem_bilgilerine_ulasir_ve_kaydeder() {
        System.out.println("-------------Test Item-------------");
        List<Object> testItemidList = getColumnData(queryTestItem, "id");
        List<Object> testItemNameList = getColumnData(queryTestItem, "name");

        System.out.println(testItemidList+"\n"+ testItemNameList+"\n");
        WriteToTxt.saveItemId(testItemId, testItemidList);
        WriteToTxt.saveItemName(testItemName, testItemNameList);

    }

    @Then("kullanici tum test ıtem bilgilerini dogrular")
    public void kullanici_tum_test_ıtem_bilgilerini_dogrular() {

        List<Object> actualTestItemIds = ReadTxt.returnTestItemId(testItemId);
        int expectedTestItemIds= 31217;

        assertTrue("ID Uyusmuyor", actualTestItemIds.contains(expectedTestItemIds));

       List<Object> actualTestItemNames = ReadTxt.returnTestItemName(testItemName);
       List<Object> expectedTestItemNames = new ArrayList<>();
       expectedTestItemNames.add("altiliValidation");
       assertTrue("Name Uyusmuyor", actualTestItemNames.containsAll(expectedTestItemNames));
    }
}
