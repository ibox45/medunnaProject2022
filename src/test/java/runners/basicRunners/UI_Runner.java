package runners.basicRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml"},
        //plugin satiri rapor olusturmak icin eklenmistir hepsi ayri ayri rapor ciktisi verir
        features = "src/test/resources/features",  //java olmayan dosyalarimiz
        glue = "stepDefinitions",    //java olan dosyalarimiz
        tags = "",
        dryRun = false
)

public class UI_Runner {
}
