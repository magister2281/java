package it.hillel.superqajobsearch;

import it.hillel.superqajobsearch.pages.HHSearchPage;
import it.hillel.superqajobsearch.pages.Job;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleTest {

    @BeforeClass
    public void beforeMethod() {}
    @Test
    public void testMethod() {
        String position = "QA";
        List<Job> result = HHSearchPage.getResult(position);
        for (Job job: result) {
            Assert.assertTrue(job.getTitle().toLowerCase().contains(position.toLowerCase())||
                    job.getDescription().toLowerCase().contains(position.toLowerCase()));
        }

    }
    @AfterClass
    public void afterMethod() {
        WebDriverInit.stop();
    }
}
