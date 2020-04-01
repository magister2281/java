package it.hillel.superqajobsearch;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\apps\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setCapability("pageLoadStrategy", "eager");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }
    public static void stop() {
        driver.quit();
    }
}
