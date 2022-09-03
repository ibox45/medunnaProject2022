package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PhysicianPage {
    public PhysicianPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//*[text()='Edit'])[4]")
    public WebElement editButonu;
    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestTestButonu;
    @FindBy(xpath = "//*[@id='1404']")
    public WebElement SodiumCheckbox;
    @FindBy(xpath = "//*[@id='1402']")
    public WebElement UreaCheckbox;
    @FindBy(xpath = "//*[@id='1408']")
    public WebElement HemoglobinCheckbox;
    @FindBy(xpath = "//*[@id='1407']")
    public WebElement AlbuminCheckbox;
    @FindBy(xpath = "//*[@id='1403']")
    public WebElement CreatinineCheckbox;
    @FindBy(xpath = "//*[@id='1406']")
    public WebElement TotalProteinCheckbox;
    @FindBy(xpath = "//*[@id='132751']")
    public WebElement glucoseCheckbox;
    @FindBy(xpath = "//*[@id='127908']")
    public WebElement potasyumCheckbox;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButonu;
    @FindBy(xpath = "//*[text()='Show Test Results']")
    public WebElement ShowTestResultsButonu;
    @FindBy(xpath = "//*[text()='View Results']")
    public WebElement viewResultsButonu;
    @FindBy(xpath = "//*[@class='table']")
    public WebElement testResult;
    @FindBy(xpath = "//*[text()='Request Inpatient']")
    public WebElement requestInpatientButonu;
    @FindBy(xpath = "//*[text()='My Inpatients']")
    public WebElement MyInpatients;
    @FindBy(xpath = "//*[@class='view-routes']")
    public WebElement editInPatient;
    @FindBy(xpath = "//*[@name='status']")
    public WebElement status;
    @FindBy(xpath = "(//*[text()='Edit'])[6]")
    public WebElement yeniEditButonu;
    @FindBy(xpath = "(//*[text()='Save'])[1]")
    public WebElement yeniSaveButonu;
    @FindBy(xpath = "//*[@name='room.id']")
    public WebElement room;

    // Ortak
    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id=\"login-item\"]")
    public WebElement singIn;

    @FindBy(xpath = "//input[@id=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement ikinciSingIn;

    @FindBy(xpath = "//li[@id=\"entity-menu\"]")
    public WebElement myPages;

    @FindBy(xpath = "//span[text()=\"My Appointments\"]")
    public WebElement myAppointments;

    @FindBy(xpath = "//input[@id=\"fromDate\"]")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id=\"toDate\"]")
    public WebElement toDate;

    //My appointments Selcuk

    @FindBy(xpath = "//h2[@id=\"appointment-heading\"]")
    public WebElement myAppointmentsYazisi;

    @FindBy(xpath = "//tbody//tr//td[1]")
    public List<WebElement> hastaId;

    @FindBy(xpath = "//table//thead//th")
    public List<WebElement> baslikBilgileri;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> hastaBilgileri;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tumBilgilerSutun;

    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> sutunUzunlugu;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement ilkHastaEdit;

    @FindBy(xpath = "(//span[text()='Edit'])[2]")
    public WebElement ikinciHastaEdit;

    @FindBy(xpath = "(//span[text()='Edit'])[3]")
    public WebElement ucuncuHastaEdit;

    @FindBy(xpath = "//span[text()=\"Create or Edit an Appointment\"]")
    public WebElement createOrEditAnAppointment;

    @FindBy(xpath = "//select[@id=\"appointment-status\"]")
    public WebElement status1;

    @FindBy(xpath = "//textarea[@id=\"appointment-anamnesis\"]")
    public WebElement anamnesis;

    @FindBy(xpath = "//textarea[@id=\"appointment-treatment\"]")
    public WebElement treatment;

    @FindBy(xpath = "//textarea[@id=\"appointment-diagnosis\"]")
    public WebElement diagnosis;

    @FindBy(xpath = "//textarea[@id=\"appointment-prescription\"]")
    public WebElement prescription;

    @FindBy(xpath = "//textarea[@id=\"appointment-description\"]")
    public WebElement description;

    @FindBy(xpath = "//button[@id=\"save-entity\"]")
    public WebElement save;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> ilkHasta;

    @FindBy(xpath = "//div[@class=\"invalid-feedback\"]")
    public WebElement failYazisi;

    @FindBy(xpath = "//option[@value=\"PENDING\"]")
    public WebElement pending;

    @FindBy(xpath = "//option[@value=\"COMPLETED\"]")
    public WebElement completed;

    @FindBy(xpath = "//option[@value=\"CANCELLED\"]")
    public WebElement canceled;






}
