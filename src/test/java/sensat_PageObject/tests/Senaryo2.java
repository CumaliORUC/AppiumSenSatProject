package sensat_PageObject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sensat_PageObject.pages.*;
import sensat_PageObject.utilites.BaseTest;

public class Senaryo2 extends BaseTest {
    @Test
    public void detayli_Arama(){

        HomePage homePage = new HomePage(driver);
        DetayliAraPage detayliAraPage = new DetayliAraPage(driver);
        FiltrelePage filtrelePage = new FiltrelePage(driver);
        SonuclarListesiPage sonuclarListesiPage = new SonuclarListesiPage(driver);
        homePage.setActivity();
        //homePage.panelimButton.click();
        //loginPage.Login(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));
        homePage.detayliAramaButton.click();
        detayliAraPage.otomobilTabButon.click();
        filtrelePage.filtreler("Marka & Model").click();
        filtrelePage.markaSearchBox.click();
        filtrelePage.markaSearchBox.sendKeys("DS");
        filtrelePage.modelDs.click();
        filtrelePage.filtreler("Devam Et").click();
        filtrelePage.markaDs9.click();
        filtrelePage.filtreler("Uygula").click();
        Assert.assertTrue(filtrelePage.markaFiltreIcerik.getAttribute("content-desc\n").contains("Ds"));
        Assert.assertTrue(filtrelePage.modelFiltreIcerik.getAttribute("content-desc\n").contains("Ds 9"));

        filtrelePage.filtreler("Uygula").click();
        sonuclarListesiPage.markaModelFiltreSekmesi.getAttribute("content-desc\n").contains("DS 9");
        filtrelePage.aramaSonucuİçeriyormu("Ds");
    }
}
