package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InventoryPage extends BasePage{

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    private WebElement logOut;

    @FindBy(css = "#inventory_container")
    private WebElement inventoryContainerElem;

    @FindBy(xpath = "//*[@id='item_1_img_link']/img")
    private WebElement ImageLink1;

    @FindBy(xpath = "//*[@id='item_2_img_link']/img")
    private WebElement ImageLink2;

    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserOnInventoryPage() {
        Assert.assertTrue(inventoryContainerElem.isDisplayed());
        Assert.assertTrue(shoppingCartElem.isDisplayed());
    }

    public void logout() {
        hamburgerElem.click();
        logOut.click();
    }

    public void verifyBrokenImage() {
        Assert.assertTrue(ImageLink1.getAttribute("src").contains("WithGarbageOnItToBreakTheUrl"));
        Assert.assertTrue(ImageLink2.getAttribute("src").contains("WithGarbageOnItToBreakTheUrl"));
    }
}
