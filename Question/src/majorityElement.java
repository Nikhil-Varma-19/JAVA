import java.util.HashMap;

// Majority element I and II 2 for leetcode
public class majorityElement {
    public static void main(String[] args) {
        // the nums will act as key and the count/freq of that num. will act a value
        int[] arr={2,2,1,1,1,2,2};
// using hashmap O(n)
        HashMap<Integer,Integer> maps=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(maps.containsKey(arr[i])){
                maps.put(arr[i], maps.get(arr[i])+1 );
            }else {
                maps.put(arr[i],1 );
            }
        }

         ////Set<Integer> keyset =maps.keySet();
        for(Integer key : maps.keySet()){
            if(maps.get(key)> arr.length/2){
                System.out.println(key);
            }
        }

        // using Moores voting algo
        int el=0,cnt=0;
        for(int i=0;i< arr.length;i++){
            if(cnt == 0){
                el=arr[i];
                cnt=1;
            }else if(arr[i] == el){
                cnt++;
            }else{
                cnt--;
            }
        }

        int cntrecheck=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == el) cntrecheck++;
        }

        if(cntrecheck > arr.length/2) System.out.println(el);
        else System.out.println("Not There");



    }


}
