import java.util.PriorityQueue;

public class RopesN {
    public static void main(String[] args) {
        int[] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : ropes){
            pq.add(num);
        }

        int cost = 0;

        while (pq.size() > 1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            System.out.println(min1 + " "+ min2);
            cost += min2 + min1;
            pq.add(min1+min2);

        }

        System.out.println("Min Cost: "+cost);
    }
}
