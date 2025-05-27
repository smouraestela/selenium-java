package com.estela.garmin.base;

import com.estela.garmin.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.After;

public class BaseTest {
    
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}
