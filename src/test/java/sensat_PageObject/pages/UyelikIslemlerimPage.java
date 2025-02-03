package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UyelikIslemlerimPage {

    AndroidDriver driver;
    public UyelikIslemlerimPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Üyelik İşlemlerim")
    public WebElement UyelikIslemlerimTitle;

    public WebElement UyelikPageElements(String elementName) {
        return driver.findElement(AppiumBy.accessibilityId(elementName));
    }
}

