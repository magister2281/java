package it.hillel.superqajobsearch.pages;

import it.hillel.superqajobsearch.WebDriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HHSearchPage {
    private static WebDriver driver = WebDriverInit.get();
    private static String url = "https://odessa.hh.ua/";

    private static By searchField = By.cssSelector("input[data-qa='search-input']");
    private static By item = By.cssSelector("div.vacancy-serp-item");
    private static By jobTitle = By.cssSelector("a[data-qa='vacancy-serp__vacancy-title']");
    public static By jobCompany = By.cssSelector("A[data-qa='vacancy-serp__vacancy-employer']");
    private static By jobDescription = By.cssSelector("div:not(.vacancy-serp-item__row_header) > div.vacancy-serp-item__info");
    private static By jobDate = By.cssSelector("span.vacancy-serp-item__publication-date");

    public static List<Job> getResult(String word) {
        driver.get(url);
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(item);
        List<Job> result = new ArrayList<Job>();
        for (WebElement el: elements) {
            String title = el.findElement(jobTitle).getText();
            String company = el.findElement(jobCompany).getText();
            String description = el.findElement(jobDescription).getText();
            String date = el.findElement(jobDate).getText();
            String link = el.findElement(jobTitle).getAttribute("href");
            Job job = new Job(title,company,description,date,link);
            result.add(job);
        }

        return result;
    }
}
