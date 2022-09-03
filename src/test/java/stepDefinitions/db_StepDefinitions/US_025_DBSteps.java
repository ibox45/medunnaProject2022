package stepDefinitions.db_StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;


public class US_025_DBSteps {

    @Given("Kullanici  db ye baglanir")
    public void kullanici_db_ye_baglanir() {
        DatabaseUtility.createConnection();

    }


    @Then("kullanici {string} table {string} satirindaki {string} dogrular")
    public void kullanici_table_satirindaki_dogrular(String table, String column, String data) {
        String query="select * from "+table;
     List<Object> satırdakiTumDatalar=DatabaseUtility.getColumnData(query,column);
       // System.out.println("sutundakiTumDatalar = " +  satırdakiTumDatalar);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);
        System.out.println("expectedData = " + expectedData);
        Assert.assertTrue(satırdakiTumDatalar.toString().contains(expectedData.get(0).toString()));
    }



}
