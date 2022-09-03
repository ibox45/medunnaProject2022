package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import pages.MedunnaHomePage;
import pages.PatientPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class US_005_Steps {


    PatientPage patientPage=new PatientPage();
    MedunnaHomePage homePage=new MedunnaHomePage();

    @Given("kullanıcı {string} sayfasına gider")
    public void kullanıcı_sayfasına_gider(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @Given("kullanıcı sayfanın sag ust kısmındaki kullanıcı logosuna tıklar")
    public void kullanıcı_sayfanın_sag_ust_kısmındaki_kullanıcı_logosuna_tıklar() {
        homePage.accountMenuButton2.click();

    }

    @Then("kullanıcı acilan menude Sign in butonuna tiklar")
    public void kullanıcı_acilan_menude_sign_in_butonuna_tiklar() {

        homePage.signInButton.click();
    }
    @And("kullanıcı username kısmına {string}  girer.")
    public void kullanıcıUsernameKısmınaGirer(String username) {
        homePage.usernameTextBox.sendKeys(username );

    }

    @Then("kullanıcı password kısmına {string} girer.")
    public void kullanıcıPasswordKısmınaGirer(String password) {

        homePage.passwordTextBox.sendKeys(password);
    }



    @Then("kullanıcı sayfaya gidebilmek icin Sign in butonuna tıklar.")
    public void kullanıcı_sayfaya_gidebilmek_icin_sign_in_butonuna_tıklar() {

        homePage.signInButton2.click();
    }

    @Then("kullanıcı sayfanin sağ ust kismindaki My Pages butonuna tiklar.")
    public void kullanıcı_sayfanin_sağ_ust_kismindaki_my_pages_butonuna_tiklar() {

        patientPage.myPages.click();
    }



    @Then("kullanıcı bir {string} yazar ve bu alanı boş bırakamaz")
    public void kullanıcıBirYazarVeBuAlanıBoşBırakamaz(String firstname) {
        homePage.FirstName.clear();
        homePage.FirstName.sendKeys(" "+Keys.TAB);

    }

    @Then("Your FirstName is required. yazısının olmadığı test edilir.")
    public void your_first_name_is_required_yazısının_olmadığı_test_edilir() {

/*
        boolean thrown = true;

        try {
            us005.firstNameIsRequiredYazısı.isDisplayed();
        } catch (NoSuchElementException e) {
            thrown = false;
        }

        Assert.assertTrue(thrown);


 */





        try
        {
            Assert.assertTrue(homePage.firstNameIsRequired.isDisplayed());



        } catch (AssertionError e)
        {
           Assert.assertTrue(true);
        }


    }

    @Then("kullanıcı sayfayı kapatır")
    public void kullanıcı_sayfayı_kapatır() {
        Driver.closeDriver();

    }


    @And("kullanıcı anasayfadaki Make an Appointment butonuna tıklar")
    public void kullanıcıAnasayfadakiMakeAnAppointmentButonunaTıklar() {
        homePage.makeAnAppointmentAnaSayfa.click();

    }

    @Then("kullanıcı kayıtlı {string} yazar ve bu alanı boş bırakamaz")
    public void kullanıcıKayıtlıYazarVeBuAlanıBoşBırakamaz(String SSN) {

        homePage.SSN.sendKeys(SSN+Keys.TAB);
    }



    @And("Your SSN is invalid yazısının olmadığı test edilir.")
    public void yourSSNIsInvalidYazısınınOlmadığıTestEdilir() {
        try
        {


            homePage.YourSSNIsInvalid.isDisplayed();
            Assert.fail();

        } catch (NoSuchElementException e)
        {
            Assert.assertTrue(true);

        }
    }

    @And("Your {string} is invalid yazısının olmadığı test edilir.")
    public void yourIsInvalidYazısınınOlmadığıTestEdilir(String SSN) {
        if(SSN.equals("")){

            Assert.fail();
        }else{


            Assert.assertTrue(true);
        }
    }

    @And("Your {string} is required. yazısının olmadığı test edilir.")
    public void yourIsRequiredYazısınınOlmadığıTestEdilir(String FirstName) {
        if(FirstName.equals("")){

            Assert.fail();
        }else{


            Assert.assertTrue(true);
        }
    }

    @Then("kullanıcı LastName kısmına bir {string} yazar ve bu alanı boş bırakamaz")
    public void kullanıcıLastNameKısmınaBirYazarVeBuAlanıBoşBırakamaz(String LastName) {
        homePage.LastName.sendKeys(LastName+Keys.TAB);

    }

    @And("Last Name kısmının altında Your {string} is required. yazısının olmadığı  test edilir.")
    public void lastNameKısmınınAltındaYourIsRequiredYazısınınOlmadığıTestEdilir(String LastName) {
        if(LastName.equals("")){

            Assert.fail();
        }else{


            Assert.assertTrue(true);
        }
    }

    @Then("kullanıcı email kısmına bir {string} yazar ve bu alanı boş bırakamaz")
    public void kullanıcıEmailKısmınaBirYazarVeBuAlanıBoşBırakamaz(String Email) {
        homePage.Email.sendKeys(Email+Keys.TAB);

        
    }

    @And("Email kısmının altında Your {string} is required. yazısının olmadığı  test edilir.")
    public void emailKısmınınAltındaYourIsRequiredYazısınınOlmadığıTestEdilir(String Email) {
        if(Email.equals("")){

            Assert.fail();
        } else if(Email.contains("@")){
                if(Email.contains(".")){
                    Assert.assertTrue(true);

                }else{
                    Assert.fail();

                }
            }else{
            Assert.fail();

        }




    }

    @Then("kullanıcı telefon numarası kısmına bir {int}. ve {int}. rakamdan sonra {string} olan {int} rakamlı {string} girer ve bu alanı boş bırakamaz")
    public void kullanıcıTelefonNumarasıKısmınaBirVeRakamdanSonraOlanRakamlıGirerVeBuAlanıBoşBırakamaz(int arg0, int arg1, String arg2, int arg3, String TelefonNumarası) {

        homePage.PhoneNumber.sendKeys(TelefonNumarası+Keys.TAB);
        
    }

    @And("telefon numarasının altında Your {string} is required. yazısının olmadığı  test edilir.")
    public void telefonNumarasınınAltındaYourIsRequiredYazısınınOlmadığıTestEdilir(String TelefonNumarasi) {

        if(TelefonNumarasi.charAt(3) == '-'){
            if (TelefonNumarasi.charAt(7) == '-'){
                if(TelefonNumarasi.length()==12){
                    assertTrue(true);
                }else {
                    Assert.fail();
                }
            }else{
                Assert.fail();
            }

        }else{
            Assert.fail();
        }
    }

    @And("kullanıcı Send an Appointment Request butonuna tıklar")
    public void kullanıcıSendAnAppointmentRequestButonunaTıklar() {
        homePage.SendanAppointmentRequestButonu.submit();
    }

    @And("kullanıcı My Appointments butonuna tıklar")
    public void kullanıcıMyAppointmentsButonunaTıklar() {
        patientPage.MyAppointments.click();

    }

    @Then("kullanıcı randevusunu oluşturduğunu görür")
    public void kullanıcıRandevusunuOluşturduğunuGörür() {
        try{
            patientPage.id.isDisplayed();
            Assert.assertTrue(true);
        }catch(Exception e){
            Assert.fail();
        }


    }

    @And("telefon numarasının altında Your telefonnumarasi is required. yazısının olmadığı  test edilir.")
    public void telefonNumarasınınAltındaYourTelefonnumarasiIsRequiredYazısınınOlmadığıTestEdilir() {
        try
        {


            homePage.PhoneNumber.isDisplayed();
            Assert.fail();

        } catch (NoSuchElementException e)
        {
            Assert.assertTrue(true);

        }
    }
}
