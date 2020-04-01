package it.hillel.googlesearcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {
    private  static WebDriver driver;


    public static WebDriver get() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\apps\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setCapability("pageLoadStrategy", "eager");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return  driver;
}
//public static void stop(){
//        driver.quit();
//}
}
