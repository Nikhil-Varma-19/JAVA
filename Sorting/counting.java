/*
 * count the frequency and print according to the frequency
 */

public class counting {
    static void CountingSort(int arr[], int n) {
        int largest = 0;
        for(int i=0;i<n;i++){
            largest=Math.max(largest,arr[i]);
        }
// freq is storing in count  array;

        int count[]=new int[largest+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++){
            while (count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }


    }

    static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 9,9,6,5,8,7,8,2,1,0,3,2,3};

        int n = arr.length;
        CountingSort(arr, n);
        // Arrays.sort(arr,0,3);
        printarr(arr);
    }
}
