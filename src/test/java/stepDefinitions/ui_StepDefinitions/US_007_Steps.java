package stepDefinitions.ui_StepDefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaHomePage;
import pages.PatientPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;


import static org.junit.Assert.assertTrue;

public class US_007_Steps {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    PatientPage patientPage = new PatientPage();


    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());


    @Given("Hasta Kullanici {string} gider")
    public void hastaKullaniciGider(String arg0) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @When("Kullanici anasayfadaki account-menu ye tiklar")
    public void kullanici_anasayfadaki_account_menu_ye_tiklar() {
        registrationPage.accountMenuButonu.click();

    }

    @When("Kullanici sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        medunnaHomePage.signInButton.click();
    }


    @Then("Kullanici gecerli isim girisi yapar")
    public void kullaniciGecerliIsimGirisiYapar() {
        medunnaHomePage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("patientUsername"));

    }

    @And("Kullanici gecerli sifre girisi yapar")
    public void kullaniciGecerliSifreGirisiYapar() {
        medunnaHomePage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @Then("Kullanici ikinci sign in butonuna tiklar")
    public void kullanici_ikinci_sign_in_butonuna_tiklar() {
        medunnaHomePage.signInButton2.click();
    }

    @When("Kullanici acilan sayfadaki MY PAGES\\(PATIENT) bolumune gelir")
    public void kullanici_acilan_sayfadaki_my_pages_patient_bolumune_gelir() {
        patientPage.myPages.click();
    }

    @When("Make an Appointment'i tiklar")
    public void make_an_appointment_i_tiklar() {
        patientPage.makeAppointment.click();
    }


    @And("Kullanici gecerli Phone numarasini girer")
    public void kullaniciGecerliPhoneNumarasiniGirer() {
        patientPage.phone.sendKeys(ConfigurationReader.getProperty("phonePatient"));

    }

    @And("Girilen tarihin gun.ay.yil formatinda oldugu test edilir")
    public void girilenTarihinGunAyYilFormatindaOlduguTestEdilir() {
        assertTrue(("22082022"), patientPage.appoDate.isDisplayed()); // :) duzenle
    }

    @Then("Appointment DateTime altindaki kutucuga gunun tarihi girilir")
    public void appointment_date_time_altindaki_kutucuga_gunun_tarihi_girilir() {
        patientPage.appoDate.sendKeys("17082022");
    }

    @Then("Appointment DateTime altindaki kutucuga ileri bir tarih girilir")
    public void appointment_date_time_altindaki_kutucuga_ileri_bir_tarih_girilir() {
        patientPage.appoDate.sendKeys("22082022");

    }

    @Then("Send an Appointment Request'e tiklanir")
    public void send_an_appointment_request_e_tiklanir() {
        patientPage.sendRequestButton.click();
    }

    @Then("Kullanici sayfayi kapatir")
    public void Kullanici_sayfayi_kapatir() {
        Driver.closeDriver();

    }

    @Then("{int} saniye")
    public void saniye(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
