public class QuickSort {
    static  void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
    }
    static int partitions(int[] arr ,int s, int e){
        int pviot=arr[s]; // taking first element as pviot
        int count=0;

        for(int i=s+1;i<arr.length;i++){
            if(arr[i]<=pviot) count++;
        }

        int pviotindx= s+count;
     //swap
        int temp = arr[s];
        arr[s]=arr[pviotindx];
        arr[pviotindx]=temp;
      //

      int i=s,j=e;

      while (i<pviotindx && j>pviotindx){
          while (arr[i]<=pviot){
              i++;
          }
          while (arr[j]>pviot){
              j--;
          }
          if (i < pviotindx && j > pviotindx)
          {
             // swap(arr[i++], arr[j--]);
              int tempp =arr[i];
              arr[i]=arr[j];
              arr[j]=tempp;

              i++;j--;

          }
      }
      return pviotindx;

    }
    // apna college
    static  int  partitions1(int[] arr, int s, int e){
        int pviot=arr[e];
        int i=s-1;
        for(int j=s;j<e;j++){
            if(arr[j]<=pviot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp = pviot;
        arr[e]=arr[i];
        arr[i]=temp;

        return i;
    }
    static  void quickSort(int[] arr, int s ,int e){
        if(s >= e){
            return;
        }

        //int p = partitions(arr,s,e);
        int p= partitions1(arr,s,e);

        quickSort(arr,s,p-1);
        quickSort(arr,p+1,e);
    }
    public static void main(String[] args) {
        int[] arr={9,8,7,55,6,6,-2};
        quickSort(arr,0,arr.length-1);
        printarr(arr);
    }
}
