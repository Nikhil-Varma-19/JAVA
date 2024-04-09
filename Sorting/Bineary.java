

public class Bineary {

    static int binarySearch(int a[],int key){
        int start=0;
        int end =a.length-1;
        int mid=start+(end-start)/2;

        while (start<=end) {

            if(a[mid]==key) return mid;

            else if(a[mid]<key) start = mid +1;

            else end = mid-1;
            
            mid=start+(end-start)/2;
        }
        return mid;
    }

   public static void main(String[] args) {
    int arr[]={2,4,6,8,12,18};
    int key=12;

    int indx =binarySearch(arr,key);

    System.out.println("key is present in index :"+(indx+1));
   }
    

}