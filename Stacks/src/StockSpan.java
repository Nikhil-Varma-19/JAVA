import java.util.Stack;

public class StockSpan {
    static  int[] stockSpan(int[] stocks){
        int[] span=new int[stocks.length];
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);// current index number  for comparing the stock price
        for (int i = 1; i < stocks.length; i++) {
            int currentStockPrice=stocks[i];
            while (!s.isEmpty() && currentStockPrice  >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
        return span;
    }

   private static int[] stockSpanRev(int[] nums){
        int[] spans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        spans[0] = 1;
        stack.push(0);

       for (int i = 1; i < nums.length; i++) {
        int currentEle = nums[i];
        if(!stack.isEmpty() && nums[stack.peek()] > currentEle){
            spans[i] = i - stack.peek();
            stack.push(i);
        } else if (!stack.isEmpty() && nums[stack.peek()] < currentEle) {
                while (!stack.isEmpty() && currentEle > nums[stack.peek()]){
                    stack.pop();
                }
                spans[i] = i - stack.peek();
                stack.push(i);
        }else{
            spans[i] = i + 1;
           }
       }
        return spans;
   }

    public static void main(String[] args) {
        //Stock span 1]
        int[] stocks ={100,80,60,70,60,75,85};

        // max consecutive days from which the stock price was less then an equal to current day
        // https://youtu.be/eay-zoSRkVc?si=XYPLcTHyT-CW_c9r
        int[] stockPrice={7,2,1,3,3,1,8};
        int[] ans=stockSpanRev(stocks);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("index: "+i+" "+ans[i]);
        }



    }


}
