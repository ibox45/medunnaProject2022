package stepDefinitions.ui_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MedunnaHomePage;
import pages.PatientPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US_006_Steps {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    Faker faker = new Faker();
    PatientPage patientPage = new PatientPage();

    @When("Kullanici {string} adresinde")
    public void kullanici_adresinde(String medunnaUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @When("Kullanici account-menu butonuna tiklar")
    public void kullanici_account_menu_butonuna_tiklar() {
        medunnaHomePage.accountMenuButton2.click();
    }

    @When("Kullanici Sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        medunnaHomePage.signInButton.click();
    }

    @When("Kullanici gecerli username ve password ile girisi yapar")
    public void kullanici_gecerli_username_ve_password_ile_girisi_yapar() {
        medunnaHomePage.usernameTextBox.sendKeys(ConfigurationReader.getProperty("patientUsername"));
        medunnaHomePage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));
        medunnaHomePage.signInButton2.click();
    }

    @Then("Kullanici settings butonuna tiklar")
    public void kullanici_settings_butonuna_tiklar() {
        patientPage.setingsButton.click();

    }

    @Then("Firstname textbox'unda onceden girilen isimin gorundugu dogrulanir")
    public void firstname_textbox_unda_onceden_girilen_isimin_gorundugu_dogrulanir() {
        String actualFirstnameTextbox = patientPage.firstnameTextbox.getAttribute("value");
        Assert.assertEquals(actualFirstnameTextbox, ConfigurationReader.getProperty("patientFirstname"));


    }

    @Then("Lastname textbox'unda onceden girilen soyismin gorundugu dogrulanir")
    public void lastname_textbox_unda_onceden_girilen_soyismin_gorundugu_dogrulanir() {
        String actualLastnameTextbox = patientPage.lastnameTextbox.getAttribute("value");
        Assert.assertEquals(actualLastnameTextbox, ConfigurationReader.getProperty("patientLastname"));
    }

    @Then("email textbox'unda onceden girilen mail adresinin gorundugu dogrulanir")
    public void email_textbox_unda_onceden_girilen_mail_adresinin_gorundugu_dogrulanir() {
        Assert.assertEquals(patientPage.emailTextbox.getAttribute("value"), ConfigurationReader.getProperty("patientEmail"));

    }

    @And("Kulanici farkli isim girer")
    public void kulaniciFarkliIsimGirer() {
        patientPage.firstnameTextbox.clear();
        patientPage.firstnameTextbox.sendKeys(faker.name().firstName());
    }

    @And("Kullanici Save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        patientPage.saveButton.click();
    }

    @Then("Settings Saved yazisi gorundugu dogrulanir")
    public void settingsSavedYazisiGorunduguDogrulanir() {
        patientPage.settingsSavedText.isDisplayed();

    }

    @And("Kulanici farkli soyisim girer")
    public void kulaniciFarkliSoyisimGirer() {
        patientPage.lastnameTextbox.clear();
        patientPage.lastnameTextbox.sendKeys(faker.name().lastName());
    }

    @And("Kulanici farkli email girer")
    public void kulaniciFarkliEmailGirer() {
        patientPage.emailTextbox.clear();
        patientPage.emailTextbox.sendKeys(faker.internet().emailAddress());
    }
}
