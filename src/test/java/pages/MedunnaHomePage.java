package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaHomePage {
    public MedunnaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Log in Page
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenuButton2;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement signInButton2;



    //Make an Appointment Ana Sayfa
    @FindBy(xpath="//input[@name='firstName']")
    public WebElement FirstName;

    @FindBy (xpath="//*[text()='Your FirstName is required.']")
    public WebElement firstNameIsRequired;

    @FindBy (xpath="//a[@class='appointment-btn scrollto']")
    public WebElement makeAnAppointmentAnaSayfa;

    @FindBy(xpath="//input[@name='ssn']")
    public WebElement SSN;

    @FindBy(xpath="//*[text()='Your SSN is required.']")
    public WebElement YourSSNIsRequired;

    @FindBy (xpath="//input[@name='lastName']")
    public WebElement LastName;

    @FindBy (xpath="//input[@name='email']")
    public WebElement Email;

    @FindBy (xpath="//input[@name='phone']")
    public WebElement PhoneNumber;

    @FindBy (xpath="//*[text()='Send an Appointment Request']")
    public WebElement SendanAppointmentRequestButonu;

    @FindBy(xpath="//*[text()='Your SSN is invalid']")
    public WebElement YourSSNIsInvalid;

    @FindBy(xpath="//*[text()='Your email is required.']")
    public WebElement YourMailIsRequired;

    @FindBy(xpath="//*[text()='This field is invalid']")
    public WebElement YourmailfieldIsInvalid;

    @FindBy(xpath="//*[text()='Phone number is required.']")
    public WebElement PhoneNumberIsRequired;

    @FindBy(xpath="//*[text()='Phone number is invalid']")
    public WebElement YourPhoneNumberfieldIsInvalid;

    @FindBy (xpath="//*[text()='Your LastName is required.']")
    public WebElement lastNameIsRequired;
}
