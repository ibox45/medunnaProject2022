package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.PhysicianPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


public class US_012_013_014_Steps {

    PhysicianPage PhysicianPage = new PhysicianPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());


    @When("doktor {string} anasayfasina gider")
    public void doktor_anasayfasina_gider(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
    }

    @When("Kullanıcı sag ustde account-menu tıklar")
    public void kullanıcı_sag_ustde_account_menuye_tıklar() {
        PhysicianPage.accountMenu.click();

    }

    @When("Doktor Sign in butonuna tıklar")
    public void doktor_sign_in_butonuna_tıklar() {
        PhysicianPage.singIn.click();

    }

    @When("Username bolumune {string} yazar")
    public void username_bolumune_yazar(String username) {
        PhysicianPage.username.sendKeys("physician_team57");

    }

    @And("Doktor password bolumune {string} yazar")
    public void doktorPasswordBolumuneYazar(String password) {
        PhysicianPage.password.sendKeys("ortakKullan.2022");

    }

    @When("Sign in butonuna tıklar")
    public void sign_in_butonuna_tıklar() {
        PhysicianPage.ikinciSingIn.click();

    }

    @When("Doktor My Pages butonuna tıklar")
    public void doktor_my_pages_butonuna_tıklar() {
        PhysicianPage.myPages.click();

    }

    @When("Doktor My Appointments butonuna tıklar")
    public void doktor_my_appointments_butonuna_tıklar() {
        PhysicianPage.myAppointments.click();

    }

    @When("Doktor hasta adıyla aynı satırdaki  Edit butonuna tıklar")
    public void doktor_hasta_adıyla_aynı_satırdaki_edit_butonuna_tıklar() throws InterruptedException {
        PhysicianPage.editButonu.click();
        Assert.assertTrue(PhysicianPage.editInPatient.isDisplayed());
        Thread.sleep(2000);
        System.out.println(PhysicianPage.editInPatient.getText());

    }

    @When("Doktor Request A Test butonuna tıklar")
    public void doktor_request_a_test_butonuna_tıklar() {
        PhysicianPage.requestTestButonu.click();
        // js.executeScript("arguments[0].click();", medunnaPage.requestTestButonu);

    }

    @And("Doktor Glucose,Urea,Creatinine,Sodium,Potasyum,Total protein,Albumin,Hemoglobin testlerine ait kutucukları isaretler")
    public void doktorGlucoseUreaCreatinineSodiumPotasyumTotalProteinAlbuminHemoglobinTestlerineAitKutucuklarıIsaretler() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", PhysicianPage.SodiumCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.glucoseCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.potasyumCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.CreatinineCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.AlbuminCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.TotalProteinCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.HemoglobinCheckbox);
        js.executeScript("arguments[0].click();", PhysicianPage.UreaCheckbox);

    }

    @And("Doktor Save butonuna tıklar")
    public void doktorSaveButonunaTıklar() {
        js.executeScript("arguments[0].click();", PhysicianPage.saveButonu);
    }

    @And("Doktor Show Test Result butonuna tıklar")
    public void doktorShowTestResultButonunaTıklar() throws InterruptedException {
        js.executeScript("arguments[0].click();", PhysicianPage.ShowTestResultsButonu);
    }

    @And("Doktor View Results butonuna tıklar")
    public void doktorViewResultsButonunaTıklar() throws InterruptedException {
        js.executeScript("arguments[0].click();", PhysicianPage.viewResultsButonu);
        Assert.assertTrue(PhysicianPage.testResult.isDisplayed());// medunnaPage.testResult.isDisplayed();
        System.out.println(PhysicianPage.testResult.getText());
    }

    @And("Doktor Request Inpatıent butonunu tıklar")
    public void doktorRequestInpatıentButonunuTıklar() {
        js.executeScript("arguments[0].click();", PhysicianPage.requestTestButonu);
    }

    @And("Doktor My Inpatients butonuna tıklar")
    public void doktorMyInpatientsButonunaTıklar() {
        js.executeScript("arguments[0].click();", PhysicianPage.MyInpatients);
    }

    @And("Doktor Status secenegini gunceller")
    public void doktorStatusSeceneginiGunceller() throws IOException, InterruptedException {
        js.executeScript("arguments[0].click();", PhysicianPage.status);
        Thread.sleep(2000);
        Select select = new Select(PhysicianPage.status);
        select.selectByValue("UNAPPROVED");
        Thread.sleep(2000);
        select.selectByValue("DISCHARGED");
        Thread.sleep(2000);
        select.selectByValue("STAYING");
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", PhysicianPage.yeniSaveButonu);
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("statusAlert");
        // UNAPPROVED, DISCHARGED, STILL STAYING veya CANCELLED
    }


    @And("Doktor hasta adıyla aynı satırdaki bulunan Edit butonuna tıklar")
    public void doktorHastaAdıylaAynıSatırdakiBulunanEditButonunaTıklar() {
        js.executeScript("arguments[0].click();", PhysicianPage.yeniEditButonu);
    }


    @And("Doktor room bilgisini gunceller")
    public void doktorRoomBilgisiniGunceller() throws IOException, InterruptedException {
        js.executeScript("arguments[0].click();", PhysicianPage.room);
        Select slt = new Select(PhysicianPage.room);
        slt.selectByValue("130661");
        js.executeScript("arguments[0].click();", PhysicianPage.yeniSaveButonu);
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("roomAlert");

    }


    @And("Doktor tarih aralıgını secer")
    public void doktorTarihAralıgınıSecer() throws InterruptedException {
        PhysicianPage.fromDate.sendKeys("02");
        Thread.sleep(2000);
        PhysicianPage.toDate.sendKeys("15");
        Thread.sleep(2000);

    }

    @Then("kullanici {int} sn bekler")
    public void kullaniciSnBekler(int istenenSaniye) {
        try {
            Thread.sleep(istenenSaniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();

    }
}
