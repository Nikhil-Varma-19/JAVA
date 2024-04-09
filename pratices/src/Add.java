import java.lang.reflect.Array;
import java.util.Arrays;

public class Add {
    private static boolean Contain(int arr[],int target){
        //base cases
        if(arr.length == 0) return target==0;

        int first=arr[0];
        int leftarr[]=Arrays.copyOfRange(arr,1,arr.length);

        return Contain(leftarr,target-first) || Contain(leftarr,target);
    }
    private static String addtoget(int arr[]){
        Arrays.sort(arr);

        int largest_no= arr[arr.length-1];
        int newArr[]=Arrays.copyOf(arr,arr.length-1);

        if( Contain(newArr,largest_no)){
            return "true";
        }
        return "false";
    }
    public static void main(String[] args) {
        int arr[]={5, 7, 16, 1, 2};
        System.out.println(addtoget(arr));
    }
}
/*
Have the function ArrayAdditionI(arr) take the array of numbers stored in arr
and return the string true if any combination of numbers in the array can be
added up to equal the largest number in the array, otherwise return the string
false. For example: if arr contains [4, 6, 23, 10, 1, 3] the output should
return true because 4 + 6 + 10 + 3 = 23. The array will not be empty, will not
contain all the same elements, and may contain negative numbers.

Examples:

Input: [5, 7, 16, 1, 2]
Output: false

Input: [3, 5, -1, 8, 12]
Output: true
 */
