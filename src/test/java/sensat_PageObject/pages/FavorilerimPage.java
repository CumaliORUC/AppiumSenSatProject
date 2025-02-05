package sensat_PageObject.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sensat_PageObject.utilites.ReuseableMethods;

import java.util.List;
import java.util.NoSuchElementException;

public class FavorilerimPage extends ReuseableMethods {

    AndroidDriver driver;

    public FavorilerimPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Favorilerim")
    public WebElement favorilerimPageTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Favori listende hiç ilan yok']")
    public WebElement ilanYokText;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@content-desc, 'km')])[1]")
    public WebElement ilkIlan;

    @AndroidFindBy(accessibility = "Favorilerim\nSekme 4 / 5")
    public WebElement favorilerimButton;


    @AndroidFindBy(accessibility = "Listeden Çıkar")
    public WebElement listedenCikarButton;

    public void FavoriListesiDoluMu() {
        List<WebElement> favoriListesi = driver.findElements(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'km')]"));
        Assert.assertTrue(favoriListesi.size() > 1, "Favori listesinde ilan bulunamadı");
    }


    public void tumFavorileriSil() {
        for (int i = 1; i <= 5; i++) {
            try {
                driver.findElement(AppiumBy.accessibilityId("Seç")).click();
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[1]/android.view.View")).click();
                listedenCikarButton.click();
            } catch (Exception e) {
                System.out.println("Favorilerde silinecek ilan bulunamadı");
            }
        }
    }

    public void favorileriSil(){
        /*
        for (int i = 1; i <= 10; i++) {
            try {
                driver.findElement(By.xpath("(//android.widget.ImageView[contains(@content-desc, 'km')])[1]")).click();
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView[1]")).click();
                //driver.findElement(AppiumBy.accessibilityId("Ana Sayfa")).click();
                driver.navigate().back();
                favorilerimButton.click();
            } catch (Exception e) {
                System.out.println("Favorilerde silinecek ilan bulunamadı");
            }
        }

         */
        for (int i = 1; i <= 10; i++) {
            try {
                // 1) İlk favori ilana tıklama
                driver.findElement(By.xpath("(//android.widget.ImageView[contains(@content-desc, 'km')])[1]")).click();

                // 2) Silme butonuna tıklama (örnek xpath)
                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView[1]")).click();

                // 3) Geri dön
                driver.navigate().back();

                // 4) Tekrar favorilerim sayfasına git
                favorilerimButton.click();

            } catch (Exception e) {
                System.out.println("Favorilerde silinecek ilan bulunamadı: " + e.getMessage());
            }

            // Favori listende hiç ilan yok mu?
            try {
                WebElement noFavoriteElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Favori listende hiç ilan yok']"));
                if (noFavoriteElement.isDisplayed()) {
                    System.out.println("Favori listende hiç ilan yok!");
                    break; // Döngüyü kır ve sonraki adıma geç
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Element bulunamadıysa devam et
            }
        }
    }

}



