package sensat_PageObject.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sensat_PageObject.utilites.ReuseableMethods;

import java.util.List;

public class HesapOlusturPage extends ReuseableMethods {

    AndroidDriver driver;
    public HesapOlusturPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Bireysel Hesap Oluştur")
    public WebElement bireyselHesapOlusturButton;

}
