import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    private static  class Student implements  Comparable<Student>{
        int rank;
        String name;

        Student(int rank,String name){
            this.name = name;
            this.rank = rank;
        }


        @Override
        public int compareTo(Student o) {
            return this.rank - o.rank;
        }
    }
    public static void main(String[] args) {
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] nums = {2,4,1,5,6,3,5,2};

        for (int num : nums){
            pq.add(num);
        }

        System.out.println(pq);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq);
        System.out.println(pq.remove());
        System.out.println(pq);
        System.out.println(pq.remove());
        System.out.println(pq);

        */

        PriorityQueue<Student> pqS = new PriorityQueue<>(Comparator.reverseOrder());
        pqS.add(new Student(1,"A"));
        pqS.add(new Student(7,"R"));
        pqS.add(new Student(6,"W"));
        pqS.add(new Student(5,"Y"));
        pqS.add(new Student(4,"D"));
        pqS.add(new Student(2,"H"));


        while (!pqS.isEmpty()){
            System.out.println(pqS.peek().name + " -> " + pqS.peek().rank);
            pqS.remove();

        }
    }
}
