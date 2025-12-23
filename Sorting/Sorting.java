import java.util.Arrays;

public class Sorting {
    static  void bubbleSorting1(int[] arr){
        boolean hasSwapped = true;
        int j = 0;
        while (hasSwapped){
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1 -j; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    hasSwapped = true;
                }
            }
            j++;
        }

    }
    
    static void bubbleSorting2(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swaphappened = false;
            for (int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaphappened = true;
                }
            }
            if(!swaphappened) break;
        }
    }

    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minEle = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minEle] > arr[j]){
                    minEle = j;
                }
            }
            swap(i,minEle,arr);
        }
    }

    static void insertingSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i]; // store in temp memory
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr ){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    static void  countingSortP(int[] arr){
        // Positive  number only
        int maxEle = arr[0];
        for(int num : arr){
            maxEle = Math.max(maxEle,num);
        }

        int[] counts = new int[maxEle+1];

        for (int num : arr){
            counts[num]++;
        }

        int startIndx = 0;
        for (int i = 0; i < counts.length ; i++){
            int count = counts[i];
            counts[i] = startIndx;
            startIndx+=count;
        }

        int[] sortedArray = new int[arr.length];

        for (int ele : arr){
           sortedArray[counts[ele]] = ele;
           counts[ele]++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    static void  countingSortN(int[] arr){
        // Positive  number only
        int maxEle = arr[0];
        int shift = Integer.MAX_VALUE;
        for(int num : arr){
            maxEle = Math.max(maxEle,num);
            shift = Math.min(shift,num);
        }

        maxEle = maxEle - shift;

        int[] counts = new int[maxEle+1];

        for (int num : arr){
            counts[num - shift]++;
        }

        int startIndx = 0;
        for (int i = 0; i < counts.length ; i++){
            int count = counts[i];
            counts[i] = startIndx;
            startIndx+=count;
        }

        int[] sortedArray = new int[arr.length];

        for (int ele : arr){
            sortedArray[counts[ele - shift]] = ele;
            counts[ele - shift]++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    static  void  swap (int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8,1,5,1,4,1,2,4,2,6,2,8,3,9,7,5,1,4,5,2,-100,100};
//        bubbleSorting2(arr);
//        selectionSort(arr);
//        insertingSort(arr);
        countingSortN(arr);
        System.out.println(Arrays.toString(arr));
    }
}
