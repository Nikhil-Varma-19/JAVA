import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    static ArrayList<Integer> activitySelection(int[] start, int[] end){
        ArrayList<Integer> res = new ArrayList<>();

        int[][] activities = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));



        int  lastAct = activities[0][2];
        res.add(0);


        for (int i = 1; i < activities.length; i++) {
            if(activities[i][1] >= lastAct){
                lastAct = activities[i][2];
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,5,8};
        int[] end = {2,4,6,7,9,9}; // sorted on end time;

        System.out.println(activitySelection(start,end));
    }
}
