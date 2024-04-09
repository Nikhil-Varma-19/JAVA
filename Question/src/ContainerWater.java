//leetcode 11

import java.util.ArrayList;

public class ContainerWater {
    //Bueteforce  O(n^2)
/*    private static int Contain_water(ArrayList<Integer> list) {

        int ans=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int width=Math.min(list.get(i), list.get(j) );
                int  heigth = j-i;
                ans=Math.max(ans,(width*heigth));
            }
        }
        return ans;
    }*/

    //optimize O(n)
    private static int Contain_water(ArrayList<Integer> list){
        int ans=0;
        int lp=0,rp= list.size()-1;

        while (lp<rp) {
            int height = Math.min(list.get(lp), list.get(rp));
            int width = rp - lp;
            int currvolume = width * height;
            ans = Math.max(ans, currvolume);
            if (list.get(lp) < list.get(rp)) lp++;
            else rp--;
        }
        return ans;
    }
    public static void main(String[] args) {
      // int[] height = {1,8,6,2,5,4,8,3,7};
        ArrayList<Integer> height = new ArrayList<>(); // new arraylist<>() is initialized

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(height);
        int ans=Contain_water(height);
        System.out.println(ans);
    }


}
