public class MissingNumber {

    static int missingNumber(int[] nums){
        int allCount=0,existCount=0;
        for(int num : nums){
            existCount+=num;
        }
        allCount=nums.length * (nums.length + 1) / 2;
        return allCount - existCount;
    }

    static int missingNumberUsingXOR(int[] nums){
        int xor=0;
        for (int i = 0; i < nums.length; i++) {
           xor = xor ^ i ^ nums[i];
        }
        xor = xor ^ nums.length;
        return xor ;
    }

    public static void main(String[] args) {
        int[] nums={3,0,1};
//        int allCount=0,existCount=0;
//        for(int num : nums){
//            existCount+=num;
//        }
//        for(int i=0;i<=nums.length;i++){
//            allCount+=i;
//        }
//        System.out.println(allCount - existCount);
        System.out.println(missingNumberUsingXOR(nums));
    }
}
