/*
Find no. of ways to reach from (0,0) to (n-1,m-1) in a nxm grid
Allowed to move : right or down
                  -> _ _ _ _
                     _ _ _ _
                     _ _ _ _
                     _ _ _ _<-

       f(x,y)=f(x+1,y)+f(x,y+1)   // down+right
 */


import java.util.Scanner;

public class GridWays {
    static int totalGridWay(int i,int j,int n,int m){
        //base
       if(i==n-1 && j==m-1) return 1; // if source is place destination

        if(i>n || j>m) return 0;

        int w1=totalGridWay(i+1,j,n,m);
        int w2=totalGridWay(i,j+1,n,m);
        int totalWays=w1+w2;
        return totalWays;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("Enter the value of n:");
        int n= sc.nextInt();
        System.out.printf("Enter the value of m:");
        int m= sc.nextInt();

        System.out.println(totalGridWay(0,0,n,m));
    }
}
