package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[.='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(id = "login")
    public WebElement login;

    @FindBy(xpath = "//span[.='Hesabım']")
    public WebElement hesabım;

    @FindBy(xpath = "//div[@id='SearchBoxOld']//input")
    public WebElement searchBox;

    @FindBy(css = "#shoppingCart")
    public WebElement sepetim;


    public void navigateToModule(String tab, String module) {
        String tabLocator = "//*[text()='"+tab+"']";
        String moduleLocator = "//*[text()='"+module+"']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)), 5);
        }
    }


}
