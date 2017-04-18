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

    private static final String KEYWORD_TO_FIND = "test";
    private static final String LOCATION_TO_FIND = "Krakow, Poland";
    private static final String TITLE_OF_JOB = "Software Development Engineer in Test";
    private static final String TITLE_OF_JOB_LUNA = "Software Development Engineer in Test - LUNA";
    private static final String DATE_OF_CREATING_JOB = "Jan 16, 2017";
    private static final int EXPECTED_NUMBER_TOTAL_RESULT = 42;
    private static final int EXPECTED_NUMBER_OF_POSTED_JOBS = 5;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void TestCareers() {
        mainPage = new CareersMainPage(driver);
        mainPage.searchForJob(KEYWORD_TO_FIND, LOCATION_TO_FIND);

        testJobPage = new JobsInKraPage(driver);
        assertEquals(testJobPage.getTotalResult(), EXPECTED_NUMBER_TOTAL_RESULT);
        assertEquals(testJobPage.getNumberOfPostedJobs(TITLE_OF_JOB), EXPECTED_NUMBER_OF_POSTED_JOBS);
        testJobPage.clickFirstPostedJob(TITLE_OF_JOB_LUNA);

        softwDevLunaPage = new SoftwareDevLunaPage(driver);
        assertEquals(softwDevLunaPage.getDate(), DATE_OF_CREATING_JOB);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
