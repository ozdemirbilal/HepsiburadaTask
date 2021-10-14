package com.hepsiburada.stepDefinitions;

import com.hepsiburada.pages.BasketPage;
import com.hepsiburada.pages.HomePage;
import com.hepsiburada.pages.SearchPage;
import com.hepsiburada.pages.ProductPage;
import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Log4j;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class WithoutLoginStepDefs {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();


    @When("The user goes to {string} {string}")
    public void the_user_goes_to(String Tab, String Module) {
        homePage.navigateToModule(Tab,Module);
        Log4j.info("The user goes to "+Tab +","+Module+" product in basket");
    }

    @When("Click on Drone Yedek Parçaları")
    public void click_on_Drone_Yedek_Parçaları() {
        BrowserUtils.waitForClickability(searchPage.droneYedekParcaları,10);
        BrowserUtils.scrollToElement(searchPage.droneYedekParcaları);
        searchPage.droneYedekParcaları.click();
        Log4j.info("Click on Drone Yedek Parçaları");

    }

    @When("Choose one drone product on search page")
    public void choose_one_drone_product_on_search_page() {
        searchPage.chooseRandomDronePruduct();
        Log4j.info("Choose one drone product on search page");
    }

    @Then("Verify that {int} drone product is added to cart")
    public void verify_that_drone_product_is_added_to_cart(int expectedUrun) {
        BrowserUtils.waitForClickability(productPage.addToCart,10);
        productPage.addToCart.click();

        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(homePage.sepetim);
        BrowserUtils.waitFor(3);
        int actualUrun = Integer.parseInt(basketPage.urunSayısı.getText());
        Assert.assertEquals(expectedUrun,actualUrun);
        Log4j.info("Verify that "+expectedUrun +" product in basket");

    }

}
