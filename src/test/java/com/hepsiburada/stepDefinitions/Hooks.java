package com.hepsiburada.stepDefinitions;

import com.hepsiburada.utilities.Driver;
import com.hepsiburada.utilities.Log4j;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Log4j.startLog("Test  is Starting");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Thread.sleep(3000);
        Driver.closeDriver();
        Log4j.endLog("Test is Ending");

    }


}
