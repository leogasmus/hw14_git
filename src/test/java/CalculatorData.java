import org.testng.annotations.DataProvider;

public class CalculatorData {
    @DataProvider
    public Object [][] getDataForAdd() {
        return new Object[][] {
                {2, 5, 7},
                {8, 11, 19},
                {1, 1, 2}
        };
    }
    @DataProvider
    public Object [][] getDataForSubtraction() {
        return new Object[][] {
                {12, 5, 7},
                {3, 6, -3},
                {1, 1, 0}
        };
    }
    @DataProvider
    public Object [][] getDataForMultiply() {
        return new Object[][] {
                {3, 5, 15},
                {10, 6, 60},
                {0, 0, 0}
        };
    }
    @DataProvider
    public Object [][] getDataForDivision() {
        return new Object[][] {
                {12, 4, 3},
                {49, 7, 7},
                {20, 4, 5}
        };
    }

}
