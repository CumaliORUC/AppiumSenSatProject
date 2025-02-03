package sensat_PageObject.pages;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import sensat_PageObject.utilites.ReuseableMethods;

public class HomePage extends ReuseableMethods {

    AndroidDriver driver;
    public HomePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Panelim\nSekme 5 / 5")
    public WebElement panelimButton;

    @AndroidFindBy(accessibility = "Detaylı Arama\nSekme 2 / 5")
    public WebElement detayliAramaButton;

    @AndroidFindBy(accessibility = "Favorilerim\nSekme 4 / 5")
    public WebElement favorilerimButton;

}
