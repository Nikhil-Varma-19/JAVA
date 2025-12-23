import java.util.Arrays;

public class thirdlargest {
    public static int thirdlargeElm(int arr[]){

        int first=0,second=0,third=0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]>first){
                third=second;
                second=first;
                first=arr[i];
            } else if (arr[i]>second && arr[i] != first) {
                third=second;
                second=arr[i];
            } else if (arr[i]>third &&  arr[i] != first &&  arr[i] != second) {
                third=arr[i];
            }
        }
        return third;
    }

    public static int thirdLargest(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);

        // If there are less than 3 elements in the array, return the maximum element
        if (arr.length < 3) {
            return arr[arr.length - 1];
        }

        // Find the third largest element
        int count = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
            if (count == 3) {
                return arr[i];
            }
        }
        // If there are less than 3 unique elements in the array, return the maximum element
        return arr[arr.length - 1];
    }
    public static void main(String[] args) {
        int arr[]={1,5,9,44,55,33,7,100,100};
      System.out.println("my "+thirdlargeElm(arr));
        System.out.println("gpt "+thirdLargest(arr));
    }
}
