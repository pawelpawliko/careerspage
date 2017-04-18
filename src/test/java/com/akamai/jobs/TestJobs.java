package com.akamai.jobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestJobs {

    private WebDriver driver;
    private CareersMainPage mainPage;
    private JobsInKraPage testJobPage;
    private SoftwareDevLunaPage softwDevLunaPage;

    private String keyword = "test";
    private String location = "Krakow, Poland";
    private String titleOfJob = "Software Development Engineer in Test";
    private String titleOfJobLuna = "Software Development Engineer in Test - LUNA";
    private String date = "Jan 16, 2017";


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void TestCareers() {
        mainPage = new CareersMainPage(driver);
        mainPage.searchForJob(keyword, location);

        testJobPage = new JobsInKraPage(driver);
        assertEquals(testJobPage.getTotalResult(), 42);
        assertEquals(testJobPage.getNumberOfPostedJobs(titleOfJob), 5);
        testJobPage.clickFirstPostedJob(titleOfJobLuna);

        softwDevLunaPage = new SoftwareDevLunaPage(driver);
        assertEquals(softwDevLunaPage.getDate(), date);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
