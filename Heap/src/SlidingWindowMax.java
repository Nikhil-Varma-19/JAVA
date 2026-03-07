import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMax {

    private static class Pair implements  Comparable<Pair> {
        int val;
        int index;

        Pair(int index, int val){
            this.val = val;
            this.index = index;
        }


        @Override
        public int compareTo(Pair p) {
            return p.val - this.val;
        }
    }

    public static int[] pqSliding(int k, int[] nums){
        //        T.C : O(n log k) and S.C : O(k)(deque)
        int n = nums.length;
        int[] res = new int[n-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i,nums[i]));
        }

        res[0] = pq.peek().val;
        int indx = 0;

        for (int i = k; i < n; i++) {

            while (pq.size() > 0 && pq.peek().index <= (i - k) ){
                pq.remove();
            }
            pq.add(new Pair(i,nums[i]));
            res[i-k+1] = pq.peek().val;

        }

        return res;
    }

    public static int[] DQSliding(int[] nums, int k){
//        T.C : O(n) and S.C : O(k)(deque)
        int n = nums.length;
        int res[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // remove element outside window
            while (!dq.isEmpty() && dq.peekFirst() == i -k){
                dq.pollFirst();
            }

            // remove the smaller element from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if( i >= k - 1) res[i-k+1] = nums[dq.peekFirst()];

        }

        return res;
    }

    public static void main(String[] args) {
        // Siding Window max or max of all subarray of size k
        int[] arr = {8,4,1,4,5,7};
        int k = 3;

        System.out.println(Arrays.toString(pqSliding(k, arr)));

        System.out.println(Arrays.toString(DQSliding(arr,k)));
    }
}
