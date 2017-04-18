package com.akamai.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobsInKraPage {
    private WebDriver driver;
    private ElementToWait elemToWait;

    @FindBy(className="total_results")
    private WebElement totalResult;

    public JobsInKraPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getTotalResult() {
        elemToWait = new ElementToWait(driver);
        elemToWait.waitForElementPresent(totalResult, 10);
        return Integer.parseInt(totalResult.getText());
    }


    public int getNumberOfPostedJobs(String titleOfJob) {
        List<WebElement> jobs = driver.findElements(By.partialLinkText(titleOfJob));
        return jobs.size();

    }

    public void clickFirstPostedJob(String titleOfJob) {
        List<WebElement> jobs = driver.findElements(By.linkText(titleOfJob));
        jobs.get(0).click();
    }

}
