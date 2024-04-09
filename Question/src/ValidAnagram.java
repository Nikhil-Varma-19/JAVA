import java.util.HashMap;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> valid = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (valid.containsKey(ch)) {
                valid.put(ch, valid.get(ch) + 1);
            } else {
                valid.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (valid.get(ch) != null) {
                if (valid.get(ch) == 1) {
                    valid.remove(ch);
                } else {
                    valid.put(ch, valid.get(ch) - 1);
                }
            } else {
                return false;
            }
        }

        return valid.isEmpty();
    }

    public static void main(String[] args) {
       String  s = "anagram";
       String t = "nagaram";
//        boolean ans =isAnagram(s,t);
//        System.out.println(ans);
        if(isAnagram(s,t)){
            System.out.println("Anagram");
        }else System.out.println("Not Anagram");
    }
}
