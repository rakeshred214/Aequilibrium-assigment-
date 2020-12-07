package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class BasePage {
    public WebDriver driver = DriverFactory.getDriver();

    public boolean isPageLoaded(WebElement elem) {

        boolean isLoaded = false;

        try { isLoaded = elem.isDisplayed(); }
        catch (org.openqa.selenium.NoSuchElementException e) {}

        return isLoaded;
    }


}
