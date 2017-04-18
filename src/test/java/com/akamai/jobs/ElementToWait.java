package com.akamai.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementToWait {
    private WebDriver driver;
    WebDriverWait wait;

    public ElementToWait(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementPresent(WebElement elem, int timeout) {
        wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(elem));
        } catch (Exception e) {
            System.out.println("Element not found: " + elem);
        }
    }
}
