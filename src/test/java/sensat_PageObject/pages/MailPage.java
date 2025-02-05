package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MailPage {

    AndroidDriver driver;
    public MailPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gm:id/subject' and @text='Hesabını oluşturduk!']")
    public WebElement senSatMail;


    @AndroidFindBy(xpath = "(//android.view.View[@text='ÜYELİĞİNİ ONAYLA'])[2]")
    public WebElement uyelikOnaylaButonu;
    }



