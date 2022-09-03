package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US_01_02_Steps {

    RegistrationPage registrationPage = new RegistrationPage();

    @Given("kullanici {string} anasayfasina gider")
    public void kullanici_anasayfasina_gider(String istenenUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenUrl));

    }
    @Then("Account Menu simgesine tiklar")
    public void account_menu_simgesine_tiklar() {
        registrationPage.accountMenuButonu.click();

    }
    @Then("Register butonuna tiklar")
    public void register_butonuna_tiklar() {
        registrationPage.registerButonu.click();

    }
    @And("SSN kutusuna gecerli bir {string} girer")
    public void ssnKutusunaGecerliBirGirer(String ssn)  {
        registrationPage.ssnKutusu.sendKeys(ssn+ Keys.TAB);


    }
    @And("SSN kutusunun altinda Your SSN is invalid yazisinin gorunmedigini test eder")
    public void ssnKutusununAltindaYourSSNIsInvalidYazisininGorunmediginiTestEder() {
        String ssnForm= registrationPage.ssnFormGrubu.getText();
        System.out.println(ssnForm);
        Assert.assertEquals("SSN", ssnForm);
        //gecerli bir SSN girdiysek ssn form grubunda sadece "SSN" yazar. Your SSN is invalid yada
        //Your SSN is required yazmaz.
    }
    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();

    }


    @Then("{int} saniye bekler")
    public void saniyeBekler(int istenenSaniye) {
        try {
            Thread.sleep(istenenSaniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("SSN kutusuna gecersiz bir {string} girer")
    public void ssnKutusunaGecersizBirGirer(String ssn) {
        registrationPage.ssnKutusu.sendKeys(ssn+Keys.TAB);
    }


    @And("SSN kutusunun altinda Your SSN is invalid yazisinin gorundugunu test eder")
    public void ssnKutusununAltindaYourSSNIsInvalidYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.invalidSsnYazisi.isDisplayed());
    }

    @And("SSN kutusunu bos birakir")
    public void ssnKutusunuBosBirakir() {
        registrationPage.ssnKutusu.sendKeys(Keys.TAB);
    }


    @And("SSN kutusunun altinda Your SSN is required yazisinin gorundugunu test eder")
    public void ssnKutusununAltindaYourSSNIsRequiredYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.requiredSsnYazisi.isDisplayed());
    }


    @And("First Name kutusuna gecerli bir {string} girer")
    public void firstNameKutusunaGecerliBirGirer(String firstname) {
        registrationPage.firstNameKutusu.sendKeys(firstname+Keys.TAB);
    }

    @And("First Name kutusunun altinda Your FirstName is required yazisinin gorunmedigini test eder")
    public void firstNameKutusununAltindaYourFirstNameIsRequiredYazisininGorunmediginiTestEder() {
        String firstNameForm= registrationPage.firstNameFormGrubu.getText();
        System.out.println(firstNameForm);
        Assert.assertEquals("First Name", firstNameForm);
    }


    @And("First Name kutusunu bos birakir")
    public void firstNameKutusunuBosBirakir() {
        registrationPage.firstNameKutusu.sendKeys(Keys.TAB);
    }

    @And("First Name kutusunun altinda Your FirstName is required yazisinin gorundugunu test eder")
    public void firstNameKutusununAltindaYourFirstNameIsRequiredYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.requiredFirstNameYazisi.isDisplayed());

    }

    @And("Last Name kutusuna gecerli bir {string} girer")
    public void lastNameKutusunaGecerliBirGirer(String lastname) {
        registrationPage.lastNameKutusu.sendKeys(lastname);

    }

    @And("Last Name kutusunun altinda Your LastName is required yazisinin gorunmedigini test eder")
    public void lastNameKutusununAltindaYourLastNameIsRequiredYazisininGorunmediginiTestEder() {
        String lastNameForm= registrationPage.lastNameFormGrubu.getText();
        System.out.println(lastNameForm);
        Assert.assertEquals("Last Name", lastNameForm);

    }

    @And("Last Name kutusunu bos birakir")
    public void lastNameKutusunuBosBirakir() {
        registrationPage.lastNameKutusu.sendKeys(Keys.TAB);
    }


    @And("Last Name kutusunun altinda Your LastName is required yazisinin gorundugunu test eder")
    public void lastNameKutusununAltindaYourLastNameIsRequiredYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.requiredLastNameYazisi.isDisplayed());

    }

    @And("Username kutusuna gecerli bir {string} girer")
    public void usernameKutusunaGecerliBirGirer(String username) {
        registrationPage.userNameKutusu.sendKeys(username+Keys.TAB);
    }

    @And("Username kutusunun altinda Your username is invalid yazisinin gorunmedigini test eder")
    public void usernameKutusununAltindaYourUsernameIsInvalidYazisininGorunmediginiTestEder() {
        String userNameForm= registrationPage.userNameFormGrubu.getText();
        System.out.println(userNameForm);
        Assert.assertEquals("Username",userNameForm);
    }

    @And("Username kutusuna gecersiz bir {string} girer")
    public void usernameKutusunaGecersizBirGirer(String username) {
        registrationPage.userNameKutusu.sendKeys(username+Keys.TAB);
    }

    @And("Username kutusunun altinda Your username is invalid yazisinin gorundugunu test eder")
    public void usernameKutusununAltindaYourUsernameIsInvalidYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.invalidUserNameYazisi.isDisplayed());

    }

    @And("Username kutusunu bos birakir")
    public void usernameKutusunuBosBirakir() {
        registrationPage.userNameKutusu.sendKeys(Keys.TAB);
    }

    @And("Username kutusunun altinda Your username is required yazisinin gorundugunu test eder")
    public void usernameKutusununAltindaYourUsernameIsRequiredYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.requiredUserNameYazisi.isDisplayed());
    }

    @And("E-mail kutusuna gecerli bir {string} girer")
    public void eMailKutusunaGecerliBirGirer(String email) {
        registrationPage.emailKutusu.sendKeys(email);
    }

    @And("E-mail kutusunun altinda This field is invalid yazisinin gorunmedigini test eder")
    public void eMailKutusununAltindaThisFieldIsInvalidYazisininGorunmediginiTestEder() {
        String emailForm= registrationPage.emailFormGrubu.getText();
        System.out.println(emailForm);
        Assert.assertEquals("Email",emailForm);

    }

    @And("E-mail kutusuna gecersiz bir {string} girer")
    public void eMailKutusunaGecersizBirGirer(String email) {
        registrationPage.emailKutusu.sendKeys(email+Keys.TAB);
    }


    @And("E-mail kutusunun altinda This field is invalid yazisinin gorundugunu test eder")
    public void eMailKutusununAltindaThisFieldIsInvalidYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.invalidEmailYazisi.isDisplayed());

    }


    @And("E-mail kutusunu bos birakir")
    public void eMailKutusunuBosBirakir() {
        registrationPage.emailKutusu.sendKeys(Keys.TAB);
    }

    @And("E-mail kutusunun altinda Your email is required yazisinin gorundugunu test eder")
    public void eMailKutusununAltindaYourEmailIsRequiredYazisininGorundugunuTestEder() {
        Assert.assertTrue(registrationPage.requiredEmailYazisi.isDisplayed());
    }
}
