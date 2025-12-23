import java.util.Stack;

public class ReverseQ {

    static String reverseString(String s){
        Stack<Character> stChar=new Stack<Character>();
        for(char ch : s.toCharArray()){
            stChar.push(ch);
        }
        StringBuilder ans= new StringBuilder();
        while (!stChar.isEmpty()){
            ans.append(stChar.pop());
        }
       return ans.toString();
    }


    static Stack<Integer> reverseStack(Stack<Integer> s){
        Stack<Integer> ans=new Stack<>();
        while (!s.isEmpty()){
            ans.push(s.pop());
        }
        return ans;
    }

    static void reverseStackRes(Stack<Integer> s){
        if (s.isEmpty()) return;
        int top=s.pop();
        reverseStackRes(s);
        pushAtBottom(s,top);

    }

    static <T> void pushAtBottom(Stack<T> s,T data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        T top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }


    static void printStack(Stack<?> s){
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        String st="Nikhil";
//        System.out.println(reverseString(st));


        Stack<Integer> s1=new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        reverseStackRes(s1);
        printStack(s1);









    }
}
