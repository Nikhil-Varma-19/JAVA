import java.util.Arrays;

public class CountSort {

     static int findMaxNo(int[] nums){
        int max = nums[0];
        for(int num : nums){
            if(num > max) max = num;
        }
        return max;
    }

    static void basicCountSort(int[] nums){

        int maxNo = findMaxNo(nums);

        int[] counts = new int[maxNo + 1];

        for(int num : nums){
            counts[num]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

        int[] res = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--){
            int indx = counts[nums[i]] - 1;
            res[indx] = nums[i];
            counts[nums[i]]--;
        }

        for(int i = 0; i < nums.length;i++){
            nums[i] = res[i];
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,8,7,9,5,4,2,1,6};
        basicCountSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
