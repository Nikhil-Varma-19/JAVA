//import java.util.*;

public class Insert {
    static void insertionSort(int arr[], int n){
        for(int i=1;i<arr.length;i++){
            int pre=i-1;
            int curr=arr[i];
            while( pre>=0 && arr[pre] > curr ){
                arr[pre+1]=arr[pre];
                pre--;
    
            }
            arr[pre+1]=curr;
            
    
        }
    }

    static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
     }
    
    public static void main(String[] args) {
        int arr[]={3, 1 ,2 ,4,6,9,8};

        int n =arr.length;
        insertionSort(arr, n);
        //Arrays.sort(arr,0,3);
        printarr(arr);
        
    }
}
