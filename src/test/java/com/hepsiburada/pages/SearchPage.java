package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@id='cac-favorite']/../li")
    public List<WebElement> productList1;

    @FindBy(xpath = "//ul[@id='1']/li")
    public List<WebElement> productList2;

    @FindBy(xpath = "//div[text()='Drone Yedek Parçaları']")
    public WebElement droneYedekParcaları;

    @FindBy(xpath = "//div[@id='ProductList']//li")
    public List<WebElement> droneProductList;


    public void chooseRandomPruduct(){

        try {
            Random rd = new Random();
            int random = rd.nextInt(productList1.size());
            BrowserUtils.scrollToElement(productList1.get(random));
            BrowserUtils.waitFor(1);
            productList1.get(random).click();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Random rd = new Random();
            int random = rd.nextInt(productList2.size());
            BrowserUtils.scrollToElement(productList2.get(random));
            BrowserUtils.waitFor(1);
            productList2.get(random).click();
        }catch (Exception e){
            e.printStackTrace();
        }




    }

    public void chooseRandomDronePruduct(){
        Random rd = new Random();
        int random = rd.nextInt(droneProductList.size());
        BrowserUtils.scrollToElement(droneProductList.get(random));
        BrowserUtils.waitFor(1);
        droneProductList.get(random).click();

    }

}
