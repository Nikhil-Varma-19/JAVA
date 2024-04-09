public class patternABCD {
    static  void pattern8(int n){
     /* A
        B C
        D E F
        G H I J
        K L M N O */
        char ch ='A';
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }//
    /*
    A
    B B
    C C C
    D D D D
    E E E E E
     */

    private static void pattern1(int n){
        char ch='A';
        for (int i = 1; i <=n ; i++) {
            for (int j=1;j<=i;j++){
                System.out.print(ch+" ");

            }
            ch++;
            System.out.println();
        }
    }//
    /*
    A
    AB
    ABC
    ABCD
    ABCDE

    Note : outer loop should start with 0 so A+0 will be A
            A+1 will be A and B
            A+2 will be A,B and C
     */
    private  static void pattern2(int n){
        for (int i=0;i<n;i++){
            for (char ch='A';ch<='A'+i;ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }//

    private static void pattern3(int n){


        for (int i = 1; i <= n; i++) {
            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //aplh insec
            char ch='A';
            for (int k = 1; k <= i ; k++) {
                System.out.print(ch++);
            }
            ch--;
            //aplha desc
            for (int j = i-1; j >0 ; j--) {
                System.out.print(--ch);
            }

            System.out.println();
        }
    }//

    private static void pattern4(int n){
        /*
        E
        D E
        C D E
        B C D E
        A B C D E
         */
        char startChar = (char) ('A' + n - 1);
        for (int i = 0; i <n ; i++) {
//            for (char ch = (char)('E' - i); ch <= 'E'; ch++) {

//                System.out.print(ch + " ");
//            }
            for (char ch = (char) (startChar - i); ch <= startChar; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int n=6;
        pattern3(n);

            }
}
