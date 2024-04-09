import java.util.Stack;

public class bracket {
    private static String bracketcorr(String s) {
        Stack<Character> st = new Stack<Character>();
        String ans = "1";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (!st.empty() && s.charAt(i) == ')') {
                if (st.peek() == '(') {
                    st.pop();
                } else {

                    return ans;
                }
            }
        }

        if (st.empty()) {
            ans = "0";
            return ans;
        }

        return ans;

    }

    private static String ans(String s){
        int c1=0,c2=0;
            s=s.replaceAll("[^()]","");
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') c1++;
            if(s.charAt(i)== ')') c2++;
        }

        int ans1=c1-c2;
        if(ans1 != 0) {
           return "0";
        }
        return "1";
    }
    public static void main(String[] args) {
        String s = "(coder)(byte))";//1

        System.out.println(ans(s));
    }
}
