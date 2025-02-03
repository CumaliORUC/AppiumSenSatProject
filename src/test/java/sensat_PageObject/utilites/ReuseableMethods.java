package sensat_PageObject.utilites;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class ReuseableMethods {
    AndroidDriver driver;
    public ReuseableMethods(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setActivity() {
        Activity activity = new Activity("tr.com.dteknoloji.sensat", "tr.com.dteknoloji.sensat.MainActivity");
    }

    public void waitForVisibilityOfElement(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(locator));

    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll parametreleri
        boolean canScrollMore = (Boolean) js.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 500,      // X koordinatı (başlangıç noktası)
                "top", 150,       // Y koordinatı (bitiş noktası)
                "width", 1,       // Genişlik (minimum tutmak için 1 kullanıyoruz)
                "height", 1800,   // Yükseklik: 2000 - 330 = 1670 piksel kadar kaydırır
                "direction", "down",  // Kaydırma yönü aşağı (down)
                "percent", 1        // %100 kaydırma (belirtilen alanın tamamı kadar)
        ));
    }
    public void sekmeyeGit(String sekmeName) {
        WebElement sekme= driver.findElement(By.xpath( "//android.view.View[contains(@content-desc, '"+sekmeName+"')]"));
        waitForVisibilityOfElement(sekme);
        sekme.click();
    }

    public void scrollToBottomWithUiScrollable(AndroidDriver driver) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().flingToEnd(5)"
        ));
    }

}
