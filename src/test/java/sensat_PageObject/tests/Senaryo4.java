package sensat_PageObject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sensat_PageObject.pages.*;
import sensat_PageObject.utilites.BaseTest;
import sensat_PageObject.utilites.ConfigReader;

public class Senaryo4 extends BaseTest {
    @Test
    public void Registration() {

        HomePage homePage= new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HesapOlusturPage hesapOlusturPage = new HesapOlusturPage(driver);
        RegisterationPage registerationPage = new RegisterationPage(driver);
        TelefonDogrulamaPage telefonDogrulamaPage = new TelefonDogrulamaPage(driver);

        homePage.panelimButton.click();
        loginPage.hemenUyeOlButton.click();
        hesapOlusturPage.bireyselHesapOlusturButton.click();

        Assert.assertTrue(registerationPage.registerPageTitle.isDisplayed());
        registerationPage.registrationNameBox.click();
        registerationPage.registrationNameBox.sendKeys(ConfigReader.getProperty("registered_name"));
        registerationPage.registrationLastNameBox.click();
        registerationPage.registrationLastNameBox.sendKeys(ConfigReader.getProperty("registered_name"));
        registerationPage.registrationEmailBox.click();
        registerationPage.addrandomEmail();
        registerationPage.registrationGSMnoBox.click();

        registerationPage.registrationGSMnoBox.sendKeys(ConfigReader.getProperty("registered_phone"));
        registerationPage.registrationPasswordBox.click();
        registerationPage.registrationPasswordBox.sendKeys(ConfigReader.getProperty("registered_password"));
        driver.hideKeyboard();
        registerationPage.confirmPasswordBox.click();
        registerationPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("registered_password"));
        driver.hideKeyboard();

        registerationPage.scrollToBottomWithUiScrollable(driver);

        registerationPage.okudumKabulEdiyorumCheckBox.click();
        registerationPage.kisiselRizaBeyaniBox.click();
        registerationPage.ticariIleriOnayCheckBox.click();
        registerationPage.uyeOlButton.click();

        Assert.assertTrue(telefonDogrulamaPage.telefonDogrulamaPagePageTitle.isDisplayed());
    }

}
