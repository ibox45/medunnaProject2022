package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports3.html",
                "json:target/json-reports/cucumber3.json",
                "junit:target/xml-report/cucumber3.xml"},
        //plugin satiri rapor olusturmak icin eklenmistir hepsi ayri ayri rapor ciktisi verir
        features = "src/test/resources/features",  //java olmayan dosyalarimiz
        glue = "stepDefinitions",    //java olan dosyalarimiz
        tags = "@US007",
        dryRun = false
)

public class Runner2 {
}
