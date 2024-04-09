public class power {
    static int optimziedpower(int a,int b){
        if(b == 0){ return 1;
        }
        int halfPower = optimziedpower(a,b/2);
        int halfPowerSq= halfPower * halfPower;
// b is odd number
        if(b % 2 != 0){
            halfPowerSq= halfPowerSq*a;
        }

        return halfPowerSq;
    }
    private static boolean PowerofTwo(int n){
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
         int a=3;
         int b=10;

         System.out.println(optimziedpower(a,b));

         // find that power of two
        int n=32;
        //System.out.println(PowerofTwo(n));
         

}
}
