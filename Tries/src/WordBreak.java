public class WordBreak {

    public static boolean wordBreak(String key, TriesMain tries){
        if(key.isEmpty()) return true;

        for (int i = 1; i <= key.length(); i++) {
            if(tries.search(key.substring(0,i)) && wordBreak(key.substring(i),tries)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] words = {"i","like","san","samsung","mobile","ice"};

        String key = "ilikesamsung";

        TriesMain root = new TriesMain();

        for(String word : words){
            root.insert(word);
        }

        System.out.println(wordBreak(key,root));

    }
}
