package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//rz-product-buy-btn//button")
    private WebElement buyButton;

    @FindBy(xpath = "//rz-single-modal-window/div[3]/div[1]/button")
    private WebElement closeModel;


    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
    public void addToCard() {
        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        buyButton.click();
    }
    public void closeModalCart(){
        wait.until(ExpectedConditions.elementToBeClickable(closeModel));
        closeModel.click();
    }
}
