package sensat_PageObject.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sensat_PageObject.utilites.ReuseableMethods;

public class RegisterationPage extends ReuseableMethods {

    AndroidDriver driver;
    public RegisterationPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Bireysel sensat.com Hesabınızı Oluşturun")
    public WebElement registerPageTitle;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    public WebElement registrationNameBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    public WebElement registrationLastNameBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]")
    public WebElement registrationEmailBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
    public WebElement registrationGSMnoBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[5]")
    public WebElement registrationPasswordBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[6]")
    public WebElement confirmPasswordBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[2]")
    public WebElement okudumKabulEdiyorumCheckBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[4]")
    public WebElement kisiselRizaBeyaniBox;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[7]")
    public WebElement ticariIleriOnayCheckBox;

    @AndroidFindBy(accessibility = "Üye Ol")
    public WebElement uyeOlButton;

    public void  addrandomEmail() {
        String randomEmail = "test" + Math.random() + "@gmail.com";
        registrationEmailBox.sendKeys(randomEmail);
    }

}
