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

    private static int[] stockSpan2(int[] stockPrice) {
        int[] arr=new int[stockPrice.length];
        Stack<Integer> s=new Stack<>();
        arr[0]=1;
        s.push(1);

        for (int i  = 1; i < stockPrice.length; i++) {
            int currentStockPrice=stockPrice[i];
            while (!s.isEmpty() && currentStockPrice > stockPrice[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                  arr[i]=i+1;
            }else {
                int stackPeek=s.peek();

            }

        }
        return arr;

    }

    public static void main(String[] args) {
        //Stock span 1]
        int[] stocks ={100,80,60,70,60,85,100};

        // max consecutive days from which the stock price was less then an equal to current day
        // https://youtu.be/eay-zoSRkVc?si=XYPLcTHyT-CW_c9r
        int[] stockPrice={7,2,1,3,3,1,8};
        int[] ans=stockSpan(stocks);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("index: "+i+" "+ans[i]);
        }



    }


}
