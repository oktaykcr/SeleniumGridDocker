package com.tutorial.seleniumgriddocker.testsuites;

import com.tutorial.seleniumgriddocker.base.BaseUITestCase;
import com.tutorial.seleniumgriddocker.components.GooglePage;
import com.tutorial.seleniumgriddocker.components.SeleniumPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GoogleSearchTest extends BaseUITestCase {

    private GooglePage googlePage;
    private SeleniumPage seleniumPage;

    @Parameters({ "browser" })
    @BeforeTest
    public void before(String browser){
        try {
            beforeTest(browser);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void after(){
        afterTest();
    }

    @Test
    public void simpleGoogleSearhTest(){
        driver.get(googleURL);
        googlePage = new GooglePage(driver);
        googlePage.search("selenium grid");
        seleniumPage = new SeleniumPage(driver);
        Assert.assertEquals(driver.getTitle(), "Selenium Grid");
        seleniumPage.printHeaderText();
    }

}
