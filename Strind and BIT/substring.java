import java.util.ArrayList;
import java.util.List;

public class substring {
//    private  static boolean checksubstring(String s1,String s2){
    // wrong when aabbaa while appreas
//        int cur=0;
//        for (int i = 0; i < s1.length(); i++) {
//            if(s1.charAt(i) == s2.charAt(cur)) {
//                cur++;
//
//            }else{
//                cur=0;
//            }
//        }
//        if (cur == s2.length()){
//            return true;
//        }
//
//        return  false;
//    }
    private static boolean checksubstring1(String s1, String s2) {
        int cur = 0;
        int matchStart = -1; // To keep track of where the current match started
        int start=-1;
        int end=-1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(cur)) {
                if (matchStart == -1) {
                    matchStart = i; // Update the matchStart only if it's not already set
                  //  start=i;
                }
                cur++;
              // end=i;
                if (cur == s2.length()) {
                    return true;
                    // if indx is requried
                  //  System.out.println(start);
                    //System.out.println(end);
                }
            } else {
                if (matchStart != -1) {
                    i = matchStart; // Reset i to the position where the match started
                }
                matchStart = -1; // Reset matchStart
                cur = 0; // Reset cur
              //  start=-1;
               // end=-1;
            }
        }
        return false;
    }

    // --------------------------------------------
    private static void subsequense(String s, String output, int idx, List<String> ans){
        if(idx >= s.length()){
            if(!output.isEmpty()){
                ans.add(output);
            }
            return;
        }
        subsequense(s,output,idx+1,ans);

        char element =s.charAt(idx);
        output+=element;
        subsequense(s,output,idx+1,ans);
    }
    public static List<String> subsequenceshelp(String s){
        List<String > ans=new ArrayList<>();
        String output ="";
        int idx=0;
        subsequense(s,output,idx,ans);
        return ans;
    }
    public static void main(String[] args) {
        String s1="ABABDABACDABABCABAB";
        String s2="ABABCABAB";
     // checksubstring1(s1,s2);
      //  System.out.println(checksubstring1(s1,s2));

//        for (int i = 0; i < s2.length(); i++) {
//            for (int j = i+1; j <=s2.length() ; j++) {
//                System.out.printf(s2.substring(i,j)+" ");
//            }
//        }
        String s="abc";
        List<String> result = subsequenceshelp(s);
        System.out.println(result);
    }

}
