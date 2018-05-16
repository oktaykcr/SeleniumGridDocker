package com.tutorial.seleniumgriddocker.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

    private WebDriver driver;
    private Logger log = Logger.getLogger(GooglePage.class);

    @FindBy(css = "input[id='lst-ib']")
    private WebElement searchInput;

    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchInput(String text){
        log.info("Typing '"+text+"' to the search box...");
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ESCAPE);
    }

    public void clickLuckyButton(){
        log.info("Clicking to the feeling lucky button...");
        WebElement luckyButton = driver.findElement(By.cssSelector("input[name='btnI']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(luckyButton));
        luckyButton.click();
    }

    public void search(String text){
        enterSearchInput(text);
        clickLuckyButton();
    }

}
