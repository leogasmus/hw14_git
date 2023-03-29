package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(xpath = "//rz-purchases/ul/li[1]/rz-cart-product/div/div[1]/div/a")
    private WebElement firstElement;

    @FindBy(xpath = "//rz-purchases/ul/li[2]/rz-cart-product/div/div[1]/div/a")
    private WebElement secondElement;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }


}
