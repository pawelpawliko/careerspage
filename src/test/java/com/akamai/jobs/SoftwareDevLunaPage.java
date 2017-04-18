package com.akamai.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SoftwareDevLunaPage {
    private WebDriver driver;
    private ElementToWait elemToWait;

    @FindBy(xpath="//dd[@class='job_post_date']/span[1]")
    private WebElement date;

    public SoftwareDevLunaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDate() {
        elemToWait = new ElementToWait(driver);
        elemToWait.waitForElementPresent(date, 5);
        return date.getText();
    }

}
