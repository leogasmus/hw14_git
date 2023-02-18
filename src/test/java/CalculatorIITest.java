import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorIITest implements IBaseTestSuit, IBaseTest {
    @Test(dataProvider = "getDataForAdd", dataProviderClass = CalculatorData.class)
    public void addTest(int arg1, int arg2, int expectedResult) {
        Assert.assertEquals(arg1 + arg2, expectedResult);
    }

    @Test(dataProvider = "getDataForSubtraction", dataProviderClass = CalculatorData.class)
    public void subtractionTest( int arg1, int arg2, int expectedResult){
        Assert.assertEquals(arg1 - arg2, expectedResult);
    }

    @Test(dataProvider = "getDataForMultiply", dataProviderClass = CalculatorData.class)
    public void multiplyTest(int arg1, int arg2, int expectedResult) {
        Assert.assertEquals(arg1 * arg2, expectedResult);
    }
    @Test(dataProvider = "getDataForDivision", dataProviderClass = CalculatorData.class)
    public void divisionTest(int arg1, int arg2, int expectedResult) {
        Assert.assertEquals(arg1 / arg2, expectedResult);
    }

}
