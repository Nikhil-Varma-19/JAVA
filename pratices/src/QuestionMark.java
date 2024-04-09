import java.util.SortedMap;

public class QuestionMark {
    private static String questionMark(String s) {
        //   s=s.replaceAll("[^?0-9]","");
        int currNo = 0;
        int nextNo = 0;
        int Qcnt = 0;
        boolean ten = false;
        String ans = "true";
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {

                currNo = Character.getNumericValue(s.charAt(i));

                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == '?') Qcnt++;
                    else if (Character.isDigit(s.charAt(j))) {
                        nextNo = Character.getNumericValue(s.charAt(j));
                        if (currNo + nextNo == 10) {
                            ten = true;
                            if (Qcnt != 3) {
                                ans = "false";
                            }
                            i = j + 1;
                            Qcnt = 0;
                        }
                    }
                }

            }
        }
        if (ten == false) ans = "false";

        return ans;
    }


    public static void main(String[] args) {
        String s = "acc?7??sss??3rr1????5";
        System.out.println(questionMark(s));


    }
}
