package stepDefinitions.db_StepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DatabaseUtility;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.getColumnData;

public class US_019_Steps {

    String query="select * from staff";
    String StaffLoc="src/test/resources/testData/StaffID.txt";



    @Given("Admin database ile baglanti kurar")
    public void admin_database_ile_baglanti_kurar() throws SQLException {

        DatabaseUtility.createConnection();
    }
    @Given("Admin query tanimlar")
    public void admin_query_tanimlar() throws SQLException {

        System.out.println(DatabaseUtility.getColumnNames(query)+"\n");

    }
    @Given("Admin staff ulasir ve kaydeder")
    public void admin_staff_ulasir_ve_kaydeder() {
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*= ID LIST =*=*=*=*=*=*=*=*=*=*=*=*=*=");
        List<Object> idList = getColumnData(query,"id");
        System.out.println(idList+"\n");
        WriteToTxt.saveStafftId(StaffLoc,idList);


    }
    @Given("Admin DB ile staff bilgilerini dogrular")
    public void admin_dba_ile_staff_bilgilerini_dogrular() {
        List<Object> actualStaffIdes= ReadTxt.returnStaffId(StaffLoc);
        List<Object> expectedStaffIdes= new ArrayList<>();
        expectedStaffIdes.add(212093);
        Assert.assertTrue(" ID uyusmuyor ",actualStaffIdes.containsAll(expectedStaffIdes));

    }
}
