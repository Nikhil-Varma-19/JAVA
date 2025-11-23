import java.util.*;


public class GroupAnagram {
  public static List<List<String>> grpAsnagram(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> lists = new ArrayList<>();

    for (String s : strs) {

      char[] chharArray = s.toCharArray();
      Arrays.sort(chharArray);
      String newStr = new String(chharArray);
      if (!map.containsKey(newStr)) {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(newStr, list);
      } else {
        map.get(newStr).add(s);
      }
    }

    for (String key : map.keySet()) {
      lists.add(map.get(key));
    }
    return lists;

  }

  public static void main(String[] args) {
    String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(grpAsnagram(strs));
  }
}
;