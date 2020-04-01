package it.hillel.googlesearcher.pages;

import it.hillel.googlesearcher.WebDriverInit;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public  class GoogleSearchePage {
    private static WebDriver driver = WebDriverInit.get();
    private static String url = "https://www.google.com/";
    private static By searchField =By.cssSelector("input.gLFyf.gsfi");
    private static By item = By.cssSelector("div.rc");
    private static By platonTitle = By.cssSelector("h3.LC20lb.DKV0Md");
//    private static By platonlink = By.cssSelector("cite.iUh30.bc.tjvcx");
    private static By platonDescription = By.cssSelector("span.st");
    private static By platonSecondPage = By.cssSelector("a[aria-label='Page 2']");

    public static List<Platon> getResult(String word) {
        driver.get(url);
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.findElement(platonSecondPage).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(item);
        List<Platon> result = new ArrayList<>();


        for (WebElement el:elements) {
            String title = el.findElement(platonTitle).getText();
            String link = el.findElement(platonTitle).getAttribute("href");
//            String link = el.findElement(platonlink).getText();
            String description = el.findElement(platonDescription).getText();
            Platon platon = new Platon(title,link,description);
            result.add(platon);
        }

        return result;
    }
}
