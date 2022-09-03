package stepDefinitions.db_StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.*;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.DatabaseUtility.getColumnData;

public class US_009_Step {
String query="select * from patient";
String fileName1="src/test/resources/testData/PatientId.txt";


    @Given("Kullanici database ile baglanti kurar")
    public void kullanici_database_ile_baglanti_kurar() {
        DatabaseUtility.createConnection();//Database ile bağlantı kuruldu
    }
    @Given("Kullanici query tanimlar")
    public void kullanici_query_tanimlar() {
        System.out.println(DatabaseUtility.getColumnNames(query)+"\n");//query tanımlandı

    }
    @Given("Kullanici database'den tum hasta bilgilerine ulasır ve kaydeder")
    public void kullanici_database_den_tum_hasta_bilgilerine_ulasır_ve_kaydeder() {
        System.out.println("===============ID LIST===============");
        List<Object> idList = getColumnData(query,"id");  //Hasta bilgilerine ulasılıp kaydedildi
        System.out.println(idList+"\n");
        WriteToTxt.savePatientId(fileName1,idList);

    }
    @Given("Kullanıcının DB'den gelen tüm hasta bilgilerini doğrulamalıdır.")
    public void kullanıcının_db_den_gelen_tüm_hasta_bilgilerini_doğrulamalıdır() {
        List<Object> actualPatientIds= ReadTxt.returnPatientId(fileName1);
        List<Object> expectedPatientIds= new ArrayList<>();
        expectedPatientIds.add(154140);
        Assert.assertTrue("ID UYUSMUYOR",actualPatientIds.containsAll(expectedPatientIds));


    }




}
