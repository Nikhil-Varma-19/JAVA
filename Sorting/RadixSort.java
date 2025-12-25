import java.util.Arrays;

public class RadixSort {

    static void countingSort(int[] nums,int place){
        int[] counts = new int[10];

        for (int i = 0; i < nums.length; i++) {
            int indx = (nums[i] / place ) % 10; // make frequency array
            counts[indx]++;
        }

        // prefix sums
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

        int[] res = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--){
            int indxPlace = (nums[i] / place ) % 10; // make frequency array
            int indx = counts[indxPlace] - 1;
            res[indx] = nums[i];
            counts[indxPlace]--;
        }

        for(int i = 0; i < nums.length;i++){
            nums[i] = res[i];
        }
    }

    static void radixSort(int[] nums){

        int max =CountSort.findMaxNo(nums);

        // apply counting sort to sort element based onplace value
        for (int place = 1; max/place > 0 ; place*=10) {
                countingSort(nums,place);
        }

    }

    public static void main(String[] args) {
        int[] nums = {859,78,15,526,969,369,100};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
