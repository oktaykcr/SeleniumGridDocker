package com.tutorial.seleniumgriddocker.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {

    private WebDriver driver;
    private Logger log = Logger.getLogger(SeleniumPage.class);

    @FindBy(css = "div[id ='header']")
    private WebElement header;

    public SeleniumPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("Current URL : " + driver.getCurrentUrl());
    }

    public void printHeaderText(){
        log.info(header.getText());
    }
}
