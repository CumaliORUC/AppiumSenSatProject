package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UyelikBilgilerimPage {

    AndroidDriver driver;

    public UyelikBilgilerimPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Üyelik Bilgilerim")
    public WebElement uyelikBilgilerimPageTitle;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> adSoyadBoxes;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@text, '@')]")
    public WebElement hesapMail;

    public WebElement hesapAdi() {
        return adSoyadBoxes.get(0);
    }

    public WebElement hesapSoyAdi() {
        return adSoyadBoxes.get(1);
    }
}

