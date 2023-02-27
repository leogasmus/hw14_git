import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Починається тестування " + iTestResult.getName());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Закінчилось тестування " + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Почалося виконання тестового набору: "+ iTestContext.getName());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Виконання тестового набору завершилося: " + iTestContext.getName());

    }
}
