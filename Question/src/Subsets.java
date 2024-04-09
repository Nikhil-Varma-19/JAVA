import java.util.Scanner;

/*
 *  Find and print all the subsets of a given String
 *   Eg: "abc"
 *
 * Ans:  a,b,c,ab,bc,ac,abc," "
 *
 *                                               "abc" i=0
 *                                                yes     No
 *                                    i=1      "a" bc     "" bc
 *                                          yes   no        yes     no
 *                           i=2         "ab" c  "a" c
 *                                    yes   no        yes     no
 *                     i=3         "abc"  "ab"       "ac"   "a"
 *                          like  this.......
 *
 * */
public class Subsets {
    static void printsubset(String str, StringBuilder ans, int i) {
        //base case
      /*  if(i == str.length()){
            System.out.printf(ans+" ");
            return;
        }*/
        // printing the null value
        if (i == str.length()) {
            if (ans.length() == 0) System.out.print("null");
            else System.out.printf(ans + " ");
            return;
        }
        //recursion
        //yes

        printsubset(str, ans.append(str.charAt(i)), i + 1);
        ans.deleteCharAt(ans.length() - 1);// the delete will goes where the append is there

        //no
        printsubset(str, ans, i + 1);

    }

    public static void main(String[] args) {
        String s = "abc";
        printsubset(s, new StringBuilder(), 0);

    }
}
