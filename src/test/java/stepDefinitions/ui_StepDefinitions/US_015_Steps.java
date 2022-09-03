package stepDefinitions.ui_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.WriteToTxt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US_015_Steps {

     AdminPage page = new AdminPage();

    @Then("Items&Titles butonuna tikla")
    public void ıtems_titles_butonuna_tikla() {
        page.itemsAndTitlesButton.click();
    }
    @Then("acilan dropdownda Patient'i sec")
    public void acilan_dropdownda_patient_i_sec() {
    page.patientButton.click();
    }
    @Then("Patient listesinin acildigini dogrula")
    public void patient_listesinin_acildigini_dogrula() {
        Assert.assertTrue(page.patientList.isDisplayed());
    }
    @Then("Create a new Patient butonuna tikla")
    public void create_a_new_patient_butonuna_tikla() {
    page.createNewPatientButton.click();
    }
    @Then("Gerekli textboxlari doldur")
    public void gerekli_textboxlari_doldur() {
        WebElement genderDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-gender']"));
        WebElement bloodDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-bloodGroup']"));
        WebElement userDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-user']"));
        WebElement countryDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-country']"));


        Faker faker1 = new Faker();

    page.firstNameTextBox.sendKeys(faker1.name().firstName());
    page.lastNameTextBox.sendKeys(faker1.name().lastName());

        Actions actions = new Actions(Driver.getDriver());
        actions.click(page.birthDateTextBox)
                .sendKeys("2009")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .perform();



    page.emailTextBox.sendKeys(faker1.internet().emailAddress());
    page.phoneTextBox.sendKeys(faker1.instance().number().digits(10));

        Select genderSelect = new Select(genderDropDown);
        genderSelect.selectByIndex(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", page.genderTextBox);

        Select bloodSelect = new Select(bloodDropDown);
        bloodSelect.selectByIndex(6);
        Select userSelect = new Select(userDropDown);
        userSelect.selectByVisibleText("yamangokhnan");
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByIndex(1);

        WriteToTxt.writePatientInfo(page.firstNameTextBox.getAttribute("value"));
        WriteToTxt.writePatientInfo(page.lastNameTextBox.getAttribute("value"));
        WriteToTxt.writePatientInfo(page.emailTextBox.getAttribute("value"));
        WriteToTxt.writePatientInfo(page.phoneTextBox.getAttribute("value"));
    }

    @Then("Save butonuna tikla")
    public void save_butonuna_tikla() {
    page.saveButton.click();
    }
    @Then("New Patient Created basari mesajini dogrula")
    public void new_patient_created_basari_mesajini_dogrula() {
    Assert.assertTrue(page.basariMesaji.isDisplayed());
    String id = page.basariMesaji.getText();
        System.out.println(id);
    String idMid = id.replaceAll("\\D", "");
        System.out.println(idMid);
    String idEnd = idMid.trim();
        System.out.println(idEnd);
    WriteToTxt.writePatientInfo(idEnd);
    }


    @And("Hastalarin bilgilerinin gorundugunu dogrular")
    public void hastalarinBilgilerininGorundugunuDogrular() {
        Assert.assertTrue(page.seeID.isDisplayed());
        Assert.assertTrue(page.seeSSN.isDisplayed());
        Assert.assertTrue(page.seeFirstname.isDisplayed());
        Assert.assertTrue(page.seeLastname.isDisplayed());
        Assert.assertTrue(page.seeBirhtDate.isDisplayed());
        Assert.assertTrue(page.seePhone.isDisplayed());
        Assert.assertTrue(page.seeEmail.isDisplayed());
        Assert.assertTrue(page.seeGender.isDisplayed());
        Assert.assertTrue(page.seeBloodGroup.isDisplayed());
        Assert.assertTrue(page.seeAddress.isDisplayed());
        Assert.assertTrue(page.seeDescription.isDisplayed());
        Assert.assertTrue(page.seeCreatedDate.isDisplayed());
        Assert.assertTrue(page.seeUser.isDisplayed());
        Assert.assertTrue(page.seeCountry.isDisplayed());
        Assert.assertTrue(page.seeStateCity.isDisplayed());
    }

    @And("patient listesinde olusturdugu hastanin bulundugu sayfaya gider")
    public void patientListesindeOlusturduguHastaninBulunduguSayfayaGider() {
        Driver.getDriver().get("https://www.medunna.com/patient?page=230&sort=id,asc");

    }

    @And("olusturulan hasta bilgilerini editler")
    public void olusturulanHastaBilgileriniEditler() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", page.editHasta);
        js.executeScript("arguments[0].scrollIntoView();", page.editButton);
        page.editButton.click();



        WebElement genderDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-gender']"));
        WebElement bloodDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-bloodGroup']"));
        WebElement userDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-user']"));
        WebElement countryDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-country']"));


        Faker faker1 = new Faker();

        page.firstNameTextBox.clear();
        page.firstNameTextBox.sendKeys(faker1.name().firstName());
        page.lastNameTextBox.clear();
        page.lastNameTextBox.sendKeys(faker1.name().lastName());

        LocalDate localDate=LocalDate.now();
        LocalDate duzenlenmisLocalDate = localDate.minusDays(5).minusMonths(6).minusYears(22);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDate = duzenlenmisLocalDate.format(duzenliDateStart);
        page.birthDateTextBox.sendKeys(checkInDate);


        page.emailTextBox.clear();
        page.emailTextBox.sendKeys(faker1.internet().emailAddress());
        page.phoneTextBox.clear();
        page.phoneTextBox.sendKeys(faker1.instance().number().digits(10));

        Select genderSelect = new Select(genderDropDown);
        genderSelect.selectByIndex(1);
        Select bloodSelect = new Select(bloodDropDown);
        bloodSelect.selectByIndex(7);

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].scrollIntoView();", page.seeAddress);

        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByIndex(1);

        page.saveButton.click();
    }

    @And("bilgilerin guncellenebildigini dogrula")
    public void bilgilerinGuncellenebildiginiDogrula() {
        Assert.assertTrue(page.basariMesaji.isDisplayed());
    }

    @Given("acilan dropdownda Appointment'i sec")
    public void acilanDropdowndaAppointmentISec() {
        page.appointment.click();
    }

    @Then("Appointment listesinin acildigini dogrula")
    public void appointmentListesininAcildiginiDogrula() {
        Assert.assertTrue(page.appointmentList.isDisplayed());
    }

    @And("Create a new Appointment butonuna tikla")
    public void createANewAppointmentButonunaTikla() {
        page.createNewAppointment.click();
    }

    @And("Gerekli olan textboxlari doldur")
    public void gerekliOlanTextboxlariDoldur() {

        Actions actions = new Actions(Driver.getDriver());
        actions.click(page.appointmentEndDate)
                .sendKeys("3109")
                .sendKeys(Keys.TAB)
                .sendKeys("1213")
                .perform();


        WebElement statusDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='appointment-status']"));
        Select statusSelect = new Select(statusDropDown);
        statusSelect.selectByIndex(1);

        JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
        js3.executeScript("arguments[0].scrollIntoView();", page.treatment);

        ReusableMethods.waitFor(2);

        WebElement physicianDropDown = Driver.getDriver().findElement(By.xpath("(//select[@id='appointment-physician'])[1]"));
        Select physicianSelect = new Select(physicianDropDown);
        physicianSelect.selectByVisibleText("10520:Abuzer Kömürcü");

        WebElement patientDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='appointment-patient']"));
        Select patientSelect = new Select(patientDropDown);
        patientSelect.selectByIndex(11);

    }

    @And("save butonuna tikla")
    public void saveButonunaTikla() {
        page.saveButton.click();
    }

    @And("A new Appointment is created basari mesajini goruldugunu dogrular")
    public void aNewAppointmentIsCreatedBasariMesajiniGoruldugunuDogrular() {
        Assert.assertTrue(page.basariMesaji.isDisplayed());
    }


    @And("bir hastanin delete butonuna tiklar")
    public void birHastaninDeleteButonunaTiklar() {
        page.silincekHasta.click();
    }

    @And("Gelen pop-up'da delete butonuna tiklar")
    public void gelenPopUpDaDeleteButonunaTiklar() {
        page.deleteButton.click();
    }

    @And("A Patient is deleted basari mesajini gorur")
    public void aPatientIsDeletedBasariMesajiniGorur() {
        Assert.assertTrue(page.basariMesaji.isDisplayed());
    }

    @And("ilk hastanin edit butonuna tiklar")
    public void ilkHastaninEditButonunaTiklar() {
        JavascriptExecutor js4 = (JavascriptExecutor) Driver.getDriver();
        js4.executeScript("arguments[0].scrollIntoView();", page.ilkHastaEdit);
        page.ilkHastaEdit.click();
    }

    @And("Country kismini bos birakir")
    public void countryKisminiBosBirakir() {
        JavascriptExecutor js5 = (JavascriptExecutor) Driver.getDriver();
        js5.executeScript("arguments[0].scrollIntoView();", page.seeAddress);
        WebElement countryDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-country']"));
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByIndex(0);
    }

    @And("Hata mesaji alir")
    public void hataMesajiAlir() {
        Assert.assertTrue(page.basariMesaji.isDisplayed());
    }

    @And("Country kismini US secer")
    public void countryKisminiUSSecer() {
        JavascriptExecutor js6 = (JavascriptExecutor) Driver.getDriver();

        js6.executeScript("arguments[0].scrollIntoView();", page.seeDescription);
        ReusableMethods.waitFor(2);
        WebElement countryDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-country']"));
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByVisibleText("US");
    }

    @And("basari mesajini dogrular")
    public void basariMesajiniDogrular() {
        Assert.assertTrue(page.basariMesaji.isDisplayed());
    }

    @And("kendi olusturmadigi hastayi siler")
    public void kendiOlusturmadigiHastayiSiler() {
        JavascriptExecutor js7 = (JavascriptExecutor) Driver.getDriver();

        js7.executeScript("arguments[0].scrollIntoView();", page.ilkHastaSilme);
        page.ilkHastaSilme.click();
    }

    @And("hata mesajini gorur")
    public void hataMesajiniGorur() {
        Assert.assertTrue(page.hataMesaji.isDisplayed());
    }

    @And("Gerekli textboxlari doldurur")
    public void gerekliTextboxlariDoldurur() {
        WebElement genderDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-gender']"));
        WebElement bloodDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-bloodGroup']"));
        WebElement userDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-user']"));
        WebElement countryDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='patient-country']"));


        Faker faker1 = new Faker();

        page.firstNameTextBox.sendKeys(faker1.name().firstName());
        page.lastNameTextBox.sendKeys(faker1.name().lastName());

        Actions actions = new Actions(Driver.getDriver());
        actions.click(page.birthDateTextBox)
                .sendKeys("2009")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .perform();



        page.emailTextBox.sendKeys(faker1.internet().emailAddress());
        page.phoneTextBox.sendKeys(faker1.instance().number().digits(10));

        Select genderSelect = new Select(genderDropDown);
        genderSelect.selectByIndex(1);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", page.genderTextBox);

        Select bloodSelect = new Select(bloodDropDown);
        bloodSelect.selectByIndex(6);
        Select userSelect = new Select(userDropDown);
        userSelect.selectByVisibleText("yamangokhnan");
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByIndex(1);
    }
}


