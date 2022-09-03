package stepDefinitions.ui_StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminPage;
import pages.MedunnaHomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US_019_Steps {

    AdminPage adminPage=new AdminPage();
    MedunnaHomePage homePage=new MedunnaHomePage();

    @Given("kullanıcı medunna sayfasına gider")
    public void kullanıcıMedunnaSayfasınaGider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }

    @Given("kullanıcı, kullanıcı logosuna tıklar")
    public void kullanıcı_kullanıcı_logosuna_tıklar() {
        homePage.accountMenuButton2.click();

    }
    @Then("kullanıcı sign in butonuna tıklar")
    public void kullanıcı_sign_in_butonuna_tıklar() {
        homePage.signInButton.click();

    }
    @Then("kullanıcı \\(admin) username, password girer ve giriş yapar")
    public void kullanıcı_admin_username_password_girer_ve_giriş_yapar() {
        homePage.usernameTextBox.sendKeys("maguire");
        homePage.passwordTextBox.sendKeys("Ae123456.");
        homePage.signInButton2.click();

    }
    @Then("kullanıcı items & titles butonuna tıklar ve staff'ı seçer")
    public void kullanıcı_items_titles_butonuna_tıklar_ve_staff_ı_seçer() {

        adminPage.itemTitels.click();
        adminPage.ItemsandTitlesStaff.click();



    }
    @Then("kullanıcı create a new staff butonuna tıklar")
    public void kullanıcı_create_a_new_staff_butonuna_tıklar() {
        adminPage.CreateanewStaff.click();

    }
    @Then("kullanıcı kayıtlı staff'ın ssn numarasını girer")
    public void kullanıcı_kayıtlı_staff_ın_ssn_numarasını_girer() {
        adminPage.searchSSN.sendKeys("555-16-5555");

    }
    @Then("kullanıcı önce use search butonuna sonra search user butonuna tıklar")
    public void kullanıcı_önce_use_search_butonuna_sonra_search_user_butonuna_tıklar() throws InterruptedException {
        adminPage.useSSNSearch.click();
        adminPage.SearchUserButton.click();
        Thread.sleep(5000);



    }
    @Then("kullanıcı staff'ı görüntüler")
    public void kullanıcı_staff_ı_görüntüler() {


        String result=  adminPage.staffValue.getAttribute("value");
        if(result.equals("")){
            Assert.fail();
        }else{
            Assert.assertTrue(true);
        }


    }


    @Then("kullanıcı staff'ın tüm bilgilerini görüntüler")
    public void kullanıcıStaffInTümBilgileriniGörüntüler() {
        String result1=  adminPage.staffLastName.getAttribute("value");
        String result2=  adminPage.staffBirthDate.getAttribute("value");
        String result3=  adminPage.staffAdress.getAttribute("value");
        String result4=  adminPage.staffPhone.getAttribute("value");
        String result5=  adminPage.staffGender.getAttribute("value");
        String result6=  adminPage.staffBloodGroup.getAttribute("value");
        String result7=  adminPage.staffDescription.getAttribute("value");
        String result8=  adminPage.staffCStateId.getAttribute("value");
        String result9=  adminPage.staffCreatedDate.getAttribute("value");
        String result10=  adminPage.staffUserId.getAttribute("value");

        if(result1.equals("") || result2.equals("") || result3.equals(" ") || result4.equals("") || result5.equals("")
                || result6.equals("") || result7.equals(" ") || result8.equals("") || result9.equals("") || result10.equals("") ){
            Assert.fail();

        }else{
            Assert.assertTrue(true);
        }

    }



    @Then("kullanıcı stafflardan birini idye tıklayarak seçer")
    public void kullanıcıStafflardanBiriniIdyeTıklayarakSeçer() {

        adminPage.IlkStaffId.click();
        Assert.assertTrue(adminPage.BackButton.isDisplayed());
    }

    @Then("kullanıcı stafflardan birinin edit butonuna tıklar ve düzenler")
    public void kullanıcıStafflardanBirininEditButonunaTıklarVeDüzenler() {

        adminPage.IlkStaffEditButton.click();
        Assert.assertTrue(adminPage.BackButton.isDisplayed());

    }

    @Then("kullanıcı stafflardan birinin delete butonuna tıklar ve siler")
    public void kullanıcıStafflardanBirininDeleteButonunaTıklarVeSiler() throws InterruptedException {

        adminPage.staffDelete.click();
        Thread.sleep(5000);
        //adminPage.staffDelete2.click();

    }


}
