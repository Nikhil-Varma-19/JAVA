import java.util.Arrays;

public class Sort012 {
    private static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums ={2,0,2,1,1,0};
        int start=0,middle=0,end=nums.length -1;
        while( middle  < end){
            if(nums[middle] == 0){
                swap(start,middle,nums);
                start++;
                middle++;
            }else if(nums[middle] == 2){
                swap(middle,end,nums);
                end--;
            }else{
                middle++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
