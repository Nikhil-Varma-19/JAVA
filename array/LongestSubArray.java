import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArray {
    /*
    Input: ‘n’ = 7 ‘k’ = 3
            ‘a’ = [1, 2, 3, 1, 1, 1, 1]

    Output: 3

    Explanation: Subarrays whose sum = ‘3’ are:

            [1, 2], [3], [1, 1, 1] and [1, 1, 1]

    Here, the length of the longest subarray is 3, which is our final answer.

     */

    private static int  longestSubarrayForBoth(int[]  nums,int k){
        // Using the prefix sums
        int res=0;
        int prefSum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        for (int i = 0; i < nums.length; i++) {
            prefSum+=nums[i];
            // If prefixSum - k exists in the map then there exist such
            // subarray from (index of previous prefix + 1) to i.
            if(map.containsKey(prefSum - k)){
                res = Math.max(res, i - map.get(prefSum - k));
            }else {
                // Store only first occurrence index of prefSum
                map.put(prefSum,i);
            }
        }


        return  res;
    }

    private static int  longestSubarrayTwoPointer(int[] nums,int k){
        int maxLen=0;
        int left=0,right=0;
        int sum=nums[0];

        while (right < nums.length){
            while (sum > k){
                sum-=nums[left];
                left++;
            }
            if(sum == k) maxLen=Math.max(maxLen,right - left + 1);
            if(right < nums.length) sum+=nums[right];
            right++;

        }


        return maxLen;
    }

    public static int totalSubarray(int[] nums, int k){
        int count=0;
        int total=0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
            if(mp.containsKey(total - k)){
                count+=mp.get(total -k);
            }
                mp.put(total,mp.getOrDefault(total,0)+1);

        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums={1,1,1};
        int k=2;
        System.out.println(longestSubarrayForBoth(nums,k));
        System.out.println(longestSubarrayTwoPointer(nums,k));


    }
}
