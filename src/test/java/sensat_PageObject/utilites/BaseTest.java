package sensat_PageObject.utilites;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        //Create driver
        //Appium code ==> Appium server ==>Mobile
        //to start the appium server automatically, we should give path of main.js to aippiumServicebuilder and IP adress and port number
        //built server
        service=new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Android");
        //options.setChromedriverExecutable("//Users//cumalioruc//Desktop//Appium/chromedriver");

        // Add desired capability to automatically grant permissions
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("appPackage", "tr.com.dteknoloji.sensat"); // Buraya uygulamanın package adını yazın
        options.setCapability("appActivity", "tr.com.dteknoloji.sensat.MainActivity");
        options.setCapability(MobileCapabilityType.NO_RESET, true);
        options.setCapability("autoAcceptAlert",true);
        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options); //JAVA 20 den sonra new URL() =>new URI() oldu. URL'e parse ettik.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
