package pages;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class StaffPage {
    public StaffPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "account-menu")
    public WebElement accountMenu;
    @FindBy(xpath = "//a[@id=\"login-item\"]")
    public WebElement ilkSingInButton;
    @FindBy(xpath = "//input[@id=\"username\"]")
    public WebElement username;
    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement password;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement ikinciSingInButton;
    @FindBy(xpath = "//li[@id=\"entity-menu\"]")
    public WebElement myPages;
    //cigdem:
    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientButonu;
    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement patientSSNTexbox;
    @FindBy(xpath = "(//span[text()='View'])[6]")
    public WebElement viewButon;
    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButon;
    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement firstNameButon;
    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement lastNameButon;
    @FindBy(xpath = "//input[@id='patient-birthDate']")
    public WebElement birthDateButon;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement eMailButon;
    @FindBy(xpath = "//input[@id='patient-phone']")
    public WebElement phoneButon;
    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement genderButon;
    @FindBy(xpath = "//select[@id='patient-bloodGroup']")
    public WebElement bloodGroupButon;
    @FindBy(xpath = "//input[@id='patient-adress']")
    public WebElement adressButon;
    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement descriptionButon;
    @FindBy(xpath = "//select[@id='patient-user']")
    public WebElement userButon;
    @FindBy(xpath = "//select[@id='patient-country']")
    public WebElement countryButon;
    @FindBy(xpath = "//select[@id='patient-cstate']")
    public WebElement stateButon;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButon;
    @FindBy(xpath = "//div[@style='pointer-events: none;']")
    public WebElement kayıtyapıldıbutonu;
    @FindBy(xpath = "//input[@id='patient-id']")
    public WebElement idbuton;
    @FindBy(xpath = "//b[text()='154140']")
    public WebElement idgoruntulendibuton;

    //ibrahim
    @FindBy (xpath ="//span[text()='Show Appointments']")
    public WebElement showAppointmentsButonu;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionKutusu;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement editButonu;

    @FindBy(xpath = "//option[text()='UNAPPROVED']")
    public WebElement unapprovedYazisi;

    @FindBy(xpath = "//option[text()='PENDING']")
    public WebElement pendingYazisi;

    @FindBy(xpath = "//option[text()='CANCELLED']")
    public WebElement cancelledYazisi;

    @FindBy(xpath = "//option[text()='COMPLETED']")
    public WebElement completedYazisi;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesisKutusu;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement treatmentKutusu;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosisKutusu;

    @FindBy(xpath = "//select[@name='physician.id']")
    public WebElement doctorListesi;







}