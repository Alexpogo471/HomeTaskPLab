import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestMain {

    Main main;

    @BeforeClass
    public void setUp() {
        main = new Main();
    }

    @BeforeMethod
    private void idThread() {
        System.out.println((Thread.currentThread().getId()));
    }


    //--------------- Successful Tests -------------------

    @DataProvider(name = "DecimalBinaryProvider")
    public Object[][] DecimalBinaryProvider() {
        return new Object[][]{
                {145, "10010001"}, {67, "1000011"}, {33, "100001"}, {112, "1110000"}
        };
    }

    @Test(description = "Check conversionDecimalToBinary", dataProvider = "DecimalBinaryProvider")
    public void testConversionDecimalToBinary(int number, String result) {
        Assert.assertEquals(main.conversionDecimalToBinary(number), result, "wrong conversion");
    }

    @DataProvider(name = "DecimalToHexProvider")
    public Object[][] DecimalToHexProvider() {
        return new Object[][]{
                {58, "3a"}, {144, "90"}, {298, "12a"}, {12, "c"}
        };
    }

    @Test(description = "Check conversionDecimalToHexadecimal", dataProvider = "DecimalToHexProvider")
    public void testConversionDecimalToHexadecimal(int number, String result) {
        Assert.assertEquals(main.conversionDecimalToHexadecimal(number), result, "wrong conversion");
    }

    @DataProvider(name = "BinaryToOctalProvider")
    public Object[][] BinaryToOctalProvider() {
        return new Object[][]{
                {101010, "52"}, {101, "5"}, {11010, "32"}, {111101001, "751"}
        };
    }

    @Test(description = "Check conversionDecimalToBinary", dataProvider = "BinaryToOctalProvider")
    public void testConversionBinaryToOctal(int number, String result) {
        Assert.assertEquals(main.conversionBinaryToOctal(number), result, "wrong conversion");
    }

    @DataProvider(name = "validateNumberProvider")
    public Object[][] validateNumberProvider() {
        return new Object[][]{
                {"543", true}, {"34", true}, {"1010101", true}, {"12a", true}
        };
    }

    @Test(description = "Check validateNumber", dataProvider = "validateNumberProvider")
    public void testValidateNumber(String number, Boolean result) {
        Assert.assertEquals((Object) main.validateNumber(number), result);
    }

    //--------------- Failed Tests -------------------

    @DataProvider(name = "DecimalBinaryProviderFailed")
    public Object[][] DecimalBinaryProviderFailed() {
        return new Object[][]{
                {0232, "10010001"}
        };
    }

    @Test(description = "Check testConversionDecimalToBinaryFailed", dataProvider = "DecimalBinaryProviderFailed", expectedExceptions = AssertionError.class)
    public void testConversionDecimalToBinaryFailed(int number, String result) {
        Assert.assertEquals(main.conversionDecimalToBinary(number), result, "wrong conversion");
    }

    @DataProvider(name = "BinaryToOctalProviderFailed")
    public Object[][] BinaryToOctalProviderFailed() {
        return new Object[][]{
                {5344, "5"}
        };
    }

    @Test(description = "Check testConversionBinaryToOctalFailed", dataProvider = "BinaryToOctalProviderFailed",expectedExceptions = AssertionError.class)
    public void testConversionBinaryToOctalFailed(int number, String result) {
        Assert.assertEquals(main.conversionBinaryToOctal(number), result, "wrong conversion");

    }

    @DataProvider(name = "validateNumberProviderFailed")
    public Object[][] validateNumberProviderFailed() {
        return new Object[][]{
                {"56hgmn", true}
        };
    }

    @Test(description = "Check testValidateNumberFailed", dataProvider = "validateNumberProviderFailed",expectedExceptions = AssertionError.class)
    public void testValidateNumberFailed(String number, Boolean result) {
        Assert.assertEquals((Object) main.validateNumber(number), result);
    }
}
