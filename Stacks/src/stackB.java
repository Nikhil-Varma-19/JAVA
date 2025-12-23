import java.util.*;

public class stackB {

    // Stack by ArrayList
    static class StackArrayList {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // add the data to the top of the stack
        public static void push(int x) {
            list.add(x);
        }

        // remove the data from the top of the array list and return the removed data
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // print the top data from the ArrayList Stack
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    // Stack using LinkedList
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackLL {
        static Node head = null;

        static boolean isEmpty() {
            return head == null;
        }

        static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        // first we are removing the data from the  stack and after that we are adding the data the data
        if (s.isEmpty()) {
            // thids is  bezu after the  removing the data stack will be  empty then the  data will be  add at the bootom and  then the remainig data will be add
            s.push(data);
            return;
        }
        int top = s.pop();// removing
        pushAtBottom(s, data);
        s.push(top);//adding
    }

    static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");

        }
    }

    static void StockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stock.length; i++) {
            int curr = stock[i];
            while (!s.isEmpty() && curr > stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);

        }
    }

    static void nextGreater(int arr[], int nextGreatArr[]) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreatArr[i] = -1;
            } else {
                nextGreatArr[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }

    static boolean duplicateParethesse(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
           char ch=str.charAt(i);
           if(ch == ')'){
               int count=0;
               while (stack.peek() != '('){
                   stack.pop();
                   count++;
               }
               if(count<1){
                    return true;
               }else{
                   stack.pop();
               }
           }else{
               stack.push(ch);
           }
        }

        return false;
    }

    static int maxRectangleA(int arr[]){
        int maxArea=0;
        int n=arr.length;
        int nsl[]=new int[arr.length];
        int nsr[]=new int[arr.length];

        //Next small left
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<n;i++){
            while (!s1.isEmpty() && arr[s1.peek()]>=arr[i] ){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s1.peek();
            }
            s1.push(i);
        }

        //Next Small right
        Stack<Integer> s2=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while (!s2.isEmpty() && arr[s2.peek()]>=arr[i] ){
                s2.pop();
            }
            if(s2.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=s2.peek();
            }
            s2.push(i);
        }
        //finding the area of each indexies
        //width = j-i-1 so : nsr[i]-nsl[i]-1
        for(int i=0;i<n;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArr=height*width;
            maxArea=Math.max(maxArea,currArr);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        /*
        StackArrayList s1 = new StackArrayList();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
        */
/*
        StackLL s2 = new StackLL();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);

        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
        */
/*
        Stack<Integer> s3=new Stack<>();
        s3.push(1);
        s3.push(2);
        s3.push(3);
        s3.push(4);

        while (!s3.isEmpty()){
            System.out.println(s3.peek());
            s3.pop();
        }

 */
/*
        //push at the bottom of the stack  O(n)

        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

       // pushAtBottom(s,0);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
 */
  /*
        // reverse a string using stack
        String str="Nikhil";
        String revStr="";
        Stack<Character> sstr=new Stack<>();
        for(int i=0;i<str.length();i++){
            sstr.push(str.charAt(i));
        }

        while (!sstr.isEmpty()){
           char ch  = sstr.pop();
           revStr+=ch;
        }
        System.out.println(revStr);
*/
/*
        //revers a stack
        Stack<Integer> stacks=new Stack<>();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);

        //printStack(stacks);// 54321
       // reverseStack(stacks);
     //   printStack(stacks);// 12345
*/
/*
        // Stock Span Problem
        int stocks[]={100,80,60,70,60,85,100};
        int span[] =new int[stocks.length];
      StockSpan(stocks,span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i]+" ");

            }

    */
    /*
        //Next Greater Element
        int arr[]={6,8,0,1,3};
        int nextGreatArr[]=new int[arr.length];
        nextGreater(arr,nextGreatArr);
        for(int i=0;i<nextGreatArr.length;i++){
            System.out.print(nextGreatArr[i]+" ");
        }

     */
/*
        //Duplicate Parenthesse
        String str="(((a+b))+(c+d))";//true  :contain duplicate
        String str1="((a+b)+(c+d))";//false  :not contain duplicate
        System.out.println( duplicateParethesse(str1));
 */
        //Max area of rectangle
//        int height[]={2,1,5,6,2,3};
//        System.out.println( maxRectangleA(height));

    }


}

