package rozetka.test;

import core.ABaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.pages.MainPage;
import rozetka.pages.ProductPage;
import rozetka.pages.ResultPage;

public class SearchTest extends ABaseTest {
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
}
