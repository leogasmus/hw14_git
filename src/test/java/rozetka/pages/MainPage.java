package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPage extends BasePage {
    public final String BASE_URL = "https://rozetka.com.ua/ua/";

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//form/button")
    private WebElement searchButton;

    @FindBy(xpath = "//rz-cart//rz-icon-badge/span")
    private WebElement cartCount;

    @FindBy(xpath = "//h2[(normalize-space(text())='Найбільш обговорювані товари')]")
    private WebElement popItemsTitle;

    @FindAll({@FindBy(xpath = "//h2[(normalize-space(text())='Найбільш обговорювані товари')]/following-sibling::ul/li//a[2]")})
    private List<WebElement> discussableProductName;
    @FindAll({@FindBy(xpath = "//h2[(normalize-space(text())='Найбільш обговорювані товари')]/following-sibling::ul/li//div[@class='tile__price tile__price_color_red ng-star-inserted']")})
    private List<WebElement> discussableProductPrice;

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

    public void scrollToElement() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        int i = 0;
        while (i < 3) {
            jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            sleep();
            i++;
        }
    }

    public void showProductTitle() {
        List<String> prodNames = new ArrayList<>();
        for (int i = 0; i < discussableProductName.size(); i++ ) {
            prodNames.add(discussableProductName.get(i).getText());
        }

        List<String> prodPrices = new ArrayList<>();
        for (int i = 0; i < discussableProductPrice.size(); i++ ) {
            prodPrices.add(discussableProductPrice.get(i).getText());
        }

        for (int i = 0; i < prodNames.size(); i++) {
            System.out.println(prodNames.get(i) + " коштує " + prodPrices.get(i) + " гривень.");
        }
    }

    public Map<String, String> getProduct(){
        return new HashMap<String, String>(){{
            for (int i = 0; i < discussableProductName.size(); i++ ) {
                put(discussableProductName.get(i).getText(), discussableProductPrice.get(i).getText());
            }
        }};
    }

}
