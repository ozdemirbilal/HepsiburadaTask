package com.hepsiburada.stepDefinitions;

import com.hepsiburada.pages.*;
import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import com.hepsiburada.utilities.Driver;
import com.hepsiburada.utilities.Log4j;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static org.junit.Assert.*;

public class WithLoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Given("Navigate to home page")
    public void navigate_to_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickability(homePage.girisYap,10);
        Log4j.info("Opening Page : " + ConfigurationReader.get("url"));

    }

    @Given("Go to login page")
    public void go_to_login_page() {
        BrowserUtils.hover(homePage.girisYap);
        homePage.login.click();
        BrowserUtils.waitForClickability(loginPage.emailBox,10);
        Log4j.info("Go to login page");
    }

    @When("Send valid {string} and {string}")
    public void send_valid_and(String email, String password) {

        loginPage.login(email,password);
        Log4j.info("Send valid email and password");
    }


    @Then("Verify that user can login")
    public void verify_that_user_can_login() {
        BrowserUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(homePage.hesabım);
        Log4j.info("Verify that user can login");

    }

    @When("Search to buy a {string}")
    public void search_to_buy_a(String product) {
        homePage.searchBox.sendKeys(product, Keys.ENTER);
        Log4j.info("Search to buy a "+product);

    }

    @When("Choose one product on search page")
    public void choose_one_product_on_search_page() {
        BrowserUtils.waitFor(2);
        searchPage.chooseRandomPruduct();
        Log4j.info("Choose one product on search page");


    }

    @When("Add the product to basket from {int} vendor")
    public void add_the_product_to_basket_from_vendor(int vendor) {
        BrowserUtils.waitFor(1);
        productPage.addProductFromVendors(vendor);
        Log4j.info("Add the product to basket from "+vendor +" vendor");

    }

    @Then("Verify that {int} product in basket")
    public void verify_that_product_in_basket(int expectedUrun) {
        BrowserUtils.waitFor(2);
        homePage.sepetim.click();
        BrowserUtils.waitFor(3);
        int actualUrun = Integer.parseInt(basketPage.urunSayısı.getText());
        Assert.assertEquals(expectedUrun,actualUrun);
        Log4j.info("Verify that "+expectedUrun +" product in basket");
    }


}


