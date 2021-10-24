package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "addToCart")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@class='popup']/i")
    public WebElement closePopup;


    public void addProductFromVendors(int num){

        for (int i=1;i<=num;i++){

            try {
                BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath("//div[@class='marketplace-list']//tr["+i+"]/td//button")));
                BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//div[@class='marketplace-list']//tr["+i+"]/td//button")));
                //Driver.get().findElement(By.xpath("//div[@class='marketplace-list']//tr["+i+"]/td//button")).click();
                BrowserUtils.waitForClickability(closePopup,7);
                BrowserUtils.clickWithJS(closePopup);
                BrowserUtils.waitFor(2);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}
