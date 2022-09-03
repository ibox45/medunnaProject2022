package stepDefinitions.db_StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DatabaseUtility;
import utilities.WriteToTxt;
import java.util.ArrayList;
import java.util.List;

public class US_028_Steps {
    List<Object> countryList;
    String query="select * from country ";
    String fileName1="src/test/resources/testData/CountryIds.txt";
    @Given("Admin database ile baglanti saglar")
    public void adminDatabaseIleBaglantiSaglar() {
        DatabaseUtility.createConnection();
    }

    @Given("Admin database'den tum country bilgilerine ulasır ve kaydeder")
    public void admin_database_den_tum_country_bilgilerine_ulasır_ve_kaydeder() {
        System.out.println("===============ID LIST===============");
        countryList=DatabaseUtility.getColumnData(query,"id"); //sorgulatarak getirmek istediğimiz id leri bir liste attık
        for (int i = 0; i < countryList.size(); i++) { //for döngüsü ile listemizdeki elemanları tek tek alta alta yazdırdık
            System.out.println(countryList.get(i) +"\n");
        }

        WriteToTxt.saveCountryIds(fileName1,countryList); //txt dosyamızda da countryleri listelettirdik
    }


    @And("Admin DB'den gelen tum country bilgilerini dogrulamalidir")
    public void adminDBDenGelenTumCountryBilgileriniDogrulamalidir() {
        List<Object> expectedCountrytId= new ArrayList<>(); //beklenen datamızı list ile olusturduk
        expectedCountrytId.add(224247); //doğrulamak istediğimiz datamızı liste ekledik
       /* boolean flag=false;
        for (int i = 0; i < countryList.size() ; i++) {
          if (countryList.get(i).toString().equals(expectedCountrytId.get(0).toString())){
              flag=true;
          }
        }
        Assert.assertTrue(flag);
        */
        Assert.assertTrue(countryList.toString().contains(expectedCountrytId.get(0).toString()));//ass
    }


}
