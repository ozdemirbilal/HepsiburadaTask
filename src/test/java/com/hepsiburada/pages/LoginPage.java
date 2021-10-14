package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(id = "txtUserName")
    public WebElement emailBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "btnEmailSelect")
    public WebElement loginEmailSelect;

    @FindBy(xpath = "//input[@placeholder='Şifre']")
    public WebElement loginPasswordSelect;

    @FindBy(xpath = " //span[.='Şifremi unuttum']")
    public WebElement loginText1;

    @FindBy(xpath = " //span[.='Yardıma ihtiyacım var']")
    public WebElement loginText2;



    public void login(String email, String password){
        email = ConfigurationReader.get("email");
        password= ConfigurationReader.get("password");

        try {
            if (loginText1.isDisplayed()){
                emailBox.sendKeys(email);
                passwordBox.sendKeys(password);
                loginButton.click();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if(loginText2.isDisplayed()){

                BrowserUtils.clickWithJS(emailBox);
                emailBox.sendKeys(email);
                loginButton.click();
                BrowserUtils.waitFor(2);
                loginPasswordSelect.sendKeys(password);
                loginEmailSelect.click();

            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
