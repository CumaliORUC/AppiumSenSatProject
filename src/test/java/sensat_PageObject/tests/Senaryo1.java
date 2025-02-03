package sensat_PageObject.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import sensat_PageObject.pages.*;
import sensat_PageObject.utilites.BaseTest;
import sensat_PageObject.utilites.ConfigReader;


public class Senaryo1 extends BaseTest {
    //Scenario-1 : Uye ol
    @Test
    @Description("Senaryo 1: Login ve hesap bilgileri dogrulaması yapılacaktır")
    @Severity(SeverityLevel.NORMAL)
    public void HesapBilgileriDogrulama() {
        Allure.step("Senaryo 1: Login ve hesap bilgileri dogrulaması yapılacaktır");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PanelimPage panelimPage = new PanelimPage(driver);
        UyelikIslemlerimPage uyelikIslemlerimPage = new UyelikIslemlerimPage(driver);
        UyelikBilgilerimPage uyelikBilgilerimPage = new UyelikBilgilerimPage(driver);

        Allure.step("Kullanıcı Login Sayfasına gider");
        homePage.panelimButton.click();
        loginPage.Login(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));

        Allure.step("Kullanıcının başarılı login olduğu doğrulanır");
        Assert.assertTrue(homePage.panelimButton.isDisplayed(), "Login işlemi başarısız");

        Allure.step("Kullanıcı Panelim sayfasına gider");
        homePage.panelimButton.click();
        panelimPage.panelimElements("Üyelik İşlemlerim").click();

        Allure.step("Kullanıcının Uyelik işlemleri sayfasında olduğu doğrulanır");
        Assert.assertTrue(uyelikIslemlerimPage.UyelikIslemlerimTitle.isDisplayed(), "Üyelik İşlemlerim sayfası bulunamadı");
        uyelikIslemlerimPage.UyelikPageElements("Üyelik Bilgilerim").click();

        Allure.step("Kullanıcının Uyelik bilgilerim sayfasında olduğu doğrulanır");
        Assert.assertTrue(uyelikBilgilerimPage.uyelikBilgilerimPageTitle.isDisplayed(), "Üyelik bilgilerim sayfası bulunamadı");

        Allure.step("Kullanıcının hesap bilgileri doğrulanır");
        //System.out.println(uyelikBilgilerimPage.hesapAdi().getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapAdi().getText().contains(ConfigReader.getProperty("uye_Adi")));
        System.out.println(uyelikBilgilerimPage.hesapSoyAdi().getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapSoyAdi().getText().contains(ConfigReader.getProperty("uye_Soyadi")));
        System.out.println(uyelikBilgilerimPage.hesapMail.getText());
        Assert.assertTrue(uyelikBilgilerimPage.hesapMail.getText().contains(ConfigReader.getProperty("email")));
    }
}