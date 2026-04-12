import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IndainCoin {

    public static void main(String[] args) {
        Integer[] coins = {1,2,5,10,20,50,100,500,1000,2000};
        int value = 121;
        ArrayList<Integer> list = new ArrayList<>();

        int minNo = 0;
        Arrays.sort(coins, Collections.reverseOrder());

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= value){
                while (value >= coins[i]){
                    value -= coins[i];
                    minNo++;
                    list.add(coins[i]);
                }
            }
        }

        System.out.println("Min no of coins: " + minNo);
        System.out.println("Coins: "+ list);

    }
}
