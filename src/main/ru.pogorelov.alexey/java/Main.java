import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(validateNumber());
    }

    public String conversionDecimalToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String conversionDecimalToHexadecimal(int number) {
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

    public static boolean validateNumber(int number) {
        String res = String.valueOf(number);
        Pattern p = Pattern.compile("^[0-1]$");
        Pattern p2 = Pattern.compile("^[0-7]$");
        Pattern p3 = Pattern.compile("^[A-F]$");
        if (res.contains(p.toString())){
            return true;
        }
        if (res.contains(p2.toString())){
            return true;
        }
        if (res.contains(p3.toString())){
            return true;
        }
        return false;
    }
}
