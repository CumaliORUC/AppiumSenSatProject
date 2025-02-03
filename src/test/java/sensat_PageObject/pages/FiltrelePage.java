package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FiltrelePage {

    AndroidDriver driver;
    public FiltrelePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement markaSearchBox;

    @AndroidFindBy(accessibility = "Ds (4)")
    public WebElement modelDs;

    @AndroidFindBy(accessibility = "Ds 9 (1)")
    public WebElement markaDs9;

    @AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc, 'Ds')]")
    public WebElement markaFiltreIcerik;

    @AndroidFindBy(xpath = "//android.view.View[starts-with(@content-desc, 'Ds 9')]")

    public WebElement modelFiltreIcerik;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Ds')]")
    public List<WebElement> sonucListesi;


    public WebElement filtreler(String elementName) {
        return driver.findElement(AppiumBy.accessibilityId(elementName));
    }

    public void aramaSonucuİçeriyormu(String elementName) {
        for (WebElement sonuc : sonucListesi) {
            Assert.assertTrue(sonuc.getAttribute("content-desc").contains(elementName));
            }
        }
    }



