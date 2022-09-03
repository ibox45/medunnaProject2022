package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},
        //plugin satiri rapor olusturmak icin eklenmistir hepsi ayri ayri rapor ciktisi verir
        features = "src/test/resources/features",  //java olmayan dosyalarimiz
        glue = "stepDefinitions",    //java olan dosyalarimiz
        tags = "@US027_API",
        dryRun = false
)
public class Runner {
}
