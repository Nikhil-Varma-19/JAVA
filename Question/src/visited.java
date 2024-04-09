public class visited {
    private static void visitedMethod(int arr[]){
        int n= arr.length;
        for (int i = 0; i < n; i++) {
            int index=Math.abs(arr[i]);
            if(arr[index-1] > 0){
                arr[index - 1]*=-1;
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]+" ");
//        }
        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                System.out.println(i+1);
            }
        }
    }
    private static int fisrtMissingNo(int arr[]){
        // https://www.youtube.com/watch?v=aBhla9jSAeg
        int n= arr.length;
        //check which first no. is missing
        for (int i = 0; i < n; i++) {
            int element =arr[i];//if the number is 3
            if(element >=1 && element <= n){
                int chair=element-1;// 3 will sit on 2 // chair is like index
                if(arr[chair] != element){// arr[chair] mean chair pa konsa no. seat hai
                    //swap(arr[chair],arr[i]);
                    int temp=arr[chair];
                    arr[chair]=arr[i];
                    arr[i]=temp;
                    i--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(i+1 != arr[i]) return i+1;
        }
       return n+1;
    }
   /* static int newMethod(int arr[]){
        // https://www.youtube.com/watch?v=KfUszKAlaL0
        int n=arr.length;
        int contains=0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == 1){
                contains++;
                break;
            }
        }
        if(contains == 0){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] <= 0  || arr[i] > n){
                arr[i]=1;
            }
        }
        for (int i = 0; i < n; i++) {
            int a=Math.abs(arr[i]);
            if(a == n){
                arr[0]= - Math.abs(arr[0]);
            }else  arr[a]=- Math.abs(arr[a]);
        }
        for (int i = 1; i <n ; i++) {
                if(arr[i]>0) return i;
        }

        if(arr[0] > n) return n;

        return n;
    }*/
    public static void main(String[] args) {
        int arr[]={1,3,5,3,4};
        // for duplicate or missing number in array (only positive no.)
      //  visitedMethod(arr);
        // find first missing no.
        int arr1[]={3,4,-1,1}; // ans is 2
        int arr2[]={1,0,2}; //ans is 3
        System.out.println(fisrtMissingNo(arr1));
        System.out.println(fisrtMissingNo(arr2));
    }
}
