package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//li[@id='account-menu']")
    public WebElement accountMenuButonu;

    @FindBy (xpath="//a[@href='/account/register']")
    public WebElement registerButonu;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnKutusu;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public WebElement invalidSsnYazisi;

    @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement requiredSsnYazisi;

    @FindBy(xpath="(//div[@class='form-group'])[1]")
    public WebElement ssnFormGrubu;

    @FindBy(xpath="//input[@name='firstName']")
    public WebElement firstNameKutusu;

    @FindBy(xpath="(//div[@class='form-group'])[2]")
    public WebElement firstNameFormGrubu;

    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement requiredFirstNameYazisi;

    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastNameKutusu;

    @FindBy(xpath="(//div[@class='form-group'])[3]")
    public WebElement lastNameFormGrubu;

    @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement requiredLastNameYazisi;

    @FindBy(xpath="//input[@name='username']")
    public WebElement userNameKutusu;

    @FindBy(xpath="(//div[@class='form-group'])[4]")
    public WebElement userNameFormGrubu;

    @FindBy(xpath = "//div[text()='Your username is invalid.']")
    public WebElement invalidUserNameYazisi;

    @FindBy (xpath = "//div[text()='Your username is required.']")
    public WebElement requiredUserNameYazisi;

    @FindBy(xpath="//input[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath="(//div[@class='form-group'])[5]")
    public WebElement emailFormGrubu;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement invalidEmailYazisi;

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement requiredEmailYazisi;

    @FindBy(xpath = "//*[@id='login-item']")
    public WebElement loginItem;


    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SignInButton;

}
