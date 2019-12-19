import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


    }

    public String conversionDecimalToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public  String conversionDecimalToHexadecimal(int number) {
        return Integer.toHexString(number);
    }

    public String conversionBinaryToOctal(long number) {
        int octalNumber = 0, decimalNumber = 0, i = 0;
        while(number != 0)
        {
            decimalNumber += (number % 10) * Math.pow(2, i);
            ++i;
            number /= 10;
        }
        i = 1;
        while (decimalNumber != 0)
        {
            octalNumber += (decimalNumber % 8) * i;
            decimalNumber /= 8;
            i *= 10;
        }

        return String.valueOf(octalNumber);
    }

    public boolean validateNumber(String number) {
        try {
            Long.parseLong(number, 16);
        }
        catch (NumberFormatException num){
            try {
                Long.parseLong(number, 8);
            }
            catch (NumberFormatException num1){
                try {
                    Long.parseLong(number, 2);
                }
                catch (NumberFormatException num3){
                    return false;
                }
            }
        }
        return true;
    }
}
