//package JAVA.Sorting;

public class Bubble {
    static void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    static void bubbleSort(int arr[],int n){
        for(int i=0;i<=n;i++){
           // boolean swap = false;
            for(int j=0;j<=n-1;j++){
                if(arr[j]>arr[j+1]){
                  swap(arr,j,j+1);
                 /*   int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;*/
             //       swap = true;
                }

            }
            //if(swap == false) break;
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
        bubbleSort(arr, n);
        printarr(arr);
      
    }
}
