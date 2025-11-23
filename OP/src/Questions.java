import java.util.HashMap;
import java.util.Map;

public class Questions {

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 4, 5, 3, 3, 3,3};
        System.out.println(maxFreqMin(arr));
    }

    private static int maxFreqMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int maxNum = 0;
        HashMap<Integer, Integer> m1 = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (m1.containsKey(arr[i])) {
                m1.put(arr[i], m1.get(arr[i]) + 1);
                maxNum = Math.max(maxNum, m1.get(arr[i]));
            } else {
                m1.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> m1C:m1.entrySet()){

            int temp=m1C.getValue();
            if(temp==maxNum){
                ans=Math.min(ans,m1C.getKey());
            }

        }
    return ans;
    }
}
