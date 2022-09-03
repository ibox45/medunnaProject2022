package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.MedunnaHomePage;
import pages.PatientPage;
import pages.StaffPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.Random;

public class US_020_021_Steps {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    AdminPage adminPage=new AdminPage();

    PatientPage patientPage=new PatientPage();

    StaffPage staffPage=new StaffPage();
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();



    @Then("username kutusuna {string} girer")
    public void username_kutusuna_girer(String string) {
        medunnaHomePage.usernameTextBox.sendKeys(ConfigurationReader.getProperty(string));

    }
    @Then("password kutusuna {string} girer")
    public void password_kutusuna_girer(String string) {
        medunnaHomePage.passwordTextBox.sendKeys(ConfigurationReader.getProperty(string));

    }

    @Then("administration butonuna tiklar")
    public void administration_butonuna_tiklar() {
        adminPage.administrationButonu.click();
    }
    @Then("usermanagement butonuna tiklar")
    public void usermanagement_butonuna_tiklar() {
        adminPage.userManagementButonu.click();
    }

    @Then("Herhangi view butonuna tiklar")
    public void herhangi_view_butonuna_tiklar() {

        Random random=new Random();
        int a=random.nextInt(20);
        WebElement viewButonu=Driver.getDriver().findElement(By.xpath("(//span[text()='View'])["+a+"]"));
        js.executeScript("arguments[0].click();",viewButonu);

    }


    @And("Kayitli kisilerin bilgilerinin gorundugunu test eder")
    public void kayitliKisilerinBilgilerininGorundugunuTestEder() {
        Assert.assertTrue(adminPage.firstNameYazisi.isDisplayed());
        Assert.assertTrue(adminPage.lastNameYazisi.isDisplayed());
        Assert.assertTrue(adminPage.eMailYazisi.isDisplayed());
    }

    @And("Herhangi Deactivated butonuna tiklar")
    public void herhangiDeactivatedButonunaTiklar() {
        modifiedDateYazisinaTiklar();
        modifiedDateYazisinaTiklar();
        adminPage.deactivatedButonu.click();

    }

    @And("Kullanicinin aktive edildigini gosteren uyari mesajinin gorundugunu test eder")
    public void kullanicininAktiveEdildiginiGosterenUyariMesajininGorundugunuTestEder() {
        Assert.assertTrue(adminPage.toastifyWebElementi.isDisplayed());
    }

    @And("Modified date yazisina tiklar")
    public void modifiedDateYazisinaTiklar() {
        adminPage.modifiedDate.click();
    }

    @And("Create a new user butonuna tiklar")
    public void createANewUserButonunaTiklar() {
        adminPage.createANewUserButonu.click();
    }

    @And("Login kutusuna {string} girer")
    public void loginKutusunaGirer(String string) {
        adminPage.loginKutusu.sendKeys(string);
    }

    @And("Firstname kutusuna {string} girer")
    public void firstnameKutusunaFirstnameGirer(String string) {
        adminPage.firstNameKutusu.sendKeys(string);
    }

    @And("Lastname kutusuna {string} girer")
    public void lastnameKutusunaLastnameGirer(String string) {
        adminPage.lastNameKutusu.sendKeys(string);
    }

    @And("Your Email kutusuna {string} girer")
    public void yourEmailKutusunaEmailGirer(String string) {
        adminPage.emailKutusu.sendKeys(string);
    }

    @And("SSN kutusuna bir {string} girer")
    public void ssnKutusunaBirSSNGirer(String string) {
        adminPage.ssnKutusu.sendKeys(string);

    }

    @And("Save butonuna tiklar")
    public void saveButonunaTiklar() {
        js.executeScript("arguments[0].click();",adminPage.saveButonu);
    }

    @And("Listedeki ilk delete butonuna tiklar")
    public void listedekiIlkDeleteButonunaTiklar() {
        adminPage.silinecekHesapDeleteButonu.click();
    }

    @And("Acilan onaylama metninde delete butonuna tiklar")
    public void acilanOnaylamaMetnindeDeleteButonunaTiklar() {
        adminPage.confirmDeleteButonu.click();
    }

    @And("Kullanicinin silindigini gosteren uyari mesajinin gorundugunu test eder")
    public void kullanicininSilindiginiGosterenUyariMesajininGorundugunuTestEder() {
        Assert.assertTrue(adminPage.toastifyWebElementi.isDisplayed());
    }


    @And("Herhangi bir kullanici icin edit butonuna tiklar")
    public void herhangiBirKullaniciIcinEditButonunaTiklar() {
        modifiedDateYazisinaTiklar();
        modifiedDateYazisinaTiklar();
        adminPage.editButonu.click();

    }

