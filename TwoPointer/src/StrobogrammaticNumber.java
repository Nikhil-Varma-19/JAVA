import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    private static boolean strobogrammaticNo(String s,Map<Character,Character> map ){
        int i = 0,j = s.length() - 1;
        while (i<=j){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) == s.charAt(j)){
                    i++;
                    j--;
                }else  return false;
            }else return  false;
        }
       return true;
    }
    public static void main(String[] args) {
        String s = "198861";
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        System.out.println(strobogrammaticNo(s,map));
    }
}
