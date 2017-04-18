package com.akamai.jobs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class CareersMainPage {
    private WebDriver driver;
    private String url = "https://akamaijobs.referrals.selectminds.com/";

    @FindBy(id="keyword")
    WebElement searchKeyword;

    @FindBy(id="loc_placeholder")
    WebElement searchLocation;

    @FindBy(id="jSearchSubmit")
    WebElement searchSubmit;

    public CareersMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(url);
    }

    public void setJobKeyword(String keyword) {
        searchKeyword.sendKeys(keyword);

    }

    public void setJobLocation(String location) {
        searchLocation.click();

        Actions action = new Actions(driver);
        action.sendKeys(Keys.DELETE);
        action.sendKeys(location);
        action.sendKeys(Keys.ARROW_DOWN);
        action.sendKeys(Keys.ENTER);
        action.perform();
    }

    public void clickSearchButtom() {
        searchSubmit.click();
    }

    public void searchForJob(String keyword, String location) {
        this.setJobKeyword(keyword);
        this.setJobLocation(location);
        this.clickSearchButtom();
    }

}
