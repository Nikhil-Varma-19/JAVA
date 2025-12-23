import java.util.Arrays;
import java.util.Stack;

public class NextGreaterEle {

    static int[] nextGreaterElementRight(int[] ele){
        int[] ans=new int[ele.length];
        Stack<Integer> s=new Stack<>();
        for (int i = ele.length -1; i >=0; i--) { // for next greater left 0 to ele.length
            int currentEle=ele[i];
            while (!s.isEmpty() && currentEle > ele[s.peek()] ){ // for next smallest ele in right change ">" to "<"
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }else{//(currentEle < ele[s.peek()])
                   ans[i]=ele[s.peek()];
            }
            s.push(i);
        }

        // for next smallest left then change the loop 0 to ele.length and change ">" to "<"

        return ans;
    }


    public static void main(String[] args) {
        int[] ele={6,8,0,1,3};
        System.out.println(Arrays.toString(nextGreaterElementRight(ele)));

    }
}
