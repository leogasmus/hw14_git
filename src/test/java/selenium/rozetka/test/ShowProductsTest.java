package selenium.rozetka.test;

import selenium.core.ABaseTest;
import org.testng.annotations.Test;
import selenium.rozetka.pages.MainPage;

public class ShowProductsTest extends ABaseTest {
    @Test
    public void showProductWithHashMap() {
        MainPage mainPage = new MainPage();
        mainPage.scrollToElement();
        mainPage.getProduct().entrySet().forEach(item -> {
            System.out.println(item.getKey() + " коштує " + item.getValue() + " гривень.");
        });
    }
    @Test
    public void showProductWithList() {
        MainPage mainPage = new MainPage();
        mainPage.scrollToElement();
        mainPage.showProductTitle();
    }
}
