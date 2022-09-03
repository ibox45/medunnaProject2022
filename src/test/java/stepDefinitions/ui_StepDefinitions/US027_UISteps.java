package stepDefinitions.ui_StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import pages.MessagesPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US027_UISteps {
    Actions actions = new Actions(Driver.getDriver());
    AdminPage adminPage = new AdminPage();
    RegistrationPage registrationPage = new RegistrationPage();
    MessagesPage messagesPage = new MessagesPage();
    Faker faker = new Faker();
    String newMessageId;
    String deleteID;

    @Given("Admin Kullanici anasayfaya gider")
    public void admin_kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));

    }

    @When("Admin kullanici anasayfadaki account-menu ye tiklar")
    public void adminKullaniciAnasayfadakiAccountMenuYeTiklar() {

        registrationPage.accountMenuButonu.click();

    }

    @And("Admin kullanici sign in butonuna tiklar")
    public void adminKullaniciSignInButonunaTiklar() {


        registrationPage.loginItem.click();

    }

    @Then("Admin kullanici gecerli username ve password girisi yapar")
    public void adminKullaniciGecerliUsernameVePasswordGirisiYapar() {
        registrationPage.userNameKutusu.sendKeys(ConfigurationReader.getProperty("adminUsername"));
        ReusableMethods.waitFor(1);
        registrationPage.password.sendKeys(ConfigurationReader.getProperty("password"));


    }

    @And("Admin kullanici ikinci sign in butonuna tiklar")
    public void adminKullaniciIkinciSignInButonunaTiklar() {


        registrationPage.SignInButton.click();

    }


    @And("Admin kullanici  sagustteki menuden  Items&Titles a tiklar")
    public void adminKullaniciSagusttekiMenudenItemsTitlesATiklar() {

        adminPage.itemsTitles.click();

    }

    @Then("Kullanici acilan dropdown menuden Messages satirina tiklar")
    public void kullanici_acilan_dropdown_menuden_messages_satirina_tiklar() {
        ReusableMethods.waitForClickablility(adminPage.messagesDropdown, 2);
        adminPage.messagesDropdown.click();

    }

    @Given("Kullanici acilan sayfadaki Message basliginin oldugunu gorur")
    public void kullanici_acilan_sayfadaki_message_basliginin_oldugunu_gorur() {
        messagesPage.messageBaslik.isDisplayed();

    }

    @Given("Kullanici acilan sayfadaki Name basliginin oldugunu gorur")
    public void kullanici_acilan_sayfadaki_name_basliginin_oldugunu_gorur() {
        messagesPage.nameBaslik.isDisplayed();

    }

    @Given("Kullanici acilan sayfadaki Email basliginin oldugunu gorur")
    public void kullanici_acilan_sayfadaki_email_basliginin_oldugunu_gorur() {

        messagesPage.emailBaslik.isDisplayed();
    }


    //US027_TC02
    @Given("Kullanici acilan sayfada  Create a new Message butonunu gorur ve tiklar")
    public void kullanici_acilan_sayfada_create_a_new_message_butonunu_gorur_ve_tiklar() {
        messagesPage.createNewMessage.click();

    }

    @When("Kullanici Name Email Subject Message  bolumlerine ifade girisi yapar save butonuna tiklar")
    public void kullanici_name_email_subject_message_bolumlerine_ifade_girisi_yapar_save_butonuna_tiklar() {
        ReusableMethods.waitForVisibility(messagesPage.createName, 2);
        actions.click(messagesPage.createName)
                .sendKeys(faker.name().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.book().title()).sendKeys(Keys.TAB)
                .sendKeys(faker.shakespeare().romeoAndJulietQuote()).perform();
        ReusableMethods.waitFor(2);
    }

    @Then("Save butonuna tiklanir ve ekrana gelen ID goruntulenip kaydedilir")
    public void save_butonuna_tiklanir_ve_ekrana_gelen_id_goruntulenip_kaydedilir() {

        messagesPage.createSave.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForClickablility(messagesPage.createNewMessageOkAndId, 5);
        System.out.println("olusturulanYeniMesajinOnayTexti = " + messagesPage.createNewMessageOkAndId.getText());
        newMessageId = messagesPage.createNewMessageOkAndId.getText();
        newMessageId = newMessageId.replaceAll("[^0-9_-]", "");
        System.out.println(newMessageId);
    }

    @Then("ID ye tiklayarak siralama degistirip olusturulan son mesajin sayfaya gelmesi saglanir")
    public void id_ye_tiklayarak_siralama_degistirip_olusturulan_son_mesajin_sayfaya_gelmesi_saglanir() {
        messagesPage.idButton.click();
        ReusableMethods.waitForVisibility(messagesPage.newMessageInId, 2);
        System.out.println("olusturulanMesajID'si = " + messagesPage.newMessageInId.getText());

        //ReusableMethods.waitFor(3);


    }

    @Then("Sayfadaki View butonu ile olusturuldugunu gorur")
    public void sayfadaki_view_butonu_ile_olusturuldugunu_gorur() {
        messagesPage.viewButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(messagesPage.viewName, 4);
        String ilkName = messagesPage.viewName.getText();
        System.out.println("ilkName = " + ilkName);

        String ilkEmail = messagesPage.viewEmail.getText();
        System.out.println("ilkEmail = " + ilkEmail);

        String ilkSubject = messagesPage.viewSubject.getText();
        System.out.println("ilkSubject = " + ilkSubject);

        String ilkMessage = messagesPage.viewMessage.getText();
        System.out.println("ilkMessage = " + ilkMessage);

    }

    @Then("Edit butonuna tiklayarak olusturulan mesajin iceriginin degistirilebildigini gorur")
    public void edit_butonuna_tiklayarak_olusturulan_mesajin_iceriginin_degistirilebildigini_gorur() {
        messagesPage.editButton.click();

        ReusableMethods.waitForVisibility(messagesPage.editName, 5);
        messagesPage.editName.sendKeys(faker.backToTheFuture().character());
        // messagesPage.editEmail.sendKeys(faker.internet().emailAddress());
        messagesPage.editSubject.sendKeys(faker.book().publisher());
        messagesPage.editMessage.sendKeys(faker.backToTheFuture().quote());
        messagesPage.editSave.click();
        ReusableMethods.waitFor(1);
        messagesPage.idButton.click();
        ReusableMethods.waitForClickablility(messagesPage.viewButton, 4);
        messagesPage.viewButton.click();

        ReusableMethods.waitFor(1);
        System.out.println("degistirilenName = " + messagesPage.viewName.getText());
        // System.out.println("degistirilenEmail = " + messagesPage.viewEmail.getText());
        System.out.println("degistirilenSubject = " + messagesPage.viewSubject.getText());
        System.out.println("degistirilenMessage = " + messagesPage.viewMessage.getText());
        messagesPage.back.click();
        ReusableMethods.waitFor(1);

    }

    @Then("Delete butonunu kullanarak olusturulan mesajin guncel listede olmadigini gorur")
    public void delete_butonunu_kullanarak_olusturulan_mesajin_guncel_listede_olmadigini_gorur() {
        messagesPage.idButton.click();
        messagesPage.deleteId.getText().equals(newMessageId);
        messagesPage.deleteButton.click();

        ReusableMethods.waitFor(2);
        deleteID=messagesPage.denemeDeleteMesaj.getText();
        deleteID=deleteID.replaceAll("[^0-9_-]", "");
        System.out.println("deleteID = " + deleteID);
        messagesPage.deleteMessage.click();


    }

    @And("Sayfa kapan")
    public void sayfaKapan() {
        Driver.closeDriver();
    }


}
