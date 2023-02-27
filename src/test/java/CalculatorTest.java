import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {
    @Test/*(dataProvider = "getDataForAdd", dataProviderClass = CalculatorData.class)*/
    @Parameters({"firstParam","secondParam", "Result"})
    public void addTest(String arg1, String arg2, String expectedResult) {
        Assert.assertEquals(Integer.parseInt(arg1) + Integer.parseInt(arg2), Integer.parseInt(expectedResult));
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
