import java.util.Arrays;

public class Main {

    static void printNumber(int n) {
        if (n == 0) return;
        // print 10 9 8 7
//        System.out.println(n);
        printNumber(n - 1);
        // print 1 2 3 4
        System.out.println(n);

    }

    static int factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }

    static void reverseArray(int[] nums, int i, int j) {
        if (i > j) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        swap(i, j, nums);
        reverseArray(nums, i + 1, j - 1);
    }


    public static void main(String[] args) {
        int n = 10;
//        printNumber(n);
        System.out.println(factorial(n));

//        int[] nums = {5, 4, 3, 2, 1};
//        reverseArray(nums, 0, nums.length - 1);




    }

    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}