package selenium.rozetka.pages;

import selenium.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//section//rz-grid//ul//li[3]")
    private WebElement searchedItem;

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    public void goToProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(searchedItem));
        searchedItem.click();
    }
}

