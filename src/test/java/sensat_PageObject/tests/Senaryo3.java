package sensat_PageObject.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sensat_PageObject.pages.*;
import sensat_PageObject.utilites.BaseTest;

public class Senaryo3 extends BaseTest {

    @Test(description = "Favori ilanları silme testi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Bu test, kullanıcı favorilerindeki ilanları başarıyla silebiliyor mu kontrol eder.")
    public void favorilere_Arac_Ekleme() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        DetayliAraPage detayliAraPage = new DetayliAraPage(driver);
        FiltrelePage filtrelePage = new FiltrelePage(driver);
        SonuclarListesiPage sonuclarListesiPage =new SonuclarListesiPage(driver);
        FavorilerimPage favorilerimPage = new FavorilerimPage(driver);

        homePage.setActivity();
        homePage.favorilerimButton.click();
        //Favorilerim page'de olduğunu doğrulama
        Assert.assertTrue(favorilerimPage.favorilerimPageTitle.isDisplayed(), "Favorilerim sayfası bulunamadı");
        //İlan yok doğrulama
        Assert.assertTrue(favorilerimPage.ilanYokText.isDisplayed(), "Favorilerim sayfasında ilan bulunamadı");

        homePage.detayliAramaButton.click();
        detayliAraPage.otomobilTabButon.click();
        filtrelePage.filtreler("Uygula").click();
        sonuclarListesiPage.favorilereIlanEkle();
        sonuclarListesiPage.ilanSayfasınaGit();
        homePage.favorilerimButton.click();
        favorilerimPage.FavoriListesiDoluMu();
        //favorilerimPage.tumFavorileriSil(); Burada Silme İşlemi Favoriler sayfası içerisinde yapılır
        favorilerimPage.favorileriSil();
        Assert.assertTrue(favorilerimPage.ilanYokText.isDisplayed(), "Favorilerim sayfasında ilan bulunamadı");

    }
    @Test (enabled = false)
    public void favoileriSilme(){
        HomePage homePage = new HomePage(driver);
        FavorilerimPage favorilerimPage = new FavorilerimPage(driver);

        homePage.setActivity();
        homePage.favorilerimButton.click();
        favorilerimPage.FavoriListesiDoluMu();
        favorilerimPage.favorileriSil();
        Assert.assertTrue(favorilerimPage.ilanYokText.isDisplayed(), "Favorilerim sayfasında ilan bulunamadı");
    }

}