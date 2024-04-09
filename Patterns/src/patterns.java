import java.util.Scanner;

public class patterns {
    /*       |
     -->   1
           22
           333
           4444
           55555
   */
   public static void pattern2(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    //
   /*   1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
    */
    /*
    1
    21     to get this thus reverse the    for (int j = i; j >0 ; j--) {
    321
    4321
    54321
     */
    public static void pattern1(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //

    /*

     * * * * *               1->5
     * * * *                 2->4
     * * *                   3->3
     * *                     4->2
     *                       5->1

//        so   n-row+1

     */
    public static void pattern3(int n){
        for (int i=1;i<=n;i++){
            for (int j = 1;j<=n-i+1; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
    //

    /*
    1 2 3 4 5
    1 2 3 4
    1 2 3
    1 2
    1
     */
    static  void pattern4(int n){
        // 1 method
        for (int i=1;i<=n;i++){
            for (int j = 1;j<=n-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        // 2 method
        for (int i = n; i >0 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //
    /*
    1 1 1 1 1
    2 2 2 2
    3 3 3
    4 4
    5
     */
    static  void pattern5(int n){
        for (int i=1;i<=n;i++){
            for (int j = 1;j<=n-i+1; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }//
    /*
                 *
                **
               ***
              ****
             *****

     */
    private static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
           int space=n-i;
           while(space>0){
               System.out.print(" ");
               space--;
           }
            for (int j =1 ; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }//
/*
    1
    2 3
    4 5 6
    7 8 9 10
    11 12 13 14 15

 */
    private static void pattern7(int n){
        int nums=1;
        for (int i=1;i<=n;i++){
            int j=1;
            while (j<=i){
                System.out.print(nums+" ");
                nums += 1;
                j += 1;
            }
            System.out.println();
        }
    }//


//
    private static void hallowrec(int len,int bet){
        for (int i = 1; i <= len; i++) {
            for (int j=1;j<=bet;j++){
                if(i==1 || j==1 || i==len || j== bet){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
/*
            1           row+col is even so print "1"
            01          like (3,3) have "1"
            101
            0101
            10101
 */
    private  static void Oand1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
              if((i+j)%2==0){
                  System.out.print("1");
              }
              else {
                  System.out.print("0");
              }
            }
            System.out.println();
        }
    }//
/*
                    *
                   ***
                  *****
                 *******
                *********
               ***********
              *************
             ***************

 */
    private static void pattern10(int n){
        for (int i = 1; i <= n; i++) {
            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //star
            for (int k = 1; k <= 2*i-1 ; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }//
/*

             *************
              ***********
               *********
                *******
                 *****
                  ***
                   *
 */
    private static void pattern11(int n){
//        for (int i=0;i<n;i++){
//            //space
//            for (int j=0;j<=i;j++){
//                System.out.print(" ");
//            }
//            //star
//            for (int j = 0; j < 2*n - (2*i + 1); j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        for (int i = n; i > 0; i--) {
            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //star
            for (int k = 1; k <= 2*i-1 ; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }//
    private static void diamond(int n){
        //1 half
        for (int i = 1; i <=n ; i++) {
            //space
            for (int j=1;j<= n-i;j++){
                System.out.print(" ");
            }
            //star
            for (int j = 1; j <= 2*i-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2 half
        for (int i = n; i >0 ; i--) {
            //space
            for (int j=1;j<= n-i;j++){
                System.out.print(" ");
            }
            //star
            for (int j = 1; j <= 2*i-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }//
/*

         *
         **
         ***
         ****
         *****
         ******
         *******
         ******
         *****
         ****
         ***
         **
         *

 */
    private static void pattern12(int n){
        //1 half
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //2 half
        //start with "2" bcz 1half bottom should have 2 same line
        for (int i = n; i >0 ; i--) {
            for (int j = 2; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }//

    /*                                      space
                    1        1                8
                    12      21                 6
                    123    321                  4
                    1234  4321                  2
                    1234554321                   0

     */
    private static void pattern13(int n){

        for (int i = 1; i <=n ; i++) {
            //number tri
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            //space
                int space=2*(n-i);
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            //number tri
            for (int j = i; j >0 ; j--) {
                System.out.print(j);
            }

            System.out.println();

        }
    }//
    private  static void pattern14(int n){
        //      1
        //     121
        //    12321
        for (int i = 1; i <= n; i++) {
            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //aplh insec
            int nums=1;
            for (int k = 1; k <= i ; k++) {
                System.out.print(nums++);
            }
            nums--;
            //aplha desc
            for (int j = i-1; j >0 ; j--) {
                System.out.print(--nums);
            }

            System.out.println();
        }
    }

    private static void rhombus(int n){
        //space
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private static void hallowrhombus(int n){
        //space
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=n; j++) {
                if(j==1 || j== n|| i==1 ||i==n){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }

private static void butterfly(int n){
        // note ti remove the duplicate of line start with (n-1) in 2half
        //1 half
    for (int i = 1; i <=n ; i++) {
        //number tri
        for (int j = 1; j <=i ; j++) {
            System.out.print("*");
        }
        //space
        int space=2*n - 2*i;
        for (int j = 1; j <= space; j++) {
            System.out.print(" ");
        }
        //number tri
        for (int j = i; j >0 ; j--) {
            System.out.print("*");
        }

        System.out.println();
    }
     //2 half
    for (int i = n; i >0 ; i--) {
        //number tri
        for (int j = 1; j <=i ; j++) {
            System.out.print("*");
        }
        //space
        int space=2*n - 2*i;
        for (int j = 1; j <= space; j++) {
            System.out.print(" ");
        }
        //number tri
        for (int j = i; j >0 ; j--) {
            System.out.print("*");
        }

        System.out.println();
 }
}


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter: ");
        int n =sc.nextInt();
        //pattern13(n);
       // hallowrec(5,7);
       // hallowrhombus(n);
            butterfly(n);


    }


}
