package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//section//rz-grid//ul//li[3]")
    private WebElement searchedItem;

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    public void goToProduct() {
        searchedItem.click();
    }
}

