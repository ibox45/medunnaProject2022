package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MessagesPage {
    public MessagesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@class='hand'][1]")
    public WebElement idBaslik;

    @FindBy(xpath = "//*[@class='hand'][2]")
    public WebElement nameBaslik;

    @FindBy(xpath = "//*[@class='hand'][3]")
    public WebElement emailBaslik;

    @FindBy(xpath = "//*[@class='hand'][4]")
    public WebElement subjectBaslik;

    @FindBy(xpath = "//*[@class='hand'][5]")
    public WebElement messageBaslik;

    @FindBy(xpath = "//*[@id='jh-create-entity']")
    public WebElement createNewMessage;

    @FindBy(xpath = "//*[@id='c-message-name']")
    public WebElement createName;

    @FindBy(xpath = "//*[@id='c-message-email']")
    public WebElement createEmail;

    @FindBy(xpath = "//*[@id='c-message-subject']")
    public WebElement createSubject;

    @FindBy(xpath = "//*[@id='c-message-message']")
    public WebElement createMessage;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement createSave;

    @FindBy(xpath = "//*[@*='btn btn-link btn-sm'][1]")
    public WebElement ilkSiraID;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement createNewMessageOkAndId;

    @FindBy(xpath = "//*[@viewBox='0 0 320 512'][1]")
    public WebElement idButton;

    @FindBy(xpath = "//*[@class='btn btn-link btn-sm'][1]")
    public WebElement newMessageInId;

    @FindBy(xpath = "//span[text()='View'][1]")
    public WebElement viewButton;

    @FindBy(xpath = "//span[text()='Edit'][1]")
    public WebElement editButton;

    @FindBy(xpath = "//span[text()='Delete'][1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@name='name']")    public WebElement editName;
 //   @FindBy(xpath = "//*[@id='name']")    public WebElement editName;
  //  @FindBy(xpath = "//*[@id='nameLabel']")    public WebElement editName;

    @FindBy(xpath = "//*[@name='email']")   public WebElement editEmail;
 //   @FindBy(xpath = "//*[@id='email']")   public WebElement editEmail;
 //   @FindBy(xpath = "//*[@id='emailLabel']")   public WebElement editEmail;

    @FindBy(xpath = "//*[@name='subject']")    public WebElement editSubject;
 //   @FindBy(xpath = "//*[@id='subject']")    public WebElement editSubject;
  //  @FindBy(xpath = "//*[@id='subjectLabel']")    public WebElement editSubject;

    @FindBy(xpath = "//*[@name='message']")    public WebElement editMessage;
  //  @FindBy(xpath = "//*[@id='message']")    public WebElement editMessage;
//    @FindBy(xpath = "//*[@id='messageLabel']")    public WebElement editMessage;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement editSave;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]//dd[1]")
    public WebElement viewName;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]//dd[2]")
    public WebElement viewEmail;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]//dd[3]")
    public WebElement viewSubject;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]//dd[4]")
    public WebElement viewMessage;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement viewEdit;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement sonSave;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    public WebElement back;

    //*[@class='btn btn-link btn-sm'][1]
    //*[@id="app-view-container"]//tbody/tr[1]/td[1]/a

    @FindBy(xpath = "//*[@id=\"app-view-container\"]//tbody/tr[1]/td[1]/a")
    public WebElement deleteId;

    @FindBy(xpath = "//*[@id=\"jhi-confirm-delete-cMessage\"]")
    public WebElement deleteMessage;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement deleteOlanIdMesaj;

    @FindBy(xpath = "//*[@id=\"hospitalmsappfrontendApp.cMessage.delete.question\"]")
    public WebElement denemeDeleteMesaj;

}
