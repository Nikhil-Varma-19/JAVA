
    import java.util.*;

    public class moster {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int initPower = sc.nextInt();

            ArrayList<Integer> power = new ArrayList<>();
            ArrayList<Integer> bonus = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                power.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                bonus.add(sc.nextInt());
            }

            ArrayList<int[]> vp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vp.add(new int[]{power.get(i), bonus.get(i)});
            }

            vp.sort(Comparator.comparingInt(a -> a[0]));

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int currPower = vp.get(i)[0];

                if (initPower >= currPower) {
                    initPower += vp.get(i)[1];
                    ans++;
                }
            }

            System.out.println("Ans of the Monster " + ans);
        }
    }


