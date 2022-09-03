package runners.basicRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports_DB.html",
                "json:target/json-reports/cucumber_DB.json",
                "junit:target/xml-report/cucumber_DB.xml"},
        //plugin satiri rapor olusturmak icin eklenmistir hepsi ayri ayri rapor ciktisi verir
        features = "src/test/resources/features",  //java olmayan dosyalarimiz
        glue = "stepDefinitions",    //java olan dosyalarimiz
        tags = "",
        dryRun = false
)
public class DB_Runner {
}
