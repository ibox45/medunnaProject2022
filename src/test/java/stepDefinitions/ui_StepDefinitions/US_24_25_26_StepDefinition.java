package stepDefinitions.ui_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.PatientPage;

import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class US_24_25_26_StepDefinition {

    PatientPage page = new PatientPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    LocalDate guncelTarih;
    String tarih;
    Faker fk = new Faker();

    @Given("Hasta Medunna Url'e gider.")
    public void hasta_medunna_url_e_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));

    }

    @Given("Hasta sag uste bulunan account-menu 'yu tıklar.")
    public void hasta_sag_uste_bulunan_account_menu_yu_tıklar() {
        js.executeScript("arguments[0].click();", page.accountMenu);

    }

    @Given("Hasta Sign in butonuna tıklar ve giriş yapar")
    public void hasta_sign_in_butonuna_tıklar_ve_giriş_yapar() {
        js.executeScript("arguments[0].click();", page.ilkSigIn);
        page.username.sendKeys(ConfigurationReader.getProperty("hastaRana"));
        page.password.sendKeys(ConfigurationReader.getProperty("hRanaPassword"));
        js.executeScript("arguments[0].click();", page.ikinciSignInButonu);
    }

    @Given("Hasta My Pages butonuna tıklar.")
    public void hasta_my_pages_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.myPagesButonu);

    }

    @Given("Hasta My Appointments butonuna tıklar.")
    public void hasta_my_appointments_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.myAppointmentsbutonu);

    }

    @Given("Hasta Show Test butonuna tıklar.")
    public void hasta_show_test_butonuna_tıklar() throws InterruptedException {
        js.executeScript("arguments[0].click();", page.showTestButonu);
        Thread.sleep(1000);

    }

    @Given("Hasta View Results butonuna tıklar.")
    public void hasta_view_results_butonuna_tıklar() throws IOException, InterruptedException {
        js.executeScript("arguments[0].click();", page.viewResultsButonu);
        Assert.assertTrue(page.tableViewResults.isDisplayed());
        System.out.println(page.tableViewResults.getText());
        Thread.sleep(1000);
        ReusableMethods.getScreenshot("Test");

    }

    @And("Hasta Show Invoice butonuna tıklar.")
    public void hastaShowInvoiceButonunaTıklar() throws IOException, InterruptedException {
        js.executeScript("arguments[0].click();", page.showInvoiceButonu);
        for (int i = 0; i < page.tableInvoice.size(); i++) {
            System.out.println(page.tableInvoice.get(i).getText());
        }
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("Invoice");

    }

    @And("Hasta tarih aralıgını secer")
    public void hastaTarihAralıgınıSecer() throws InterruptedException {
        page.fromDate.sendKeys("20" + "08");
        Thread.sleep(2000);
        page.toDate.sendKeys("03" + "09");
        Thread.sleep(2000);

    }


    @Then("YH Hasta Sign in butonuna tıklar ve giriş yapar")
    public void yh_hasta_sign_in_butonuna_tıklar_ve_giriş_yapar() {
        js.executeScript("arguments[0].click();", page.ilkSigIn);
        page.username.sendKeys(ConfigurationReader.getProperty("Hastatesterusername"));
        page.password.sendKeys(ConfigurationReader.getProperty("Htpassword"));
        js.executeScript("arguments[0].click();", page.ikinciSignInButonu);
    }

    @Then("YH Hasta My Pages butonuna tıklar.")
    public void yh_hasta_my_pages_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.myPagesTester);
    }

    @Then("YH Hasta Make an Appointments butonuna tıklar.")
    public void yh_hasta_make_an_appointments_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.makeAppointment);
    }

    @Then("YH Hastanın girdigi tarihin sırası gün,ay,yıl şeklinde olmalıdır.")
    public void yh_hastanın_girdigi_tarihin_sırası_gün_ay_yıl_şeklinde_olmalıdır() {
        // System.out.println(page.toDate.getText());
        DateTimeFormatter duzenle = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        guncelTarih = LocalDate.now();
        String tarih;
        tarih = duzenle.format(guncelTarih);
        Assert.assertTrue(page.appoDate.isDisplayed());
    }

    @Then("YH Hasta {string} bilgilerini girer.")
    public void yh_hasta_bilgilerini_girer(String string) {
        ReusableMethods.JSEScrollBy(50);
        actions.click(page.firstName).sendKeys("Hayat").
                sendKeys(Keys.TAB).sendKeys("tester").
                sendKeys(Keys.TAB).sendKeys("159-35-7641").
                sendKeys(Keys.TAB).sendKeys("hyt20@mail.com").
                sendKeys(Keys.TAB).sendKeys("5555555555").
                sendKeys(Keys.TAB).perform();


    }

    @Then("YH Hasta gecerli tarih girmelidir.")
    public void yh_hasta_gecerli_tarih_girmelidir() throws InterruptedException {
        Thread.sleep(2000);
        actions.click(page.appoDate).sendKeys("24").sendKeys(Keys.TAB).sendKeys("08").sendKeys(Keys.TAB).sendKeys("2022").perform();
        Thread.sleep(2000);
        Assert.assertTrue(page.yanlısDateTimeYazısı.isDisplayed());

    }


    @Then("YH Hasta Send an Appointment Request butonuna tıklar.")
    public void yh_hasta_send_an_appointment_request_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.sendAppointmentRequest);

    }


    @Given("Kullanıcı Medunna Url'e gider.")
    public void kullanıcı_medunna_url_e_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));

    }

    @Then("Kullanıcı anasayfadaki Make an Appointment butonuna tıklar.")
    public void kullanıcı_anasayfadaki_make_an_appointment_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.makeAnAppointmentButonu);

    }

    @Then("Kullanıcı {string} bilgilerini girer.")
    public void kullanıcı_bilgilerini_girer(String string) {
        actions.click(page.firstName).sendKeys("Hayat").
                sendKeys(Keys.TAB).sendKeys("tester").
                sendKeys(Keys.TAB).sendKeys("159-35-7641").
                sendKeys(Keys.TAB).sendKeys("hyt20@mail.com").
                sendKeys(Keys.TAB).sendKeys("5555555555").
                sendKeys(Keys.TAB).perform();
    }

    @Then("Kullanıcı Send an Appointment Request butonuna tıklar.")
    public void kullanıcı_send_an_appointment_request_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.sendAppointmentRequest);
    }

    @Then("Kullanıcı sag uste bulunan account-menu 'yu tıklar.")
    public void kullanıcı_sag_uste_bulunan_account_menu_yu_tıklar() {
        js.executeScript("arguments[0].click();", page.accountMenu);
    }

    @Then("Kullanıcı Sign butonunu tıklar ve giris yapar.")
    public void kullanıcı_sign_butonunu_tıklar_ve_giris_yapar() {
        js.executeScript("arguments[0].click();", page.ilkSigIn);
        page.username.sendKeys(ConfigurationReader.getProperty("Hastatesterusername"));
        page.password.sendKeys(ConfigurationReader.getProperty("Htpassword"));
        js.executeScript("arguments[0].click();", page.ikinciSignInButonu);
    }

    @Then("KullanıcıMy Pages butonuna tıklar.")
    public void kullanıcı_my_pages_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.myPagesTester);
    }

    @Then("Kullanıcı My Appointments butonuna tıklar.")
    public void kullanıcı_my_appointments_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.myAppointmentsTester);
    }

    @Then("Kullanıcı randevusunun olustugunu gorur.")
    public void kullanıcı_randevusunun_olustugunu_gorur() {

        String randevu = null;
        for (int i = 0; i < page.randevuKontrol.size(); i++) {
            randevu = page.randevuKontrol.get(i).getText();

        }
        System.out.println(randevu);
        Assert.assertEquals("Hasta tester", page.hastaDogrulama.get(1).getText());


    }

    @And("Kullanıcı Firstname , lastname , SSN ,Phone  bos bırakamaz")
    public void kullanıcıFirstnameLastnameSSNPhoneBosBırakamaz() throws InterruptedException {
        actions.click(page.firstName).click(page.lastName).click(page.ssn).click(page.email).click(page.phone).click(page.appoDate).sendKeys("24.08.2022").perform();
        Assert.assertTrue(page.firstNameBosOlamaz.isDisplayed());
        Assert.assertTrue(page.lastNameBosOlamaz.isDisplayed());
        Assert.assertTrue(page.SSNBosOlamaz.isDisplayed());
        Assert.assertTrue(page.emailBosOlamaz.isDisplayed());
        Assert.assertTrue(page.phoneBosOlamaz.isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(page.yanlısDateTimeYazısı.isDisplayed());

    }

    @Then("Kullanıcı Anasayfada bulunan Contact butonuna tıklar.")
    public void kullanıcı_anasayfada_bulunan_contact_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.contactButonu);
    }

    @And("Kullanıcı Name,Email,Subject,Message bilgilerini girer")
    public void kullanıcıNameEmailSubjectMessageBilgileriniGirer() {
        ReusableMethods.JSEScrollBy(750);
        actions.click(page.concatName).
                sendKeys(fk.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(fk.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys("Hasta").
                sendKeys(Keys.TAB).
                sendKeys("Randevularda sıkıntı var.").perform();
    }


    @Then("Kullanıcı Send butonuna tıklar.")
    public void kullanıcı_send_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.sendButonu);
    }


    @Then("Hasta Contact butonuna tıklar.")
    public void hasta_contact_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.contactButonu);
    }

    @And("Hasta Name,Email,Subject,Message bilgilerini girer")
    public void hastaNameEmailSubjectMessageBilgileriniGirer() {
        ReusableMethods.JSEScrollBy(750);
        actions.click(page.concatName).
                sendKeys(fk.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(fk.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys("Team57").
                sendKeys(Keys.TAB).
                sendKeys("Bu bolum sıkıntısız calisti.").perform();
    }

    @Then("Hasta Send butonuna tıklar.")
    public void hasta_send_butonuna_tıklar() {
        js.executeScript("arguments[0].click();", page.sendButonu);
    }


}
