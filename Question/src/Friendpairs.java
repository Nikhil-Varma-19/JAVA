import java.util.Scanner;

/*(Recursion Apna college)
* Given n friends each one can remain single or can be pairs only onces.
* Find out the total no. of pairs way can be pairs
*
* eg : n =3 so a,b,c than (a b c ) single or a(b c) , (a b)c , b(a c)  sp total ways are 4
*
* */
public class Friendpairs {
    static int friendspairs(int n){

        if(n==1 || n==2) return n;

        int single = friendspairs(n-1);
        int pairs = (n-1)*friendspairs(n-2);
        int totalpairs=single+pairs;
        return totalpairs;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.printf("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Total pairs: "+friendspairs(n));
    }
}
