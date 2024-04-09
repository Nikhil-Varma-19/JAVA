
public class reverse {
    public static void reversearray(int array[]){
        int i=0, j=array.length - 1;
        while(i<=j){
            //swap
            int temp = array[j];
            array[j]=array[i];
            array[i]=temp;
            
            i++;j--;

        }
    }

    public static void printarr(int arr[]){
           for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        int[] arr= {1,2,3,4,5,6};

        reversearray(arr);
      printarr(arr);
      

    }
}
