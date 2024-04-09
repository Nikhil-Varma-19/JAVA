//Search in rotated sorted array
public class Sortedtarget {
    static int modifybinary(int[] nums,int target,int s,int e){

        int mid = s+(e-s)/2;

        //base

    //    if(s>=e) return -1;

        if(nums[mid]==target) return mid;
// L1
        if(nums[s]<=nums[mid]){
            // case a: left
            if(nums[s]<=target && target<=nums[mid]){
                return modifybinary(nums,target,s,mid-1);
            }
            //case b : pura right
            else {
                return modifybinary(nums,target,mid+1,e);
            }
        }
        //L2
        else {
            //case c:right
            if(nums[mid]<=target && target<=nums[e]){
                return modifybinary(nums,target,mid+1,e);
            }
            //case d: pura left
            else {
                return modifybinary(nums,target,s,mid-1);
            }

        }
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2,3};
        int target=0;
        int ans=modifybinary(arr,target,0,arr.length-1);
        System.out.println(ans);
    }
}
