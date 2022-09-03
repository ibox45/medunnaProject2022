package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import utilities.*;

import java.util.List;

public class US_028_Steps {


    AdminPage page = new AdminPage();
    String id;
    static  String  toastConteyner ;
    @Given("Admin {string} sayfasına gider")
    public void adminSayfasınaGider(String istenenUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenUrl));

    }
    @And("Kullanıcı sign in butonuna tıklar")
    public void kullanıcıSignInButonunaTıklar() {
        page.ilkSingInButton.click();
    }

    @And("Kullanıcı gecerli admin_Username ve password bilgilerini girer")
    public void kullanıcıGecerliAdmin_UsernameVePasswordBilgileriniGirer() {
        page.username.sendKeys(ConfigurationReader.getProperty("adminUsername"));

        page.password.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @And("İkinci Sign in butonuna tıklar")
    public void ikinciSignInButonunaTıklar() {
        page.ikinciSingInButton.click();

    }

    @Then("Kullanici Items&Titles dropdown menüsüne tıklar")
    public void kullanici_ıtems_titles_dropdown_menüsüne_tıklar() {
        page.itemsTitlesButon.click();

    }

    @Then("Açılan pencereden Country sekmesine tıklar")
    public void açılan_pencereden_country_sekmesine_tıklar() {
        page.countryButon.click();

    }

    @Then("Acılan sayfada Create a new Country butonuna tıklar")
    public void acılan_sayfada_create_a_new_country_butonuna_tıklar() {
        page.createCountryButon.click();

    }

    @Then("Name textbox ına tıklayıp ülke ismi girer")
    public void name_textbox_ına_tıklayıp_ülke_ismi_girer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Malta");


    }

    @Then("Created textbox ına tıklayıp tarih ve saat bilgisi girer")
    public void created_textbox_ına_tıklayıp_tarih_ve_saat_bilgisi_girer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).perform();

    }

    @Then("Save butonuna tıklar")
    public void save_butonuna_tıklar() {
        page.saveButon.click();
       toastConteyner = Driver.getDriver().findElement(By.cssSelector("[class=\"Toastify__toast-body\"]")).getText();
       ReusableMethods.waitFor(3);
    }

    @Then("Kayıt yapıldı yazısının göründüğünü test eder")
    public void kayıt_yapıldı_yazısının_göründüğünü_test_eder() throws InterruptedException {
        Assert.assertTrue(page.kayitYapildiButon.isDisplayed());
        id = page.allertId.getText().replaceAll("\\D", "");
        System.out.println(id);


    }

    @Then("Açılan pencereden StateCity sekmesine tıklar")
    public void açılan_pencereden_state_city_sekmesine_tıklar() throws InterruptedException {
        page.stateCityButon.click();
        Thread.sleep(1000);
    }

    @Then("Acılan sayfada Create a new StateCity butonuna tıklar")
    public void acılan_sayfada_create_a_new_state_city_butonuna_tıklar() throws InterruptedException {
        page.createStateCityButon.click();
    }

    @Then("Name textbox ına tıklayıp city ismi girer")
    public void name_textbox_ına_tıklayıp_city_ismi_girer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Valetta");

    }

    @And("Created textbox ına tıklayıp city icin tarih ve saat bilgisi girer")
    public void createdTextboxInaTıklayıpCityIcinTarihVeSaatBilgisiGirer() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("Malta").perform();

    }

    @And("City için Save butonuna tıklar")
    public void cityIçinSaveButonunaTıklar() {
        page.saveButon.click();
    }

    @And("City icin Kayıt yapılamadı yazısının göründüğünü test eder")
    public void cityIcinKayıtYapılamadıYazısınınGöründüğünüTestEder() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("country"));
    }

    @Then("Kayıtlı Country e gelip Delete butonuna tıklar")
    public void kayıtlı_country_e_gelip_delete_butonuna_tıklar() throws InterruptedException {
      /*  List<WebElement> idListe=Driver.getDriver().findElements(By.xpath("(//div[@id='app-view-container'])//table//tbody//tr//td//a[@class='btn btn-link btn-sm']"));
        List<WebElement> DeleteList=Driver.getDriver().findElements(By.xpath("//a[@class='btn btn-danger btn-sm']"));
       Actions action=new Actions(Driver.getDriver());
       action.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        //ReusableMethods.JSEScrollBy();
        Thread.sleep(1000);
        for (int i = 0; i < idListe.size(); i++) {
            if (idListe.get(i).getText().equals(id)){
                DeleteList.get(i).click();
            }
        }*/

        ReusableMethods.waitFor(1);
      //  String toastConteyner = Driver.getDriver().findElement(By.cssSelector("[class=\"Toastify__toast-body\"]")).getText();
        toastConteyner = toastConteyner.replaceAll("[^0-9_-]", "");
        ReusableMethods.waitFor(3);
        List<WebElement> kayitlar = Driver.getDriver().findElements(By.xpath("//tr//td[1]"));
        int kayitSirasi = 1;
        for (int i = 1; i < kayitlar.size(); i++) {
            if (Driver.getDriver().findElement(By.xpath("//tr[" + i + "]//td[1]")).getText().equals(toastConteyner)) {
                break;
            }
            kayitSirasi++;
        }
        String deleteRecordPath = "//tr[" + (kayitSirasi) + "]//td[4]//a[3]";
        System.out.println(deleteRecordPath);
        ReusableMethods.scroolDownToVisibleElement(Driver.getDriver().findElement(By.xpath(deleteRecordPath)));

        ReusableMethods.waitFor(2);
        Driver.getDriver().findElement(By.xpath(deleteRecordPath)).sendKeys(Keys.ENTER);
    }

    @Then("Açılan penceredeki Delete butonuna tıklar")
    public void açılan_penceredeki_delete_butonuna_tıklar() {
        page.ikinciDeleteButon.click();

    }

    @Then("Country silindi yazısının göründüğünü test eder")
    public void country_silindi_yazısının_göründüğünü_test_eder() {
        Assert.assertTrue(page.kayitSilindi.isDisplayed());

    }


}
