package sensat_PageObject.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class FavorilerimPage {

    AndroidDriver driver;

    public FavorilerimPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Favorilerim")
    public WebElement favorilerimPageTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Favori listende hiç ilan yok']")
    public WebElement ilanYokText;

    @AndroidFindBy(accessibility = "Seç")
    public WebElement secButton;

    @AndroidFindBy(accessibility = "Listeden Çıkar")
    public WebElement listedenCikarButton;

    public void FavoriListesiDolu() {
        List<WebElement> favoriListesi = driver.findElements(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'km')]"));
        Assert.assertTrue(favoriListesi.size() > 1, "Favori listesinde ilan bulunamadı");
    }


    public void tumFavorileriSil() {


        for (int i = 1; i <= 10; i++) {
            try {
                driver.findElement(AppiumBy.accessibilityId("Seç")).click();
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View")).click();
                listedenCikarButton.click();
            } catch (Exception e) {
                System.out.println("Favorilerde silinecek ilan bulunamadı");
            }
        }



/*
        try {
            do {
                // Favori ilanı seç ve sil
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View")).click();
                listedenCikarButton.click();

                // secButton görünürse tıkla
                if (secButton.isDisplayed()) {
                    secButton.click();
                } else {
                    System.out.println("Favorilerde silinecek ilan bulunamadı.");
                    break;  // secButton görünür değilse döngüyü bitir
                }
            } while (secButton.isDisplayed());  // secButton görünür olduğu sürece döngü devam eder

        } catch (NoSuchElementException e) {
            System.out.println("Beklenmeyen bir hata oluştu: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }

}

 */
    }
}



