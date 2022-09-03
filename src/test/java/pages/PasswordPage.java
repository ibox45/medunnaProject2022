package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PasswordPage {

    public PasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement loginHesapMenusu1;

    @FindBy(xpath = "//li[@id='account-menu']//a[2]")
    public WebElement passwordButonu;

    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement currentPassword;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement newPasswordConfirmation;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[contains (text(),'Password changed!')]")
    public WebElement basariMesaji;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement birinciCubuk;

    @FindBy(xpath = "(//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')])[2]")
    public WebElement ikinciCubuk;

    @FindBy(xpath = "(//*[@id='strengthBar']/li[contains(@style,'rgb(255, 255, 0)')])[3]")
    public WebElement ucuncuCubuk;

    @FindBy(xpath = "(//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')])[4]")
    public WebElement dorduncuCubuk;

    @FindBy(xpath = "(//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')])[5]")
    public WebElement besinciCubuk;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement passwordEslesmedi;

    @FindBy(xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement makeAnAppointment;
}
