package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MedunnaHomePage;
import pages.PasswordPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_008_Steps {

    MedunnaHomePage home = new MedunnaHomePage();
    PasswordPage page = new PasswordPage();
    @Given("medunnaUrl sayfasina git")
    public void sayfasina_git() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @When("hesap menusune tikla")
    public void hesap_menusune_tikla() {
        home.accountMenuButton2.click();
    }

    @Then("birinci sign in butonuna tikla")
    public void birinci_sign_in_butonuna_tikla() {
        home.signInButton.click();
    }

    @Then("Username kismina {string}, Password kismina {string} gir")
    public void username_kismina_password_kismina_gir(String username, String password) {
        home.usernameTextBox.sendKeys(username);
        home.passwordTextBox.sendKeys(password);
    }

    @Then("ikinci sign in butonuna tikla")
    public void ikinci_sign_in_butonuna_tikla() {
        home.signInButton2.click();
        ReusableMethods.waitFor(1);
    }

    @Then("giris yapildigini dogrula")
    public void giris_yapildigini_dogrula() {
        Assert.assertTrue(page.loginHesapMenusu1.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @Then("login hesap menusune tıkla")
    public void login_hesap_menusune_tıkla() {
        page.loginHesapMenusu1.click();
    }

    @Then("password butonuna tıkla")
    public void password_butonuna_tıkla() {
        page.passwordButonu.click();
    }

    @Then("şifre değiştirme sayfasına geldiğini doğrula")
    public void şifre_değiştirme_sayfasına_geldiğini_doğrula() {
        Assert.assertTrue(page.currentPassword.isDisplayed());
    }

    @And("Current password textboxına {string} yazar")
    public void currentPasswordTextboxınaYazar(String password) {
        page.currentPassword.sendKeys(password);
    }

    @And("New password textboxına {string} yazar")
    public void newPasswordTextboxınaYazar(String yeniSifre) {
        page.newPassword.sendKeys(yeniSifre);
    }

    @And("New password confirmation textboxına {string} yazar")
    public void newPasswordConfirmationTextboxınaYazar(String yeniSifre) {
        page.newPasswordConfirmation.sendKeys(yeniSifre);
    }

    @Then("Kaydet butonuna tıklar")
    public void kaydet_butonuna_tıklar() {
        page.saveButonu.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Password changed! başarı yazısının geldiğini doğrular")
    public void password_changed_başarı_yazısının_geldiğini_doğrular() throws IOException {
        ReusableMethods.getScreenshot("hata");
        Assert.assertFalse(page.basariMesaji.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @Given("Kullanıcı New password confirmation textboxını temizler")
    public void kullanıcıNewPasswordConfirmationTextboxınıTemizler() {
        page.newPasswordConfirmation.clear();
        ReusableMethods.waitFor(1);
    }

    @When("New password confirmation textboxına new password'den farklı bir şifre yazar")
    public void newPasswordConfirmationTextboxınaNewPasswordDenFarklıBirŞifreYazar() {
        page.newPasswordConfirmation.sendKeys("asdfu6");
        ReusableMethods.waitFor(1);
    }

    @And("The password and its confirmation do not match! uyarısını görmelidir")
    public void thePasswordAndItsConfirmationDoNotMatchUyarısınıGörmelidir() {
        Assert.assertTrue(page.passwordEslesmedi.isDisplayed());
    }

    @Given("New password textboxını temizler")
    public void newPasswordTextboxınıTemizler() {
        page.newPassword.clear();
    }

    @When("New password textbaxına {string} sifresini gönderir")
    public void newPasswordTextbaxınaSifresiniGönderir(String password) {
        page.newPassword.sendKeys(password);
    }

    @And("New password textbaxına {string} ekler")
    public void newPasswordTextbaxınaEkler(String add_character) {
        page.newPassword.sendKeys(add_character);
    }

    @And("Password strength' in bir diş olduğunu doğrular")
    public void passwordStrengthInBirDişOlduğunuDoğrular() {
        Assert.assertTrue(page.birinciCubuk.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @And("Password strength' in iki diş olduğunu doğrular")
    public void passwordStrengthInIkiDişOlduğunuDoğrular() {
        Assert.assertTrue(page.ikinciCubuk.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @And("Password strength' in bir üç olduğunu doğrular")
    public void passwordStrengthInBirÜçOlduğunuDoğrular() {
        Assert.assertTrue(page.ucuncuCubuk.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @And("Password strength' in dört diş olduğunu doğrular")
    public void passwordStrengthInDörtDişOlduğunuDoğrular() {
        Assert.assertTrue(page.dorduncuCubuk.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @And("Password strength' in beş diş olduğunu doğrular")
    public void passwordStrengthInBeşDişOlduğunuDoğrular() {
        Assert.assertTrue(page.besinciCubuk.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @Given("Current password textboxını temizler")
    public void currentPasswordTextboxınıTemizler() {
        page.currentPassword.clear();
    }

    @Given("New password confirmation textboxını temizler")
    public void newPasswordConfirmationTextboxınıTemizler() {
        page.newPasswordConfirmation.clear();
    }

    @And("Sayfayı kapatır")
    public void sayfayıKapatır() {
        Driver.closeDriver();
    }

    @And("Password not changed! hata yazısının geldiğini doğrular")
    public void passwordNotChangedHataYazısınınGeldiğiniDoğrular() throws IOException {
        Assert.assertFalse(page.basariMesaji.isDisplayed());
        ReusableMethods.getScreenshot("hata");
    }

    @Then("user giris yapildigini dogrula")
    public void userGirisYapildiginiDogrula() {
        Assert.assertTrue(page.makeAnAppointment.isDisplayed());
    }
}
