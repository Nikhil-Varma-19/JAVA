import java.util.HashMap;

public class LargestsubarrK {
    public static int Sum0(int arr[]){
        int sum=0,length=0;

        HashMap<Integer,Integer> subarr=new HashMap<>();
        for (int j = 0; j < arr.length; j++) {
            sum+=arr[j];
            if(subarr.containsKey(sum)){
                length=Math.max(length,j-subarr.get(sum));//i==subarr.get(sum)
            }else {
                subarr.put(sum,j);
            }
        }

        return length;
    }
    public static int SumK(int arr[],int k){
        int sum=0,ans=0;

        HashMap<Integer,Integer> sumcount=new HashMap<>();
        //starting ma put(0,1) for sum=-10 and k=-10 so -10-(-10)=0
        sumcount.put(0,1);

        for (int j = 0; j < arr.length ; j++) {
            sum+=arr[j];
            if(sumcount.containsKey(sum-k)){
                ans+=sumcount.get(sum-k);
            }
            sumcount.put(sum,sumcount.getOrDefault(sum,0)+1);
        }



        return ans;
    }
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10,23};
       // System.out.println("largest subarray with sum 0 is "+Sum0(arr));

        int arr1[]={10,2,-2,-20,10};
        int k=-10;
        System.out.println("largest subarray with k is: "+SumK(arr1,k));
    }
}



