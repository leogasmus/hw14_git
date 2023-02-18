import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public interface IBaseTest {
    @BeforeMethod
    default void startTest(Method testMethod) {
        System.out.println("Починається тестування " + testMethod.getName());
    }

    @AfterMethod
    default void finishTest(Method testMethod) {
        System.out.println("Закінчилось тестування " + testMethod.getName());
    }
}
