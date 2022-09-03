package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPage {
    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //US017 Selçuk

    @FindBy(xpath = "//li[@id=\"entity-menu\"]")
    public WebElement itemTitels;

    @FindBy(xpath = "(//a[@class=\"dropdown-item\"])[5]")
    public WebElement testItem;

    @FindBy(xpath = "//h2")
    public WebElement testItemYazisi;

    @FindBy(xpath = "//a[@id=\"jh-create-entity\"]")
    public WebElement createAnewTestItem;

    @FindBy(xpath = "//span[text()=\"Create or edit a Test Item\"]")
    public WebElement creataOrEditATestItemYazisi;

    @FindBy(xpath = "//input[@id=\"c-test-item-name\"]")
    public WebElement name;

    @FindBy(xpath = "//input[@name=\"description\"]")
    public WebElement descriptionItem;

    @FindBy(xpath = "//input[@name=\"price\"]")
    public WebElement price;

    @FindBy(xpath = "//input[@name=\"defaultValMin\"]")
    public WebElement defaultValMin;

    @FindBy(xpath = "//input[@name=\"defaultValMax\"]")
    public WebElement defaultValMax;

    @FindBy(xpath = "//input[@name=\"createdDate\"]")
    public WebElement createdDate;

    @FindBy(xpath = "//button[@id=\"save-entity\"]")
    public WebElement saveItem;

    @FindBy(xpath = "(//a[@class=\"page-link\"])[9]")
    public WebElement sonSayfa;

    @FindBy(xpath = "//tr[12]//td")
    public List<WebElement> tumItemBilgileri;

    @FindBy(xpath = "(//a[@class=\"btn btn-info btn-sm\"])[7]")
    public WebElement olusturulanItemGoruntuleme;

    @FindBy(xpath = "(//a[@class=\"btn btn-info btn-sm\"])[3]")
    public WebElement ucuncuItemVİew;

    @FindBy(xpath = "//h2")
    public WebElement goruntulenenItem;

    @FindBy(xpath = "//dd")
    public List<WebElement> goruntulenenTumBilgiler;

    @FindBy(xpath = "(//a[@class=\"btn btn-danger btn-sm\"])[17]")
    public WebElement silinecekOgeDeleteButon;

    @FindBy(xpath = "//button[@id=\"jhi-confirm-delete-cTestItem\"]")
    public WebElement ikinciDelete;

    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> idList;

    @FindBy(xpath = "//dd[1]")
    public WebElement nameGoruntulenen;

    @FindBy(xpath = "//dd[2]")
    public WebElement descriptionGoruntulenen;

    @FindBy(xpath = "//dd[3]")
    public WebElement priceGoruntulenen;

    @FindBy(xpath = "//dd[4]")
    public WebElement defaultValMinGoruntulenen;

    @FindBy(xpath = "//dd[5]")
    public WebElement defaultValMaxGoruntulenen;

    @FindBy(xpath = "//dd[6]")
    public WebElement createdDateGoruntulenen;

    @FindBy(xpath ="(//a[@class=\"btn btn-primary btn-sm\"])[1]")
    public WebElement sonSayfaIlkItemEdit;

    @FindBy(xpath ="//input[@id=\"c-test-item-name\"]")
    public WebElement editName;

    @FindBy(xpath ="//button[@id=\"save-entity\"]")
    public WebElement editSave;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> sonSayfaIlkElementBilgileri;


//US019 Ali Enes

    @FindBy(xpath="(//a[@class='dropdown-item'])[2]")
    public WebElement ItemsandTitlesStaff;

    @FindBy(id="jh-create-entity")
    public WebElement CreateanewStaff;

    @FindBy(id="searchSSN")
    public WebElement searchSSN;

    @FindBy(xpath="//input[@name='useSSNSearch']")
    public WebElement useSSNSearch;

    @FindBy(xpath="//*[text()='Search User']")
    public WebElement SearchUserButton;

    @FindBy(xpath="(//input[@value])[3]")
    public WebElement staffValue;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement staffLastName;

    @FindBy(xpath="//input[@name='birthDate']")
    public WebElement staffBirthDate;

    @FindBy(xpath="//input[@name='phone']")
    public WebElement staffPhone;

    @FindBy(xpath="//select[@name='gender']")
    public WebElement staffGender;

    @FindBy(xpath="//select[@name='bloodGroup']")
    public WebElement staffBloodGroup;

    @FindBy(xpath="//input[@name='adress']")
    public WebElement staffAdress;

    @FindBy(xpath="//input[@name='description']")
    public WebElement staffDescription;

    @FindBy(xpath="//input[@name='createdDate']")
    public WebElement staffCreatedDate;

    @FindBy(xpath="//select[@name='user.id']")
    public WebElement staffUserId;

    @FindBy(xpath="//select[@name='cstate.id']")
    public WebElement staffCStateId;

    @FindBy(xpath="(//a[@class='btn btn-link btn-sm'])[1]")
    public WebElement IlkStaffId;

    @FindBy(xpath="//*[text()='Back']")
    public WebElement BackButton;

    @FindBy(xpath="(//*[text()='Edit'])[1]")
    public WebElement IlkStaffEditButton;

    @FindBy(xpath="(//a[@class='btn btn-danger btn-sm'])[2]")
    public WebElement staffDelete;

    @FindBy(xpath="(//button[@type='button'])[4]")
    public WebElement staffDelete2;


// US020-021 İbrahim

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administrationButonu;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagementButonu;

    @FindBy(xpath = "(//span[text()='First name'])")
    public WebElement firstNameYazisi;

    @FindBy(xpath = "(//span[text()='Last name'])")
    public WebElement lastNameYazisi;

    @FindBy(xpath = "(//span[text()='Email'])")
    public WebElement eMailYazisi;

    @FindBy(xpath = "//span[text()='Modified date']")
    public WebElement modifiedDate;

    @FindBy(xpath = "(//span[text()='Deactivated'])[1]")
    public WebElement deactivatedButonu;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement toastifyWebElementi;
//toastifyWebElementi = işlemin basarılı oldunu gösteren ekranın sol ust kosesınde beliren yeşil uyarı mesajı

    @FindBy (xpath = "//span[text()='Create a new user']")
    public WebElement createANewUserButonu;

    //Create a new User Butonuna tıkladıktan sonra gelinen kullanıcı olusturma formundaki gerekli locateler
    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameKutusu;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameKutusu;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnKutusu;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//a[@href='/admin/user-management/silinecekhesap/delete']")
    public WebElement silinecekHesapDeleteButonu;

    @FindBy(xpath = "//button[2]/span[text()='Delete']")
    public WebElement confirmDeleteButonu;
//delete butonuna tıkladıktan sonra açılan uyarı penceresindeki delete butonu.

    @FindBy(xpath="//span[text()='Edit']")
    public WebElement editButonu;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement profilesDropDownMenusu;


//US027 AliM

    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement itemsTitles;

    @FindBy(xpath = "//*[@id=\"entity-menu\"]//a[9]")
    public WebElement messagesDropdown;


//cigdem
    @FindBy(id="account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id=\"login-item\"]")
    public WebElement ilkSingInButton;

    @FindBy(xpath = "//input[@id=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement ikinciSingInButton;

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitlesButon;

    @FindBy(xpath = "//span[text()='Country']")
    public WebElement countryButon;

    @FindBy(xpath = "//span[text()='Create a new Country']")
    public WebElement createCountryButon;

    @FindBy(id = "[//input[@id='country-name']")
    public WebElement countryNameButon;

    @FindBy(id = "[id='country-createdDate']")
    public WebElement createdDateButon;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButon;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement createCountryYazisi;

    @FindBy(xpath = "//span[text()='State/City']")
    public WebElement stateCityButon;

    @FindBy(xpath = "//span[text()='Create a new State/City']")
    public WebElement createStateCityButon;

    @FindBy(xpath = "[id='c-state-name']")
    public WebElement stateCityNameButon;

    @FindBy(id = "[id='c-state-createdDate']")
    public WebElement stateCitycreatedDateButon;

    @FindBy(id = "[id='c-state-state']")
    public WebElement stateCityCountrySecmeButon;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement kayitYapildiButon;

    @FindBy(xpath ="//div[@class='app-container']//div[@class='Toastify']//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']\n")
    public WebElement allertId;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement kayitYapildi;

    @FindBy(xpath= "//span[text()='Back']")
    public WebElement backButon;

    @FindBy(xpath= "//a[@href='/c-state/148793/delete']")
    public WebElement ilkDeleteButon;

    @FindBy(xpath="//button[@id='jhi-confirm-delete-country']")
    public WebElement ikinciDeleteButon;


    @FindBy(xpath= "//a[@class='btn btn-danger btn-sm']")
    public List<WebElement> deleteList;


    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertList;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement kayitSilindi;

    @FindBy(xpath = "//a[@class='btn btn-link btn-sm']")
    public List<WebElement> idListe;

    @FindBy(id = "[id='footer']")
    public WebElement listeSonu;



    // US_15 Cemil

    @FindBy(xpath = "//span[normalize-space()='Items&Titles']")
    public WebElement itemsAndTitlesButton;

    @FindBy(xpath = "//span[normalize-space()='Patient']")
    public WebElement patientButton;

    @FindBy(xpath = "//span[normalize-space()='Patients']")
    public WebElement patientList;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createNewPatientButton;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='patient-birthDate']")
    public WebElement birthDateTextBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='patient-phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement genderTextBox;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement basariMesaji;

    @FindBy(xpath = "//span[normalize-space()='ID']")
    public WebElement seeID;

    @FindBy(xpath = "//span[normalize-space()='SSN']")
    public WebElement seeSSN;

    @FindBy(xpath = "//span[normalize-space()='First Name']")
    public WebElement seeFirstname;

    @FindBy(xpath = "//span[normalize-space()='Last Name']")
    public WebElement seeLastname;

    @FindBy(xpath = "//span[normalize-space()='Birth Date']")
    public WebElement seeBirhtDate;

    @FindBy(xpath = "//span[normalize-space()='Phone']")
    public WebElement seePhone;

    @FindBy(xpath = "//span[normalize-space()='Email']")
    public WebElement seeEmail;

    @FindBy(xpath = "//span[normalize-space()='Gender']")
    public WebElement seeGender;

    @FindBy(xpath = "//span[normalize-space()='Blood Group']")
    public WebElement seeBloodGroup;

    @FindBy(xpath = "//span[normalize-space()='Address']")
    public WebElement seeAddress;

    @FindBy(xpath = "//span[normalize-space()='Description']")
    public WebElement seeDescription;

    @FindBy(xpath = "//span[normalize-space()='Created Date']")
    public WebElement seeCreatedDate;

    @FindBy(xpath = "//span[normalize-space()='User']")
    public WebElement seeUser;

    @FindBy(xpath = "//table[@class='table']//thead//tr//th//span[contains(text(),'Country')]")
    public WebElement seeCountry;

    @FindBy(xpath = "//table[@class='table']//thead//tr//th//span[contains(text(),'State/City')]")
    public WebElement seeStateCity;


    @FindBy(xpath = "//a[normalize-space()='237901']")
    public WebElement editHasta;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[16]/div[1]/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//span[normalize-space()='Appointment']")
    public WebElement appointment;

    @FindBy(xpath = "//span[normalize-space()='Appointments']")
    public WebElement appointmentList;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createNewAppointment;

    @FindBy(xpath = "//input[@id='appointment-endDate']")
    public WebElement appointmentEndDate;

    @FindBy(xpath = "//textarea[@id='appointment-treatment']")
    public WebElement treatment;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[16]/div[1]/a[2]")
    public WebElement ilkHastaEdit;

    @FindBy(xpath = "(//a)[34]")
    public WebElement silincekHasta;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--error toastify-toast']")
    public WebElement hataMesaji;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[16]/div/a[3]")
    public WebElement ilkHastaSilme;


    // EMREG// US_018
        @FindBy(xpath = "//div[@class='container'][1]")
        public WebElement welcomeMedunnaHeader;
        @FindBy(xpath = "//li[@id='account-menu']")
        public WebElement accountMenuButton;
        @FindBy(xpath = "//a[@id='login-item']")
        public WebElement signInButton;
        @FindBy(xpath = "//input[@name='username']")
        public WebElement userNameTextBox;
        @FindBy(xpath = "//input[@name='password']")
        public WebElement passwordTextBox;
        @FindBy(xpath = "//button[@type='submit']")
        public WebElement signInEnterButton;
        @FindBy(xpath = "//span[text()='Administration']")
        public WebElement adminVerifyEnterVisible;
        @FindBy(xpath = "//span[text()='Items&Titles']")
        public WebElement itemTitlesHeader;
        @FindBy(xpath = "//span[text()='Physician']")
        public WebElement physicianTitle;
        @FindBy(xpath = "//a[text()='24']")
        public WebElement pageNumber24;
        @FindBy(xpath = "//tr[14]//td[18]//div//a[2]//*[text()='Edit']")
        public WebElement editDoctorEmre;
        @FindBy(xpath = "//span[text()='Physicians']")
        public WebElement physicianTableHeaderText;
        @FindBy(xpath = "//span[text()='Create a new Physician']")
        public WebElement createNewPhysicianButton;
        @FindBy(xpath = "//input[@id='searchSSN']")
        public WebElement ssnTextBox;
        @FindBy(xpath = "//button[text()='Search User']")
        public WebElement searchUserButton;
        @FindBy(xpath = "//input[@name='useSSNSearch']")
        public WebElement useSearchCheckBox;
        @FindBy(xpath = "//div[text()='User found with search SSN']")
        public WebElement popUpAlert;
        @FindBy(xpath = "//input[@name='firstName']")
        public WebElement firstNameTextBoxEG;
        @FindBy(xpath = "//input[@name='lastName']")
        public WebElement lastNameTextBoxEG;
        @FindBy(xpath = "//input[@name='birthDate']")
        public WebElement birthDateTextBoxEG;
        @FindBy(xpath = "//input[@name='phone']")
        public WebElement phoneNumber;
        @FindBy(xpath = "//input[@name='adress']")
        public WebElement addressTextBox;
        @FindBy(xpath = "//select[@name='gender']")
        public WebElement ddmGender;
        @FindBy(xpath = "//select[@name='speciality']")
        public WebElement specialityDdm;
        @FindBy(xpath = "//select[@name='bloodGroup']")
        public WebElement bloodGroup;
        @FindBy(xpath = "//input[@name='description']")
        public WebElement descriptionTextBox;
        @FindBy(xpath = "//input[@id='file_image']")
        public WebElement dosyaSec;
        @FindBy(xpath = "//input[@name='examFee']")
        public WebElement examFeeButton;
        @FindBy(xpath = "//select[@name='user.id']")
        public WebElement userChooseButton;
        @FindBy(xpath = "//select[@name='country.id']")
        public WebElement countryButton;
        @FindBy(xpath = "//select[@id='physician-cstate']")
        public WebElement cityButton;
        @FindBy(xpath = "//span[text()='Save']")
        public WebElement saveButtonEG;
        @FindBy(xpath = "//div[@class='info jhi-item-count']")
        public WebElement showingItemsTitle;
        @FindBy(xpath="//tr[5]//td[18]//div//a[@class='btn btn-primary btn-sm']")
        public WebElement editButtonNew;
        @FindBy(xpath = "//tr[2]//td[18]//div//a[@class='btn btn-danger btn-sm']")
        public WebElement deletePhysicianButton;
        @FindBy(xpath = "//button[@id='jhi-confirm-delete-physician']")
        public WebElement deleteAcceptButton;
}






