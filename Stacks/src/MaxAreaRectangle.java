import java.util.Arrays;
import java.util.Stack;

public class MaxAreaRectangle {

    static int maxAreaOfHistogram(int[] height){
        int ans=0;
        Stack<Integer> s=new Stack<>();
        // should know the next greater ele
       int[] nextSmallerLeft=new int[height.length];
       int[] nextSmallerRight=new int[height.length];

       // for next smaller left
        for (int i = 0; i < height.length; i++) {
            int curr=height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) nextSmallerLeft[i]=-1;
            else nextSmallerLeft[i]=s.peek();
            s.push(i);
        }

        System.out.println(Arrays.toString(nextSmallerLeft));


        s=new Stack<>();

        // for next small right
        for (int i = height.length-1 ;i >=0 ; i--) {
            int curr=height[i];
            while (!s.isEmpty() && curr <= height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) nextSmallerRight[i]= height.length;
            else nextSmallerRight[i]=s.peek();
            s.push(i);
        }

        System.out.println(Arrays.toString(nextSmallerRight));

        for (int i = 0; i < height.length; i++) {
            int length=height[i];
            int width=nextSmallerRight[i] - nextSmallerLeft[i] -1 ; // j-i-1 where j and i is next right and next left smaller resp.
            int area=length*width;
            System.out.println(area);
            if(area >= ans) ans=area;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height={2,1,5,6,2,3};
        System.out.println(maxAreaOfHistogram(height));
    }
}
