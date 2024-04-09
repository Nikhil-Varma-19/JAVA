//package JAVA.Sorting;

public class Selection {

    static void selectionSort(int arr[],int n){

        for(int i=0;i<=n-1;i++){
            int minIdx=i;
            for(int j=i+1;j<=n;j++){
                if(arr[j]<arr[minIdx]) minIdx=j;
            }
            int temp=arr[minIdx];
            arr[minIdx]=arr[i];
            arr[i]=temp;
        }
    }
    static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
     }
    
    public static void main(String[] args) {
        int arr[]={5,4,3,2,1};

        int n =arr.length-1;
        selectionSort(arr, n);
        printarr(arr);
      
    }
}
