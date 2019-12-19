import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestMain {

    Main main;

    @BeforeClass
    public void setUp(){
        main = new Main();
    }

    @BeforeMethod
    private void idThread(){
        System.out.println((Thread.currentThread().getId()));
    }

    @DataProvider(name = "DecimalBinaryProvider", parallel = true)
    public Object[][] DecimalBinaryProvider(){
        return new Object[][]{
                {145,"10010001"},{67,"1000011"},{33,"100001"},{112,"1110000"}
        };
    }

    @Test(description = "Check conversionDecimalToBinary", dataProvider = "DecimalBinaryProvider")
    public void testConversionDecimalToBinary(int number, String result){
        Assert.assertEquals(main.conversionDecimalToBinary(number),result,"wrong conversion");
    }

    @DataProvider(name = "DecimalToHexProvider", parallel = true)
    public Object[][] DecimalToHexProvider(){
        return new Object[][]{
                {58,"3a"},{144,"90"},{298,"12a"},{12,"c"}
        };
    }

    @Test(description = "Check conversionDecimalToHexadecimal", dataProvider = "DecimalToHexProvider")
    public void testConversionDecimalToHexadecimal(int number, String result){
        Assert.assertEquals(main.conversionDecimalToHexadecimal(number),result,"wrong conversion");
    }

    @DataProvider(name = "BinaryToOctalProvider", parallel = true)
    public Object[][] BinaryToOctalProvider(){
        return new Object[][]{
                {101010,"52"},{101,"5"},{11010,"32"},{111101001,"751"}
        };
    }

    @Test(description = "Check conversionDecimalToBinary", dataProvider = "BinaryToOctalProvider")
    public void testConversionBinaryToOctal(int number, String result){
        Assert.assertEquals(main.conversionBinaryToOctal(number),result,"wrong conversion");
    }

}