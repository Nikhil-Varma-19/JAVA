import java.util.Scanner;
/*
*  Tiling Problem (Recurision) Apna College
* "2xn" board given and tiles "2x1" each size where you  have to find how many where the tiles can be done in the boat
*eg: n= 3
* o/p : ways = 3
* */
public class Tiling {

    static  int tilesway(int n){

        if( n==0 || n==1) return 1;

        int toatalWays=tilesway(n-1)+tilesway(n-2);
        return  toatalWays;

    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.printf("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Total ways: "+tilesway(n));

    }
}
