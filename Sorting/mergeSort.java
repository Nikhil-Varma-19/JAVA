public class mergeSort {

    static  void  merge(int[] arr,int s, int e ,int mid){
        int newarr[]= new int[e+1]; // or [e-s+1]
        int left =s,right =mid+1;
        int i = s; // i=0
        while(left <= mid && right <= e){
            if(arr[left]<=arr[right]){
                newarr[i]=arr[left];
              left++;
            }else {
                newarr[i]=arr[right];
                right++;
            }
            i++;
        }

        while (left<=mid){
            newarr[i]=arr[left];
            left++;i++;
        }
        while(right<=e){
            newarr[i]=arr[right];
            right++;i++;
        }

        for(int k=s;k<=e;k++){ // or k=0 k< newarr.length
            arr[k]=newarr[k]; // arr[s+k]
        }
    }
    static void partmergeSort(int[] arr,int s,int e){
        if(s == e){
            return ;
        }
        int mid = s+(e-s)/2;


        partmergeSort(arr,s,mid);
        partmergeSort(arr,mid+1,e);

        merge(arr,s,e,mid);
    }

    static  void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr={9,8,7,55,6,6,0};

        partmergeSort(arr,0,arr.length-1);
        printarr(arr);

    }
}
