package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement usernameElem;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordElem;

    @FindBy(xpath = "//input[@value='LOGIN']")
    private WebElement loginElem;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/h3")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void clickLogin() {
        loginElem.click();
    }

    public void enterPassword(String password) {
        passwordElem.click();
        passwordElem.clear();
        passwordElem.sendKeys(password);
    }

    public void enterUsername(String username) {
        usernameElem.click();
        usernameElem.clear();
        usernameElem.sendKeys(username);
    }

    public void hasLockedOutError() {
        isPageLoaded(errorMessage);
        Assert.assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out."));
    }

    public void hasUsernamePasswordError() {
        isPageLoaded(errorMessage);
        Assert.assertTrue(errorMessage.getText().contains("Username and password do not match any user in this service"));
    }

    public void hasEmptyFieldsError() {
        isPageLoaded(errorMessage);
        Assert.assertTrue(errorMessage.getText().contains("Username is required"));
    }

}
