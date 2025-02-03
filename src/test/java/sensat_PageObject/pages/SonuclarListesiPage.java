package sensat_PageObject.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sensat_PageObject.utilites.ReuseableMethods;

import java.time.Duration;
import java.util.List;

public class SonuclarListesiPage extends ReuseableMethods{

    AndroidDriver driver;

    public SonuclarListesiPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "Marka-Model:\nDs - Ds 9")
    public WebElement markaModelFiltreSekmesi;

    @AndroidFindBy(xpath ="//android.view.View[@content-desc][last()]" )
    public WebElement sonIlan;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc]/android.widget.ImageView[2])[last()]")
    public WebElement sayfadakiSonIlan;

    public void favorilereIlanEkle() {
        int hedefIlanSayisi = 10; // Toplam tıklanacak ilan sayısı
        int tiklananIlanSayisi = 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        while (tiklananIlanSayisi < hedefIlanSayisi) {
            // Sayfadaki tüm ilanları bul
            List<WebElement> ilanlar = driver.findElements(AppiumBy.xpath("//android.view.View[@content-desc]/android.widget.ImageView[2]"));

            for (int i = 0; i < ilanlar.size(); i++) {
                try {
                    // Elementi tekrar bulmak için index ile eriş (StaleElement önleme)
                    WebElement ilan = driver.findElements(AppiumBy.xpath("//android.view.View[@content-desc]/android.widget.ImageView[2]")).get(i);

                    // Element görünür olana kadar bekle
                    wait.until(ExpectedConditions.visibilityOf(ilan));

                    // Tıkla
                    ilan.click();
                    tiklananIlanSayisi++;
                    System.out.println(tiklananIlanSayisi + ". ilana tıklandı.");

                    // 10 ilana ulaşıldıysa döngüyü sonlandır
                    if (tiklananIlanSayisi >= hedefIlanSayisi) {
                        return; // Metottan çık
                    }

                } catch (StaleElementReferenceException e) {
                    System.out.println("Stale element hatası alındı, elementi yeniden buluyor...");
                    break; // DOM değiştiyse döngüyü kır ve tekrar başlat
                }
            }

            // Eğer hala 10 ilana ulaşılmadıysa scroll yap
            if (tiklananIlanSayisi < hedefIlanSayisi) {
                scrollDown();
                wait.until(ExpectedConditions.visibilityOf(sayfadakiSonIlan)); // Scroll sonrası bekleme
            }
        }
    }

    public void ilanSayfasınaGit() throws InterruptedException {
    sonIlan.click();
    sekmeyeGit("Ana Sayfa");
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //Thread.sleep(5000);
        //driver.navigate().back();
        //driver.navigate().back();

        //((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "goBack"));

       //System.out.println("Back button tıklandı");
        //((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action", "goBack"));
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //System.out.println("Back button 2. kez tıklandı");
        //driver.findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Vitrin')]")).click();

    }
}





