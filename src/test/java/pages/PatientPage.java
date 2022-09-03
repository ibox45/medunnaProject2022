package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientPage {

    public PatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // My Appointments Page (US005)

    @FindBy (xpath="(//*[text()='My Appointments'])[1]")
    public WebElement MyAppointments;

    @FindBy(xpath="//thead//tr[1]//th[1]")
    public WebElement id;



    // Settings Page (US006)
    @FindBy(xpath = "//span[normalize-space()='Settings']")
    public WebElement setingsButton;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//strong[normalize-space()='Settings saved!']")
    public WebElement settingsSavedText;



    // Make an Appointment (US007)
    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement myPages;

    @FindBy(xpath = "//*[span='Make an Appointment']")
    public WebElement makeAppointment;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='appoDate']")
    public WebElement appoDate;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement sendRequestButton;



    // US-24-25-26 Page

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement accountMenu;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement ilkSigIn;
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement ikinciSignInButonu;
    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesButonu;
    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentsbutonu;
    @FindBy(xpath = "//*[text()='Show Tests']")
    public WebElement showTestButonu;
    @FindBy(xpath = "//*[text()='View Results']")
    public WebElement viewResultsButonu;
    @FindBy(xpath = "//*[text()='Show Invoice']")
    public WebElement showInvoiceButonu;
    @FindBy(xpath = "//*[@class='table']")
    public WebElement tableViewResults;
    // @FindBy(xpath = "//*[@class='table']")
    @FindBy(xpath = "//th[@style='font-size: 25px;']")
    public List<WebElement> tableInvoice;
    @FindBy(xpath = "//*[@name='fromDate']")
    public WebElement fromDate;
    @FindBy(xpath = "//*[@name='toDate']")
    public WebElement toDate;
    @FindBy(xpath = "//*[text()='Appointment date can not be past date!']")
    public WebElement yanlısDateTimeYazısı;
    @FindBy(xpath = "(//*[text()='Make an'])[1]")
    public WebElement makeAnAppointmentButonu;
    //@FindBy(xpath = "//*[@name='firstName']")
    //public WebElement firstName;
    @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement sendAppointmentRequest;
    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesTester;
    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentsTester;
    //@FindBy(xpath = "//tr[2]")
    @FindBy(xpath = "//tbody//tr[1]")
    public List<WebElement> randevuKontrol;
    @FindBy(xpath = "//*[text()='Your FirstName is required.']")
    public WebElement firstNameBosOlamaz;
    @FindBy(xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastNameBosOlamaz;
    @FindBy(xpath = "//*[text()='Your SSN is required.']")
    public WebElement SSNBosOlamaz;
    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement emailBosOlamaz;
    @FindBy(xpath = "//*[text()='Phone number is required.']")
    public WebElement phoneBosOlamaz;
    @FindBy(xpath = "//*[text()='Appointment date can not be past date!']")
    public WebElement yanlisTarih;
  //  @FindBy(xpath = "//*[@name='lastName']")
 //public WebElement lastName;
 //@FindBy(xpath = "//*[@name='ssn']")
 //public WebElement ssn;
 //@FindBy(xpath = "//*[@name='email']")
 //public WebElement email;
 //@FindBy(xpath = "//input[@name='phone']")
 //public WebElement phone;
 //@FindBy(xpath = "//input[@id='appoDate']")
 //public WebElement appoDate;
 //@FindBy(xpath = "(//*[text()='Make an Appointment'])[1]")
 //public WebElement makeAppointment;
    @FindBy(xpath = "(//*[text()='CONTACT'])[1]")
    public WebElement contactButonu;
    @FindBy(xpath = "//*[@name='name']")
    public WebElement concatName;
    @FindBy(xpath = "//*[text()='Send']")
    public WebElement sendButonu;
    @FindBy(xpath = "//tbody//tr[2]//td")
    public List<WebElement> hastaDogrulama;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> table;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOutButonu;



}
