public class Backtracking {
    static void backtarcking(int[] arr,int idx,int val){

        if(idx == arr.length){
            printArr(arr);
            return;
        }

        arr[idx]=val;
        backtarcking(arr,idx+1, val+1);
        arr[idx]=arr[idx]*arr[idx];
    }
    static void Square(int[] arr,int idx,int val){
        if(idx == arr.length){
            printArr(arr);
            return;
        }

        arr[idx]=val*val;
        Square(arr,idx+1,val+1);
    }
    static void printArr(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr=new int[5];
        System.out.println("backtracking");
       backtarcking(arr,0,1);

        printArr(arr);
        System.out.println("Regular");
        Square(arr,0,1);
    }
}
