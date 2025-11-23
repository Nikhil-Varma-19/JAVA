import java.sql.SQLOutput;
import java.util.*;

public class NumberSystem {
    static int binaryTodecimal1(int n) {
        int ans = 0;
        //1.Method  // input has number
        int pw = 1;//2^0 =1

        while (n > 0) {
            int unit_digit = n % 10;
            ans += unit_digit * pw;
            n /= 10;
            pw *= 2;
        }

        return ans;
    }

    static int base2tobase61(int n) {
        int num = binaryTodecimal1(n);
        int ans = 0;
        int multpy = 1;
        while (num > 0) {
            int sameUnit_index = (num % 6);
            ans += sameUnit_index * multpy;
            num /= 6;
            multpy *= 10;
        }

        return ans;
    }

    static int base2tobase62(String s){
        int ans=0;
        int num=binaryTodecimal2(s);
        int multpy = 1;
        while (num > 0) {
            int sameUnit_index = (num % 6);
            ans += sameUnit_index * multpy;
            num /= 6;
            multpy *= 10;
        }

        return ans;
    }

    static int binaryTodecimal2(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans = ans * 2 + (s.charAt(i) - '0');
        }
        return ans;
    }


    public static int decimalTobinary(int n) {

        if (n == 0) return 0;

        int ans = decimalTobinary(n / 2) * 10 + n % 2;

        return ans;

    }


    public static void main(String[] args) {


         int binary_no = 100111;
        String num = "100111";
        //   System.out.println(binaryTodecimal1(binary_no));
      //  System.out.println(binaryTodecimal2(num));
          System.out.println(base2tobase61(binary_no));
        System.out.println(base2tobase62(num));


//        System.out.print("Enter dicemal no:");
//        int decimal_no = sc.nextInt();
//        System.out.println(decimalTobinary(decimal_no));


    }


}
