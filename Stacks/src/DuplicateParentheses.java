import java.util.Stack;

public class DuplicateParentheses {

    static  boolean duplicatePren(String s){
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                int count=0;
                while (st.peek() != '('){
                    st.pop();
                    count++;
                }
                if(count < 1) return  true;
                else st.pop();

            }else {
                st.push(s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="((a+b))";// true
        String s2="(a+b)";// false
        System.out.println(duplicatePren("((a+b)+ (c+d))"));

    }
}
