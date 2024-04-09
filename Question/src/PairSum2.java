//Search in a given sorted and rotated array [11,15,16,8,9,10] target 15
// step : 1.find pvoit
//        2. two pointer app. but lp++ relpace by lp=(lp+1)%n   and rp-- repalce by rp=(n+rp-1)%n
public class PairSum2 {
    static boolean pairtwo(int[] nums,int k){


        int n= nums.length;
        int pviot=0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>nums[i+1]) pviot=i; break;
        }

        //two pointer app.
        int lp=0;
        int rp= nums.length-1;
        while (lp<=rp){
            int add=nums[lp]+nums[rp];
            if(add==k) {
                return true;
            }
            if(add<k) lp=(lp+1)%n;
            else rp=(n+rp-1)%n;
        }
        return false;
    }
    static  boolean pairsum2(int arr[],int k){

        int n= arr.length;
        int privot=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>arr[i+1]){
                privot=i;
                break;
            }
        }

        int lp=privot+1;
        int rp=privot;
        while (lp!=rp){
            if(arr[lp]+arr[rp] == k) return true;
            if (arr[lp]+arr[rp] < k) {
                lp=(lp+1)%n;
            }else rp=(n+rp-1)%n;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] number={10,15,3,7};
        int target=17;
        System.out.println(pairtwo(number,target));
        System.out.println(pairsum2(number,target));
    }
}
