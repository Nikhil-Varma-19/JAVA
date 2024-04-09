import java.util.HashSet;

/*
    Give the output no of duplicate in the arr
    eg {1,2,2,2,3} ans= 2 the "2"no. is repleted 2 times
 */
public class DistinctList {
    private static int dulpicteCnt(int arr[]){
        HashSet<Integer> uniq=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            uniq.add(arr[i]);
        }

        int ans= arr.length - uniq.size();
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,-2,-2,5,5,5};
        System.out.println(dulpicteCnt(arr));
    }
}
