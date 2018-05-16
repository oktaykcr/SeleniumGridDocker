package com.tutorial.seleniumgriddocker.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseUITestCase {

    public final static String googleURL = "https://www.google.com.tr";

    protected static WebDriver driver = null;
    private DesiredCapabilities capability;


    public void beforeTest(String browser) throws MalformedURLException {
        //Load Docker Machine ip and selenium hub port from config.properties
        PropertiesFile config = new PropertiesFile();
        String hubURL = "http://" + config.getDockerMachineIp() + ":" + config.getSeleniumHubPort() + "/wd/hub";

        System.out.println("BROWSER : " + browser);
        if(browser.equals("chrome")) {
            capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
        }else if(browser.equals("firefox")){
            capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
        }
        driver = new RemoteWebDriver(new URL(hubURL), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void afterTest(){
        if(driver !=null)
            driver.quit();
    }

}
