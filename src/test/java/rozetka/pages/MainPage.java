package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class MainPage extends BasePage {
    public final String BASE_URL = "https://rozetka.com.ua/ua/";

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//form/button")
    private WebElement searchButton;

    @FindBy(xpath = "//rz-cart//rz-icon-badge/span")
    private WebElement cartCount;


    public MainPage() {
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void fillSearchInputAndSearch(String q) {
        searchInput.sendKeys(q);
        searchButton.click();
    }

    public int getQuantityItemInCart() {
        return Integer.parseInt(cartCount.getText());
    }
}
