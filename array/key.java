public class key {

    static boolean findkey(int arr[],int k){

       // Time and Space is O(n) bcz arr and int i
       /* int i=0;

        if(i==arr.length) return false;
        
        if(arr[i]==k){
            return true;
        }

        return findkey(arr,i+1);*/

        // Time and Space is O(n) and O(1)
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k) return true;
        }
        return false;
    }
    public static void main(String argu[]){
        int arr[]={1,2,3,4,5,6,7};
        int key=5;
       boolean ans= findkey(arr,key);
        if(ans){
            System.out.println("Find the key "+key);
        }
        else{
            System.out.println("Not find");
        }
      //  System.out.println(ans);
    }
}
