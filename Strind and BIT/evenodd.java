public class evenodd {

    static void EvenandOdd(int n){
        if((n & 1 )==0){
            System.out.println("Even no. :"+n);
        }
        else System.out.println("odd no. :"+n);
    }
    static int getithBit(int n,int i){
        int bitwise=1<<i;
        if((n & bitwise)==0){
            return 0;
        }
        return 1;
    }
    public static void main(String args[]){
    /*
     * Find the number by using the bit mainpluation if the lsb is contain "1" than it is odd no. if "0" than even no.
     */
        EvenandOdd(2);
        EvenandOdd(3);

        /*
         * Find the "i"th bit in the no.
         * eg: 10 = 1010 i=2 
         * output : 0
         */

         System.out.println(getithBit(10,3));

    }
}