    @And("Herhangi bir kullanici rolu secer")
    public void herhangiBirKullaniciRoluSecer() {
        js.executeScript("arguments[0].scrollIntoView(true);", adminPage.profilesDropDownMenusu);
        Select select = new Select(adminPage.profilesDropDownMenusu);
        Random random=new Random();
        int a=random.nextInt(5);
        select.selectByIndex(a);

    }

    @And("Guncelleme yapilabildigini gosteren uyari mesajinin gorundugunu test eder")
    public void guncellemeYapilabildiginiGosterenUyariMesajininGorundugunuTestEder() {
        Assert.assertTrue(adminPage.toastifyWebElementi.isDisplayed());
    }

    @And("Sign out butonuna tiklar")
    public void signOutButonunaTiklar() {
        patientPage.signOutButonu.click();

    }

    @And("Patient SSN kutusuna {string} gir")
    public void patientSSNKutusunaGir(String string) {
        staffPage.patientSSNTexbox.sendKeys(ConfigurationReader.getProperty(string));
    }

    @And("Show Appointments butonuna tiklar")
    public void showAppointmentsButonunaTiklar() {
        staffPage.showAppointmentsButonu.click();
    }

    @And("Edit butonuna tiklar")
    public void editButonunaTiklar() {
        staffPage.editButon.click();
    }

    @And("Description kutusuna randevu guncellendi yazar")
    public void descriptionKutusunaRandevuGuncellendiYazar() {
        staffPage.descriptionKutusu.sendKeys("randevu guncellendi");
    }

    @And("Randevunun guncellendigini gosteren uyari mesajinin gorundugunu testeder")
    public void randevununGuncellendiginiGosterenUyariMesajininGorundugunuTesteder() {
        Assert.assertTrue(adminPage.toastifyWebElementi.isDisplayed());
    }

    @And("Staff Edit butonuna tiklar")
    public void staffEditButonunaTiklar() {
        staffPage.editButonu.click();
    }

    @And("Status Dropdown Menusunde UNAPPROVED yazisinin tiklanabilir oldugunu test eder")
    public void statusDropdownMenusundeUNAPPROVEDYazisininTiklanabilirOldugunuTestEder() {
        Assert.assertTrue(staffPage.unapprovedYazisi.isEnabled());


    }

    @And("Status Dropdown Menusunde PENDING yazisinin tiklanabilir oldugunu test eder")
    public void statusDropdownMenusundePENDINGYazisininTiklanabilirOldugunuTestEder() {
        Assert.assertTrue(staffPage.pendingYazisi.isEnabled());

    }

    @And("Status Dropdown Menusunde CANCELLED yazisinin tiklanabilir oldugunu test eder")
    public void statusDropdownMenusundeCANCELLEDYazisininTiklanabilirOldugunuTestEder() {
        Assert.assertTrue(staffPage.cancelledYazisi.isEnabled());

    }

    @And("Status Dropdown Menusunde COMPLETED yazisinin tiklanamaz oldugunu test eder")
    public void statusDropdownMenusundeCOMPLETEDYazisininTiklanamazOldugunuTestEder() {
        Assert.assertFalse(staffPage.completedYazisi.isEnabled());
    }

    @And("Anamnesis kutusuna data girilemedigini test eder")
    public void anamnesisKutusunaDataGirilemediginiTestEder() {
        staffPage.anamnesisKutusu.clear();
        staffPage.anamnesisKutusu.sendKeys("Data girilememeliydi ancak girilebiliyor");
        Assert.assertFalse(staffPage.anamnesisKutusu.isEnabled());



    }

    @And("Treatment kutusuna data girilemedigini test eder")
    public void treatmentKutusunaDataGirilemediginiTestEder() {
        staffPage.treatmentKutusu.clear();
        staffPage.treatmentKutusu.sendKeys("Data girilememeliydi ancak girilebiliyor");
        Assert.assertFalse(staffPage.treatmentKutusu.isEnabled());
    }

    @And("Diagnosis kutusuna data girilemedigini test eder")
    public void diagnosisKutusunaDataGirilemediginiTestEder() {
        staffPage.diagnosisKutusu.clear();
        staffPage.diagnosisKutusu.sendKeys("Data girilememeliydi ancak girilebiliyor");
        Assert.assertFalse(staffPage.diagnosisKutusu.isEnabled());
    }

    @And("Staff doktoru secer")
    public void staffDoktoruSecer() {
        js.executeScript("arguments[0].scrollIntoView ();",staffPage.doctorListesi);
        Select select=new Select(staffPage.doctorListesi);
        select.selectByIndex(1);

    }
}
