public class PairSum1 {
    //sorted array or arraylist
    static int[] parisum(int[] nums,int target){
        int lp=0;
        int rp= nums.length -1 ;
        int[] newarr=new int[2];
        while (lp!=rp){
            int add=nums[lp]+nums[rp];
            if(add==target){
                newarr[0]=lp;
                newarr[1]=rp;
            }
            if(add<target) lp++;
            else  rp--;
        }

        return newarr;
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[]result= parisum(numbers,target);
        if (result[0] != -1 && result[1] != -1)
            System.out.println("Indices of the pair: " + result[0] + ", " + result[1]);
        else
            System.out.println("Pair not found.");

    }
}
