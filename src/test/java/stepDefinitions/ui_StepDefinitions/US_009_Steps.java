package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.StaffPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US_009_Steps {
    StaffPage personelPage = new StaffPage();


    @Given("Kullanıcı {string} sayfasına gider")
    public void kullanıcıSayfasınaGider(String istenenUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenUrl));
    }

    @When("Kullanıcı User ikonuna tıklar")
    public void kullanıcı_user_ikonuna_tıklar() {
        personelPage.accountMenu.click();
    }

    @And("Kullanıcı {int} saniye bekler")
    public void kullanıcıSaniyeBekler(int arg0) throws InterruptedException {
        Thread.sleep(1 * 1000);
    }

    @Then("Kullanıcı Sign in butonuna tıklar")
    public void kullanıcı_sign_in_butonuna_tıklar() {
        personelPage.ilkSingInButton.click();
    }

    @And("Kullanıcı gecerli personelUsername ve personelPassword bilgilerini girer, Sign in butonuna tıklar")
    public void kullanıcıGecerliPersonelUsernameVePersonelPasswordBilgileriniGirerSignInButonunaTıklar() {
        personelPage.username.sendKeys(ConfigurationReader.getProperty("personelUsername"));
        personelPage.password.sendKeys(ConfigurationReader.getProperty("personelPassword"));
        personelPage.ikinciSingInButton.click();
    }

   /* @And("Kullanıcı gecerli {string} ve {string} bilgilerini girer, Sign in butonuna tıklar")
    public void kullanıcıGecerliVeBilgileriniGirerSignInButonunaTıklar(String istenenUsername, String istenenPassword) {
        personelPage.username.sendKeys(istenenUsername);
        personelPage.password.sendKeys(istenenPassword);
        personelPage.ikinciSingInButton.click();
    }*/

    @Then("Personel My Pages dropdown menüsüne tıklar")
    public void personel_my_pages_dropdown_menüsüne_tıklar() {
        personelPage.myPages.click();
    }

    @Then("Açılan pencereden Search Patient sekmesine tıklar")
    public void açılan_pencereden_search_patient_sekmesine_tıklar() {

        personelPage.searchPatientButonu.click();
    }

    @And("Patient SSN texboxa tıklar, {string} girer")
    public void patientSSNTexboxaTıklarGirer(String String) {
        personelPage.patientSSNTexbox.click();
        personelPage.patientSSNTexbox.sendKeys(ConfigurationReader.getProperty("personelSSNNo"));

    }

    @Then("View butonuna tıklar, hasta bilgilerini görür")
    public void view_butonuna_tıklar_hasta_bilgilerini_görür() {

        personelPage.viewButon.click();
        Assert.assertTrue(personelPage.idgoruntulendibuton.isDisplayed());
    }

    @Then("Sayfayı aşağıya kaydırır, edit butonuna tıklar")
    public void sayfayı_aşağıya_kaydırır_edit_butonuna_tıklar() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        personelPage.editButon.click();
    }

    @And("Personel bütün hasta bilgilerini {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} düzenler")
    public void personelBütünHastaBilgileriniAndDüzenler(String firstname, String lastname, String birthdate, String email, String phone, String gender, String bloodgroup, String address, String description, String user, String country, String statecity) throws InterruptedException {
        personelPage.firstNameButon.clear();
        personelPage.firstNameButon.sendKeys(firstname);
        Thread.sleep(1000);

        personelPage.lastNameButon.clear();
        personelPage.lastNameButon.sendKeys(lastname);
        Thread.sleep(1000);

        personelPage.birthDateButon.sendKeys(birthdate);
        Thread.sleep(1000);

        personelPage.eMailButon.clear();
        personelPage.eMailButon.sendKeys(email);
        Thread.sleep(1000);

        personelPage.phoneButon.clear();
        personelPage.phoneButon.sendKeys(phone);
        Thread.sleep(1000);

        Select selectGender = new Select(personelPage.genderButon);
        selectGender.selectByVisibleText(gender);
        Thread.sleep(1000);

        Select selectBloodGroup = new Select(personelPage.bloodGroupButon);
        selectBloodGroup.selectByVisibleText(bloodgroup);
        Thread.sleep(1000);

        personelPage.adressButon.clear();
        personelPage.adressButon.sendKeys(address);
        Thread.sleep(1000);

        personelPage.descriptionButon.clear();
        personelPage.descriptionButon.sendKeys(description);
        Thread.sleep(1000);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select selectUser = new Select(personelPage.userButon);
        selectUser.selectByVisibleText(user);
        Thread.sleep(1000);

        Select selectCountry = new Select(personelPage.countryButon);
        selectCountry.selectByVisibleText(country);
        Thread.sleep(1000);

        Select selectStatecity = new Select(personelPage.stateButon);
        selectStatecity.selectByVisibleText(statecity);
        Thread.sleep(1000);


    }

    @Then("Save butonuna tıklar, hasta kayıt bilgilerinin düzenlendiğini görür")
    public void save_butonuna_tıklar_hasta_kayıt_bilgilerinin_düzenlendiğini_görür() {
        personelPage.saveButon.click();
        Assert.assertTrue(personelPage.kayıtyapıldıbutonu.isDisplayed());
    }


    @And("Herhangi bir hasta bilgisini siler")
    public void herhangiBirHastaBilgisiniSiler() throws InterruptedException {
        personelPage.adressButon.click();
        personelPage.adressButon.clear();
        Thread.sleep(1000);
        personelPage.saveButon.click();
        Assert.assertTrue(personelPage.kayıtyapıldıbutonu.isDisplayed());
    }

    @And("Hasta ID bilgisini silemediğini doğrular")
    public void hastaIDBilgisiniSilemediğiniDoğrular() throws InterruptedException {
        //personelPage.idbuton.clear();
        personelPage.idbuton.click();
        Thread.sleep(1000);
        Assert.assertFalse(personelPage.idbuton.isSelected());
    }

}