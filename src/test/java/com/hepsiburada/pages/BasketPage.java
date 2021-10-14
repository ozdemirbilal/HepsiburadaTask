package com.hepsiburada.pages;

import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    public BasketPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#basket-item-count")
    public WebElement urunSayısı;


}
