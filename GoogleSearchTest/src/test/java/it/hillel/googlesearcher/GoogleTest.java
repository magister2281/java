package it.hillel.googlesearcher;

import it.hillel.googlesearcher.pages.GoogleSearchePage;
import it.hillel.googlesearcher.pages.Platon;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleTest {


    @BeforeClass
    public  void beforeMethod() {}
    @Test
    public void  testMethod() {
        String word  = "Oklahoma State";
        List<Platon> result = GoogleSearchePage.getResult(word);
        for (Platon platon:result) {

//            Assert.assertTrue(platon.getTitle().toLowerCase().contains(word.toLowerCase())||
//                    platon.getDescription().toLowerCase().contains(word.toLowerCase()));
            System.out.println(platon.getTitle());
//            System.out.println(platon.getLink());
            System.out.println(platon.getDescription());
            System.out.println("Hello");



        }

    }
    @AfterClass
    public  void afterMethod() {
//        WebDriverInit.stop();

    }
}
