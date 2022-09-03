package stepDefinitions.ui_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_018_Steps {
    AdminPage adminpage = new AdminPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    Select select;



    @Given("Kullanici {string} adresine gider")
    public void kullanici_www_medunna_com_adresine_gider(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));

    }
    @Then("Ana sayfada oldunduğu {string} texti ile dogrulanir")
    public void ana_sayfada_oldunduğu_texti_ile_dogrulanir(String string) {

        Assert.assertTrue(adminpage.welcomeMedunnaHeader.isDisplayed());

    }
    @Then("Kullanici giris icin CONTACT tuşunun yanındaki kullanici giris butonuna tiklar")
    public void kullanici_giris_icin_contact_tuşunun_yanındaki_kullanici_giris_butonuna_tiklar() {
        adminpage.accountMenuButton.click();
    }
    @Then("Admin acilan DDM menuden Sign In e tiklar")
    public void admin_acilan_ddm_menuden_sign_in_e_tiklar() {
        adminpage.signInButton.click();
    }
    @Then("Admin kendi {string} ve {string} girip Sign in butonuna tiklar")
    public void admin_kendi_ve_girip_sign_in_butonuna_tiklar(String string, String string2) {
        adminpage.userNameTextBox.sendKeys(ConfigurationReader.getProperty("adminUsername"));
        adminpage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));
        adminpage.signInEnterButton.click();

    }
    @Then("Admin sag ust kosede kendi adini gorerek basariyla giris yaptigini  gorur")
    public void admin_sag_ust_kosede_kendi_adini_gorerek_basariyla_giris_yaptigini_gorur() {
        Assert.assertTrue(adminpage.adminVerifyEnterVisible.isDisplayed());
    }
    @Then("Admin items&Titles menusu gorur")
    public void admin_items_titles_menusu_gorur() {
        Assert.assertTrue(adminpage.itemTitlesHeader.isDisplayed());
    }
    @Then("Admin items&Titles menusune tiklar")
    public void admin_items_titles_menusune_tiklar() {

        adminpage.itemTitlesHeader.click();
    }
    @Then("Admin acilan DDM'den Physician'a tiklar")
    public void admin_acilan_ddm_den_physician_a_tiklar() {
        adminpage.physicianTitle.click();
        ReusableMethods.waitForPageToLoad(10);
    }
    @Then("Admin edit'e  tiklar")
    public void admin_edit_e_tiklar() {

        js.executeScript("arguments[0].scrollIntoView(true);",adminpage.pageNumber24);
        js.executeScript("arguments[0].click();",adminpage.pageNumber24);
        /*js.executeScript("arguments[0].scrollIntoView(true);",adminpage.editDoctorEmre);
        js.executeScript("arguments[0].click();",adminpage.editDoctorEmre);*/

    }

    @Then("Admin butun doktorlarin bilgilerini gorur")
    public void admin_butun_doktorlarin_bilgilerini_gorur() {
        Assert.assertTrue(adminpage.physicianTableHeaderText.isDisplayed());
    }
    @Then("Admin tarayiciyi kapatir")
    public void admin_tarayiciyi_kapatir() {
        Driver.closeDriver();


    }
    //__________________________________________| Scenario: TC_002 Admin, SSN kimliğine göre kayıtlı bir kişiyi seçebilir/arayabilir.|_________________________________________
    @Then("Admin Create a new Physician'a tiklar")
    public void admin_create_a_new_physician_a_tiklar() {
        adminpage.createNewPhysicianButton.click();
    }
    @Then("Admin SSN Box'a kayitli bir kisinin SSN'nini girer")
    public void admin_ssn_box_a_kayitli_bir_kisinin_ssn_nini_girer() {
        adminpage.ssnTextBox.sendKeys(ConfigurationReader.getProperty("doktorSSN"));
    }
    @Then("Admin Search User butonuna tiklar")
    public void admin_search_user_butonuna_tiklar() {
        adminpage.searchUserButton.click();

    }
    @Then("Admin Use Search butonuna click yapar.")
    public void admin_butonuna_click_yapar() {
        adminpage.useSearchCheckBox.click();

    }
    @Then("Admin sol ust kosede User found with search SSN popup'ini gorur")
    public void admin_sol_ust_kosede_user_found_with_search_ssn_popup_ini_gorur() {
        ReusableMethods.waitForVisibility(adminpage.popUpAlert,10);
        Assert.assertTrue(adminpage.popUpAlert.isDisplayed());

    }
    @Then("Admin sayfayi kapatir.")
    public void admin_sayfayi_kapatir() {
        Driver.closeDriver();

    }
    //__________________________________________|   Scenario: TC_003 Admin EDİT butonu üzerinden doktorların bilgilerini düzenleyebilir.(firstname, lastname, birthdate, specialty, profil fotoğrafı, exam fee,doktor seçme)|_________________________________________

    @Then("Admin First Name alanina isim girer.")
    public void admin_first_name_alanina_isim_girer() {
        adminpage.createNewPhysicianButton.click();
        adminpage.ssnTextBox.sendKeys(ConfigurationReader.getProperty("doktorSSN"));
        adminpage.searchUserButton.click();
        adminpage.useSearchCheckBox.click();
        ReusableMethods.waitFor(1);
        adminpage.firstNameTextBoxEG.clear();
        ReusableMethods.waitFor(1);
        String fakeName = faker.name().firstName();
        adminpage.firstNameTextBoxEG.sendKeys(fakeName);

    }
    @Then("Admin Last Name alanina soyisim girer")
    public void admin_last_name_alanina_soyisim_girer() {
        adminpage.lastNameTextBoxEG.clear();
        ReusableMethods.waitFor(1);
        String fakeLastName = faker.name().lastName();
        adminpage.lastNameTextBoxEG.sendKeys(fakeLastName);

    }
    @Then("Admin Birth Date alanindan dogum tarihi secer")
    public void admin_birth_date_alanindan_dogum_tarihi_secer() {
        adminpage.birthDateTextBoxEG.clear();
        //ReusableMethods.waitFor(1);
        adminpage.birthDateTextBoxEG.sendKeys(ConfigurationReader.getProperty("birthDate"));
    }
    @Then("Admin Phone alanina telefon bilgisi girer")
    public void admin_phone_alanina_telefon_bilgisi_girer() {
        adminpage.phoneNumber.sendKeys(ConfigurationReader.getProperty("phone"));

    }
    @Then("Admin address alanina adres bilgisi girer.")
    public void admin_address_alanina_adres_bilgisi_girer() {
        adminpage.addressTextBox.sendKeys(ConfigurationReader.getProperty("doctorAddress"));

    }
    @Then("Admin Gender alanina cinsiyet girer.")
    public void admin_gender_alanina_cinsiyet_girer() {
        adminpage.ddmGender.sendKeys(ConfigurationReader.getProperty("gender"));

    }
    @Then("Admin Speciality alanina uzmanlik alani girer.")
    public void admin_speciality_alanina_uzmanlik_alani_girer() {
        adminpage.specialityDdm.sendKeys(ConfigurationReader.getProperty("speciality"));

    }
    @Then("Admin Blood Group alanina kan grubu girer.")
    public void admin_blood_group_alanina_kan_grubu_girer() {
        adminpage.bloodGroup.sendKeys(ConfigurationReader.getProperty("bloodGroup"));

    }
    @Then("Admin Description alanina veri girer.")
    public void admin_description_alanina_veri_girer() {
        adminpage.descriptionTextBox.sendKeys(ConfigurationReader.getProperty("descriptionText"));

    }
    @Then("Admin Image alanından Dosya Seç'e basarak bir fotoğraf yükler.")
    public void admin_Image_alanindan_dosya_sec_e_basarak_bir_fotograf_yukler() {
       /*js.executeScript("arguments[0].click();", adminpage.dosyaSec);
        adminpage.dosyaSec.sendKeys("pathWay");*/
        //Driver.wait(2);
        String path = System.getProperty("user.home") + "\\doktor.jpg";
        adminpage.dosyaSec.sendKeys(path);
       /* js.executeScript("arguments[0].scrollIntoView(true)");
        Driver.clickWithJS(adminpage.dosyaSec);*/
    }
    @Then("Admin  Exam Fee alanina doktor ucreti girer.")
    public void admin_exam_fee_alanina_doktor_ucreti_girer() {
        js.executeScript("window.scrollBy(0,400)");
        adminpage.examFeeButton.sendKeys(ConfigurationReader.getProperty("examFee"));

    }
    @Then("Admin User alanindan kullanici secer.")
    public void admin_user_alanindan_kullanici_secer() {
        adminpage.userChooseButton.sendKeys(ConfigurationReader.getProperty("userChoose"));

    }
    @Then("Admin Country alanindan ulke secer.")
    public void admin_country_alanindan_ulke_secer() {
        adminpage.countryButton.sendKeys(ConfigurationReader.getProperty("country"));

    }
    @Then("Admin {string} alanindan sehir secer.")
    public void admin_state_city_alanindan_sehir_secer(String city) {
        js.executeScript("arguments[0].click()",adminpage.cityButton);
    }
    @Then("Admin Save butonuna tiklar.")
    public void admin_save_butonuna_tiklar() {
        js.executeScript("arguments[0].click();",adminpage.saveButtonEG);

    }
    @Then("Admin A Physician is updated mesajini goruntuler.")
    public void admin_a_physician_is_updated_mesajini_goruntuler() {

    }
    //__________________________________________|    Scenario:TC_004 Admin mevcut dokorları silebilir. |____________________________________________


    @Then("Admin acilan sayfanın altındaki sayfa numalari yazisini gorutuleyerek doktorlar listesine gittigini dogrular")
    public void admin_acilan_sayfanın_altındaki_sayfa_numalari_yazisini_gorutuleyerek_doktorlar_listesine_gittigini_dogrular() {
        ReusableMethods.waitForClickablility(adminpage.showingItemsTitle,60);
        Assert.assertTrue(adminpage.showingItemsTitle.isDisplayed());
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click();",adminpage.pageNumber24);
        ReusableMethods.waitForVisibility(adminpage.pageNumber24,30);


    }
    @Then("Admin silmek istedigi doktorun yanindaki {string} butonuna tiklar")
    public void admin_silmek_istedigi_doktorun_yanindaki_butonuna_tiklar(String string) {
        ReusableMethods.waitFor(5);
        adminpage.deletePhysicianButton.click();

    }
    @Then("Admin doktoru silindigine dair bir pop-up uyarisi alir")
    public void admin_doktoru_silindigine_dair_bir_pop_up_uyarisi_alir() {
        WebElement deleteMesaji = Driver.getDriver().findElement(By.xpath("//button[@id='jhi-confirm-delete-physician']"));
        js.executeScript("arguments[0].click()",deleteMesaji);
    }


}

