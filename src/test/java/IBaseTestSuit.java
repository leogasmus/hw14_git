import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface IBaseTestSuit {
    @BeforeSuite
    default void setUp() {
        System.out.println("Почалося виконання тестового набору");
    }
    @AfterSuite
    default void tearDown() {
        System.out.println("Виконання тестового набору завершилося");
    }
}
