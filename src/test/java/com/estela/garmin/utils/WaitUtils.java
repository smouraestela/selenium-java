package com.estela.garmin.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Duration TIMEOUT_PADRAO = Duration.ofSeconds(10);

    public static WebElement waitUntilVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT_PADRAO)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT_PADRAO)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    
}
