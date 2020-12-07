package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static String browserName=Config.BROWSER;

    public DriverFactory(){
        this.driver=getDriver();
    }

    public static WebDriver createDriver() {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver getDriver () {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void closeDriver () {
        driver.quit();
    }

}
