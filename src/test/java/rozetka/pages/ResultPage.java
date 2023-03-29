package rozetka.pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//section//rz-grid//ul//li[3]")
    private WebElement searchedItem;

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    public void goToProduct() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(searchedItem));
        searchedItem.click();
    }
}

