public class factorail {
    static int factorial(int n){
        if(n==0 ||n==1 ){
            return 1;
        }


        return n*factorial(n-1);
    }
    public static void main(String argu[]){
        int n=5;
       int ans= factorial(n);
       System.out.println(ans);
    }
}
