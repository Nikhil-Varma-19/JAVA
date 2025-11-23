import java.util.*;
public class QueueQuestions {

    public static class twoStackQueue{

        static  Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean  isEmpty(){
            return  s1.isEmpty();
        }

    public  static void  add(int n){
           while (!s1.isEmpty()){
               s2.push(s1.pop());
           }
           s1.push(n);
           while (!s2.isEmpty()){
               s1.push(s2.pop());
           }
    }
    public static int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
            }
            return s1.pop();
    }
    public static int peek(){
        if(isEmpty()){
            System.out.println("empty queue");
        }
        return  s1.peek();
    }

    }


    public static void main(String[] args) {

//        Queue<Integer> q1=new LinkedList<>();
//        q1.add(1);
//        q1.add(2);
//        q1.add(3);
//        q1.add(4);
//
//        while (!q1.isEmpty()){
//            System.out.println(q1.peek());
//            q1.remove();
//        }

        // implement queue using two stack
        twoStackQueue a=new twoStackQueue();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);


        while(!a.isEmpty()){
            System.out.println(a.peek());
            a.remove();
        }

    }
}
