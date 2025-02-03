package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    AndroidDriver driver;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Hemen üye ol.")
    public WebElement hemenUyeOlButton;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> loginBoxes;

    @AndroidFindBy(accessibility = "Giriş Yap")
    public WebElement girisYapButton;

    public void Login(String email, String password) {
        loginBoxes.get(0).click();
        loginBoxes.get(0).sendKeys(email);
        loginBoxes.get(1).click();
        loginBoxes.get(1).sendKeys(password);
        girisYapButton.click();
    }

}
