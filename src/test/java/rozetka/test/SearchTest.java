package rozetka.test;

import core.ABaseTest;
import core.ConfigProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.pages.MainPage;
import rozetka.pages.ProductPage;
import rozetka.pages.ResultPage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchTest extends ABaseTest implements ConfigProvider {
    public String firstItem = "Acer Aspire";
    public String secondItem = "FREGGIA";
    @Test
    public void checkAddItemToCart() {
        MainPage mainPage = new MainPage();
        mainPage.fillSearchInputAndSearch(firstItem);

        ResultPage resultPage = new ResultPage();
        resultPage.goToProduct();

        ProductPage productPage = new ProductPage();
        productPage.addToCard();
        productPage.closeModalCart();

        mainPage.fillSearchInputAndSearch(secondItem);
        resultPage.goToProduct();
        productPage.addToCard();
        productPage.closeModalCart();


        Assert.assertEquals(mainPage.getQuantityItemInCart(), 2);

    }

    /*
    @Test
    public void checkAddItemToCartProp() throws IOException {
        List<String> products = new ArrayList<>();

        MainPage mainPage = new MainPage();
        mainPage.fillSearchInputAndSearch(System.getProperty("age"));

        ResultPage resultPage = new ResultPage();
        resultPage.goToProduct();

        ProductPage productPage = new ProductPage();
        productPage.addToCard();
        productPage.closeModalCart();

        mainPage.fillSearchInputAndSearch(secondItem);
        resultPage.goToProduct();
        productPage.addToCard();
        productPage.closeModalCart();


        Assert.assertEquals(mainPage.getQuantityItemInCart(), 2);

    }

     */

}
