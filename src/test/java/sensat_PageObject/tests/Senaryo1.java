package sensat_PageObject.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sensat_PageObject.pages.*;
import sensat_PageObject.utilites.BaseTest;
import sensat_PageObject.utilites.ConfigReader;

public class Senaryo1 extends BaseTest {
    @Test
    public void HesapBilgileriDogrulama() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PanelimPage panelimPage = new PanelimPage(driver);
        UyelikIslemlerimPage uyelikIslemlerimPage = new UyelikIslemlerimPage(driver);
        UyelikBilgilerimPage uyelikBilgilerimPage = new UyelikBilgilerimPage(driver);


        homePage.panelimButton.click();
        loginPage.Login(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));


        Assert.assertTrue(homePage.panelimButton.isDisplayed(), "Login işlemi başarısız");
        homePage.panelimButton.click();
        panelimPage.panelimElements("Üyelik İşlemlerim").click();


        Assert.assertTrue(uyelikIslemlerimPage.UyelikIslemlerimTitle.isDisplayed(), "Üyelik İşlemlerim sayfası bulunamadı");
        uyelikIslemlerimPage.UyelikPageElements("Üyelik Bilgilerim").click();
        Assert.assertTrue(uyelikBilgilerimPage.uyelikBilgilerimPageTitle.isDisplayed(), "Üyelik bilgilerim sayfası bulunamadı");

        //System.out.println(uyelikBilgilerimPage.hesapAdi().getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapAdi().getText().contains(ConfigReader.getProperty("uye_Adi")));
        System.out.println(uyelikBilgilerimPage.hesapSoyAdi().getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapSoyAdi().getText().contains(ConfigReader.getProperty("uye_Soyadi")));
        System.out.println(uyelikBilgilerimPage.hesapMail.getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapMail.getText().contains(ConfigReader.getProperty("email")));
    }
}