package sensat_PageObject.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import sensat_PageObject.utilites.ReuseableMethods;

public class TelefonDogrulamaPage extends ReuseableMethods {

    AndroidDriver driver;
    public TelefonDogrulamaPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Telefon Numaranı Doğrulamalısın")
    public WebElement telefonDogrulamaPagePageTitle;

}
