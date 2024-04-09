import java.util.HashSet;

public class countDistinctELe {
    // no. of distinct element is ans
    private static void reverseDistnct(int arr[]){
        /*
        Input: nums = [1,13,10,12,31]
        Output: 6
        Explanation: After including the reverse of each number, the resulting array is [1,13,10,12,31,1,31,1,21,13].
        The reversed integers that were added to the end of the array are underlined. Note that for the integer 10, after reversing it, it becomes 01 which is just 1.
        The number of distinct integers in this array is 6 (The numbers 1, 10, 12, 13, 21, and 31).
*/
        HashSet<Integer> newSet=new HashSet<>();
       int[] newarr=new int[2*arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i]=arr[i];
            newSet.add(arr[i]);
            int reverse=0;
            int nums=arr[i];
           if(nums>9){
               while(nums>  0){
                   int digit =nums%10;
                   reverse=reverse*10+digit;
                   nums/=10;
               }
           }
           else{
               reverse=nums;
           }

           newarr[arr.length+i]=reverse;
            newSet.add(reverse);
        }
//        System.out.println("New Array");
//        for (int i = 0; i < newarr.length; i++) {
//            System.out.print(newarr[i]+" ");
//        }

        System.out.println();
        System.out.println("Distinct No: "+newSet.size());

    }
    public static void main(String[] args) {
    /*    int arr[]={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> sett=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            sett.add(arr[i]);
        }

        System.out.println("Ans is: "+sett.size());*/
        int array[]={1,13,10,12,31};
        reverseDistnct(array);
    }
}
