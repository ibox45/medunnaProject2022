package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import pages.PhysicianPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class US_010_011_017Steps {
    Actions actions = new Actions(Driver.getDriver());


    PhysicianPage physicianPage = new PhysicianPage();

    @Given("medunna sayfasina git")
    public void medunna_sayfasina_git() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @Then("Account-menuye tikla")
    public void account_menuye_tikla() {
        physicianPage.accountMenu.click();
    }

    @Then("Sing in tikla")
    public void sing_in_tikla() {
        physicianPage.singIn.click();
    }

    @Then("Username kismina {string},  Password kismina  {string} gir")
    public void username_kismina_password_kismina_gir(String username, String password) {
        physicianPage.username.sendKeys(ConfigurationReader.getProperty("physicianUsername"));
        physicianPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("Sing in butonuna tikla")
    public void sing_in_butonuna_tikla() {
        physicianPage.ikinciSingIn.click();
    }

    @Then("MY PAGES sekmesini tikla")
    public void my_pages_sekmesini_tikla() {
        physicianPage.myPages.click();
    }

    @Then("My Appointments sekmesini tikla")
    public void my_appointments_sekmesini_tikla() {

        physicianPage.myAppointments.click();
    }

    @Then("Appointmentin gorunur oldugunu dogrula")
    public void appointmentin_gorunur_oldugunu_dogrula() {
        WebElement appointments = physicianPage.myAppointmentsYazisi;
        assertTrue(appointments.isDisplayed());
    }

    @Then("Onbes gunluk tarih araligini sec")
    public void onbes_gunluk_tarih_araligini_sec() {
        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(physicianPage.fromDate).
                sendKeys("03").
                sendKeys("08").
                sendKeys("2022").sendKeys(Keys.TAB).
                sendKeys("17").
                sendKeys("08").
                sendKeys("2022").sendKeys(Keys.TAB).perform();
    }

    @And("Zaman diliminin gorunur oldugunu dogrula")
    public void zamanDilimininGorunurOldugunuDogrula() {

        assertTrue(physicianPage.fromDate.isDisplayed());
        assertTrue(physicianPage.toDate.isDisplayed());


    }

    @And("Belirtilen tarihler arasindaki hasta randevu listesinin gorunur oldugunu dogrula")
    public void belirtilenTarihlerArasindakiHastaRandevuListesininGorunurOldugunuDogrula() throws InterruptedException {

        List<WebElement> baslikBilgileri = physicianPage.baslikBilgileri;
        List<WebElement> hastaBilgileri = physicianPage.hastaBilgileri;

        Thread.sleep(3000);

        for (int i = 0; i < baslikBilgileri.size(); i++) {
            assertTrue(baslikBilgileri.get(i).isDisplayed());
        }
        System.out.println("baslikBilgileri = " + baslikBilgileri.get(0).getText());
        for (int i = 0; i < hastaBilgileri.size(); i++) {
            assertTrue(hastaBilgileri.get(i).isDisplayed());
        }

    }


    @And("ID,Start DateTime, End DateTime, Status kısımlarının ve burada bulunan bilgilerin gorunur olduğunu dogrula")
    public void idStartDateTimeEndDateTimeStatusKısımlarınınVeBuradaBulunanBilgilerinGorunurOlduğunuDogrula() throws InterruptedException {
        /*Baslik Bilgileri*/
        List<WebElement> baslikBilgileri = physicianPage.baslikBilgileri;// baslık bilgileri liste atıldı
        List<String> strBaslikBilgileri = new ArrayList<>();
        Thread.sleep(3000);
        for (int i = 0; i < baslikBilgileri.size(); i++) {
            strBaslikBilgileri.add(baslikBilgileri.get(i).getText());// webelemenet String liste atıldı
            assertTrue(baslikBilgileri.get(i).isDisplayed());// tüm baslık bilgilerini görüldüğü dogrulandı

        }

        List<String> actualBaslikBilgileri = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            actualBaslikBilgileri.add(strBaslikBilgileri.get(i));
        }
        System.out.println("actualBaslikBilgileri = " + actualBaslikBilgileri);

        List<String> expectedBaslikBilgileri = new ArrayList<String>();
        expectedBaslikBilgileri.add("ID");
        expectedBaslikBilgileri.add("Start DateTime");
        expectedBaslikBilgileri.add("End DateTime");
        expectedBaslikBilgileri.add("Status");
        assertEquals(expectedBaslikBilgileri, actualBaslikBilgileri);

        /*Hasta Bilgileri*/
        List<WebElement> hastaBilgileri = physicianPage.hastaBilgileri; // tüm hasta bilgileri liste atıldı

        for (int i = 0; i < hastaBilgileri.size(); i++) {
            assertTrue(hastaBilgileri.get(i).isDisplayed()); // tüm hasta bilgilerini görüntelebilir olduğu doğrulandı.

        }

    }

    @Given("ilk hasta icin Edit butonuna tikla")
    public void ilkHastaIcinEditButonunaTikla() throws InterruptedException {
        Thread.sleep(5000);
        physicianPage.ilkHastaEdit.click();


    }

    @Then("Create or Edit an Appointment yazisinin gorunur oldugunu dogrula")
    public void createOrEditAnAppointmentYazisininGorunurOldugunuDogrula() {
        assertTrue(physicianPage.createOrEditAnAppointment.isDisplayed());

    }


    @And("Status Anamnesis Treatment Diagnosis Prescription Aspirin Description kismlarini doldur")
    public void statusAnamnesisTreatmentDiagnosisPrescriptionAspirinDescriptionKismlariniDoldur() {

        Select select = new Select(physicianPage.status);
        select.selectByIndex(2);


        physicianPage.anamnesis.clear();
        physicianPage.anamnesis.sendKeys("Anamnesis");

        physicianPage.diagnosis.clear();
        physicianPage.diagnosis.sendKeys("Treatment");

        physicianPage.treatment.clear();
        physicianPage.treatment.sendKeys("Diagnosis");

        physicianPage.prescription.clear();
        physicianPage.prescription.sendKeys("Prescription");

        physicianPage.description.clear();
        physicianPage.description.sendKeys("Description");

        // actions.sendKeys(Keys.TAB).click(US1011.anamnesis).
        //         sendKeys("Anamnesis").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Treatment").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Diagnosis").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Prescription").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Description").sendKeys(Keys.PAGE_DOWN).perform();


    }

    @And("Save butonuna tiklayalim")
    public void saveButonunaTiklayalim() throws InterruptedException {
        Thread.sleep(5000);
        physicianPage.save.submit();


    }

    @And("ilk hastanin tum bilgilerinin gorunur oldugunu dogrula")
    public void ilkHastaninTumBilgilerininGorunurOldugunuDogrula() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("US1011.ilkHasta.size() = " + physicianPage.ilkHasta.size());
        for (int i = 0; i < physicianPage.ilkHasta.size(); i++) {
            assertTrue(physicianPage.ilkHasta.get(i).isDisplayed());
        }

    }

    @Given("Id Start DateTime End DateTime Status Physician Patient  bilgilerinin gorunur olgugunu dogrula")
    public void ıdStartDateTimeEndDateTimeStatusPhysicianPatientBilgilerininGorunurOlgugunuDogrula() {
        System.out.println("US1011.ilkHasta.size() = " + physicianPage.ilkHasta.size());
        assertTrue(physicianPage.ilkHasta.get(0).isDisplayed());
        assertTrue(physicianPage.ilkHasta.get(1).isDisplayed());
        assertTrue(physicianPage.ilkHasta.get(2).isDisplayed());
        assertTrue(physicianPage.ilkHasta.get(3).isDisplayed());
        assertTrue(physicianPage.ilkHasta.get(10).isDisplayed());
        assertTrue(physicianPage.ilkHasta.get(11).isDisplayed());
    }

    @And("Anamnesis Treatment Diagnosis bolumunu temizle")
    public void anamnesisTreatmentDiagnosisBolumunuTemizle() {
        physicianPage.anamnesis.clear();
        physicianPage.treatment.clear();
        physicianPage.diagnosis.clear();
    }

    @And("This field is required ifadelerinin goruldugunu dogrula")
    public void thisFieldIsRequiredIfadelerininGoruldugunuDogrula() {
        assertTrue(physicianPage.failYazisi.isDisplayed());
    }


    @Given("Prescription Description bolumunu temizle")
    public void prescriptionDescriptionBolumunuTemizle() {
        physicianPage.prescription.clear();
        physicianPage.description.clear();
    }

    @Given("Status kismini tikla PENDING secimini yap")
    public void statusKisminiTiklaPENDINGSeciminiYap() {
        Select select = new Select(physicianPage.status);
        select.selectByIndex(1);
    }


    @And("Statusun PENDING oldugunu dogrula")
    public void statusunPENDINGOldugunuDogrula() {
        assertEquals("PENDING", physicianPage.pending.getText());

    }

    @And("Status kismini tikla COMPLETED secimini yap")
    public void statusKisminiTiklaCOMPLETEDSeciminiYap() {
        Select select = new Select(physicianPage.status);
        select.selectByIndex(2);
    }

    @And("Statusun COMPLETED oldugunu dogrula")
    public void statusunCOMPLETEDOldugunuDogrula() {
        assertEquals("COMPLETED", physicianPage.completed.getText());
    }

    @And("Status kismini tikla CANCELLED secimini yap")
    public void statusKisminiTiklaCANCELLEDSeciminiYap() {
        Select select = new Select(physicianPage.status);
        select.selectByIndex(3);
    }

    @And("Statusun CANCELLED oldugunu dogrula")
    public void statusunCANCELLEDOldugunuDogrula() {
        assertEquals("CANCELLED", physicianPage.canceled.getText());
    }

    @And("Sayfayi kapat")
    public void sayfayiKapat() {
        Driver.closeDriver();

    }

    @And("ucuncu hasta icin Edit butonuna tikla")
    public void ucuncuHastaIcinEditButonunaTikla() throws InterruptedException {
        Thread.sleep(5000);
        physicianPage.ucuncuHastaEdit.click();

    }

    @And("ikinci hasta icin Edit butonuna tikla")
    public void ikinciHastaIcinEditButonunaTikla() throws InterruptedException {
        Thread.sleep(5000);
        physicianPage.ikinciHastaEdit.click();
    }

    //US017
    AdminPage adminPage = new AdminPage();
    @And("ItemTitles kismina tikla")
    public void ıtemtitlesKisminaTikla() {
        adminPage.itemTitels.click();

    }

    @And("TestItem kismina tikla Test Items yazisisin gorunur oldugunu dogrula")
    public void testıtemKisminaTiklaTestItemsYazisisinGorunurOldugunuDogrula() {
        adminPage.testItem.click();
        assertTrue(adminPage.testItemYazisi.isDisplayed());
    }

    @And("Create a new Test Item butonuna tikla Create or edit a Test Item yazisinin gorunur oldugunu test et")
    public void createANewTestItemButonunaTiklaCreateOrEditATestItemYazisininGorunurOldugunuTestEt() {
        adminPage.createAnewTestItem.click();
        assertTrue(adminPage.creataOrEditATestItemYazisi.isDisplayed());

    }


    @And("Name Description Price Default Min Value Default Max Value alanlarini doldur")
    public void nameDescriptionPriceDefaultMinValueDefaultMaxValueAlanlariniDoldur() {

        actions.click(adminPage.name).sendKeys(ConfigurationReader.getProperty("name"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("description"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("price"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("defaultMinValue"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("defaultMaxValue")).perform();
    }

    @And("Item Save Butonuna tikla")
    public void ıtemSaveButonunaTikla() {
        adminPage.saveItem.submit();
    }

    @And("Son sayfa ogesine tikla")
    public void sonSayfaOgesineTikla() {
        waitFor(5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement sonSayfa = adminPage.sonSayfa;
        jse.executeScript("arguments[0].click();", sonSayfa);
        //sonSayfa.submit();


    }

    @And("Olusturulan degerlerin Test Items sayfasinda gorunur oldugunu dogrula")
    public void olusturulanDegerlerinTestItemsSayfasindaGorunurOldugunuDogrula() {

        waitFor(5);

        System.out.println(adminPage.tumItemBilgileri.get(1).getText());
        assertEquals("Deger", adminPage.tumItemBilgileri.get(1).getText());
        assertEquals("idrar", adminPage.tumItemBilgileri.get(2).getText());
        assertEquals("200",adminPage.tumItemBilgileri.get(3).getText());
        assertEquals("15", adminPage.tumItemBilgileri.get(4).getText());
        assertEquals("20", adminPage.tumItemBilgileri.get(5).getText());


    }


    @And("Name,Description,Price,Default Min. Value ,Default Max. Value Created Date alanlarini doldur")
    public void nameDescriptionPriceDefaultMinValueDefaultMaxValueCreatedDateAlanlariniDoldur() {
        assertTrue(adminPage.createdDate.isEnabled());
        actions.click(adminPage.name).sendKeys(ConfigurationReader.getProperty("name"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("description"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("price"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("defaultMinValue"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("defaultMaxValue"))
                .sendKeys(Keys.TAB).sendKeys("21").sendKeys(Keys.TAB).sendKeys("08").sendKeys(Keys.TAB).sendKeys("22")
                .sendKeys(Keys.TAB).sendKeys("00").sendKeys(Keys.TAB).sendKeys("20").perform();
    }

    @And("Olusturulan tarihin girilen tarihle ayni oldugunu dogrula")
    public void olusturulanTarihinGirilenTarihleAyniOldugunuDogrula() {
        waitFor(5);

        System.out.println("tarih = " + adminPage.tumItemBilgileri.get(6).getText());
        assertEquals(ConfigurationReader.getProperty("createdDate"), adminPage.tumItemBilgileri.get(6).getText());
    }


    @And("Son sayfanin ilk test item ogesi icin edit butonuna tikla")
    public void sonSayfaninIlkTestItemOgesiIcinEditButonunaTikla() {
        waitFor(5);
        adminPage.sonSayfaIlkItemEdit.click();

    }

    @And("Edit icin Name,Description,Price,Default Min. Value ,Default Max. Value Created Date alanlarini doldur")
    public void editIcinNameDescriptionPriceDefaultMinValueDefaultMaxValueCreatedDateAlanlariniDoldur() {
        adminPage.editName.clear();
        actions.click(adminPage.editName).sendKeys(ConfigurationReader.getProperty("editName"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("editDescription"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("editPrice"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("editDefaultMinValue"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("editDefaultMaxValue"))
                .sendKeys(Keys.TAB).sendKeys("22").sendKeys(Keys.TAB).sendKeys("08").sendKeys(Keys.TAB).sendKeys("22")
                .sendKeys(Keys.TAB).sendKeys("01").sendKeys(Keys.TAB).sendKeys("30").perform();

    }

    @And("Edit icin Save butonuna tikla")
    public void editIcinSaveButonunaTikla() {
        adminPage.editSave.submit();
    }

    @And("Ogelerin degistirildigini dogrula")
    public void ogelerinDegistirildiginiDogrula() {
        waitFor(3);
        assertEquals(ConfigurationReader.getProperty("editName"), adminPage.sonSayfaIlkElementBilgileri.get(1).getText());
        assertEquals(ConfigurationReader.getProperty("editDescription"), adminPage.sonSayfaIlkElementBilgileri.get(2).getText());
        assertEquals(ConfigurationReader.getProperty("editPrice"), adminPage.sonSayfaIlkElementBilgileri.get(3).getText());
        assertEquals(ConfigurationReader.getProperty("editDefaultMinValue"), adminPage.sonSayfaIlkElementBilgileri.get(4).getText());
        assertEquals(ConfigurationReader.getProperty("editDefaultMaxValue"), adminPage.sonSayfaIlkElementBilgileri.get(5).getText());
        assertEquals(ConfigurationReader.getProperty("editCreatedDate"), adminPage.sonSayfaIlkElementBilgileri.get(6).getText());

    }


    @And("Son sayfa ogesine tiklaa")
    public void sonSayfaOgesineTiklaa() {
        waitFor(5);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement sonSayfa = adminPage.sonSayfa;
        jse.executeScript("arguments[0].click();", sonSayfa);
        // sonSayfa.submit();


    }

    @And("Ucuncu Test Itemi icin View butonuna tikla")
    public void ucuncuTestItemiIcinViewButonunaTikla() {
        adminPage.ucuncuItemVİew.click();


    }


    @And("Test Itemin goruntulenebilir oldugunu dogrula")
    public void testIteminGoruntulenebilirOldugunuDogrula() {
        waitFor(1);
        String expectedData="Test Item [1403]";
        assertEquals(expectedData, adminPage.goruntulenenItem.getText());
    }


    @And("Bilgilerin goruntulenebilir oldugunu dogrula")
    public void bilgilerinGoruntulenebilirOldugunuDogrula() {
        assertEquals("Kan",adminPage.goruntulenenTumBilgiler.get(0).getText());
        assertEquals("Kan Sayımı",adminPage.goruntulenenTumBilgiler.get(1).getText());
        assertEquals("150",adminPage.goruntulenenTumBilgiler.get(2).getText());
        assertEquals("15",adminPage.goruntulenenTumBilgiler.get(3).getText());
        assertEquals("19",adminPage.goruntulenenTumBilgiler.get(4).getText());
        assertEquals("05/12/21 01:24",adminPage.goruntulenenTumBilgiler.get(5).getText());

    }

    @And("silmek icin Name Description Price Default Min Value Default Max Value alanlarini doldur")
    public void silmekIcinNameDescriptionPriceDefaultMinValueDefaultMaxValueAlanlariniDoldur() {
        actions.click(adminPage.name).sendKeys(ConfigurationReader.getProperty("silName"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("silDescription"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("silPrice"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("silDefaultMinValue"))
                .sendKeys(Keys.TAB).sendKeys(ConfigurationReader.getProperty("silDefaultMaxValue")).perform();

    }

    @And("silinecek oge icin delete butonuna tiklar")
    public void silinecekOgeIcinDeleteButonunaTiklar() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement silinecekOgeDeleteButon = adminPage.silinecekOgeDeleteButon;
        jse.executeScript("arguments[0].click();", silinecekOgeDeleteButon);

    }

    @And("ikinci delete butonuna tiklar")
    public void ikinciDeleteButonunaTiklar() {
        adminPage.ikinciDelete.click();
    }

    @And("olusturulan ogelerin silingi dogrulayin")
    public void olusturulanOgelerinSilingiDogrulayin() {

        for (int i = 0; i <adminPage.idList.size();i++){
            if (!adminPage.idList.get(i).getText().equals(ConfigurationReader.getProperty("id"))) {
                System.out.println("item silinmiştir.");
            }
        }


    }



}



