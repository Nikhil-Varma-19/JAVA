import java.util.Arrays;

public class FractionalKnapsack {

    static int fractionalK(int[] values,int[] weights,int W){
        int ans = 0;

        double[][] ratioSortIndex = new double[weights.length][2];

        for (int i = 0; i < ratioSortIndex.length; i++) {
            ratioSortIndex[i][0] = i;
            ratioSortIndex[i][1] = (double) values[i]/weights[i];
        }

        Arrays.sort(ratioSortIndex, (a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < ratioSortIndex.length && W != 0; i++) {
            int index = (int) ratioSortIndex[i][0];
            if(weights[index] <= W){
                W -= weights[index];
                ans += values[index];
            }else {
                ans += (int) (ratioSortIndex[i][1] * W);
                W = 0;

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] values = {60,100,120};
        int[] weights = {10,20,30};
        int W = 50;

        System.out.println(fractionalK(values,weights,W));
    }
}
