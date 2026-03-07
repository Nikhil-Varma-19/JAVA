import java.util.ArrayList;

public class HP {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data){
            list.add(data);

            int childNumberIdx = list.size() - 1;
            int parentNumberIdx = (childNumberIdx - 1) / 2 ;

            while (list.get(childNumberIdx) < list.get(parentNumberIdx)){
                int temp = list.get(childNumberIdx);
                list.set(childNumberIdx,list.get(parentNumberIdx));
                list.set(parentNumberIdx,temp);
            }
        }

        public int peek(){
            return list.getFirst();
        }

        private void heapify(int idx){
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int min = idx;

            if(left < list.size() && list.get(min) > list.get(left)) min = left;

            if(right < list.size() && list.get(min) > list.get(right)) min = right;

            if(min != idx){
                // swap
                int temp = list.get(idx);
                list.set(idx,list.get(min));
                list.set(min, temp);
                heapify(min);
            }

        }

        public int remove(){
            int data = list.getFirst();
            int first = 0;
            int last = list.size() - 1;

            // step 1 -> swap first and last number
            int temp = list.get(0);
            list.set(first,list.get(last));
            list.set(last,temp);

            // step 2 -> remove last number
             list.removeLast();

             // step 3 ->
            heapify(0);

            return data;
        }

        public  boolean isEmpty(){
            return list.isEmpty();
        }
    }
    public static void main(String[] args) {
            Heap heap = new Heap();
            heap.add(4);
            heap.add(2);
            heap.add(1);
            heap.add(3);

            while (!heap.isEmpty()){
                System.out.println(heap.peek());
                heap.remove();
            }
    }
}
