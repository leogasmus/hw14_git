package selenium.rozetka.test;

import selenium.core.ABaseTest;
import selenium.core.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.rozetka.pages.MainPage;
import selenium.rozetka.pages.ProductPage;
import selenium.rozetka.pages.ResultPage;

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
