package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@id='cac-favorite']/../li")
    public List<WebElement> productList;

    @FindBy(xpath = "//div[text()='Drone Yedek Parçaları']")
    public WebElement droneYedekParcaları;

    @FindBy(xpath = "//div[@id='ProductList']//li")
    public List<WebElement> droneProductList;



    public void chooseRandomPruduct(){
        Random rd = new Random();
        int random = rd.nextInt(productList.size());
        BrowserUtils.scrollToElement(productList.get(random));
        BrowserUtils.waitFor(1);
        productList.get(random).click();

    }

    public void chooseRandomDronePruduct(){
        Random rd = new Random();
        int random = rd.nextInt(droneProductList.size());
        BrowserUtils.scrollToElement(droneProductList.get(random));
        BrowserUtils.waitFor(1);
        droneProductList.get(random).click();

    }

}
