import java.util.Arrays;

public class TriesMain {


    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord;

        Node(){
            Arrays.fill(children, null);
        }
    }

    private  Node root;

    public TriesMain(){
        root = new Node();
    }

    public  void insert(String word){
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) curr.children[index] = new Node();
            curr = curr.children[index];
        }
        curr.endOfWord = true;

    }

    public  boolean search(String word){
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) return  false;
            curr = curr.children[index];
        }

        return  curr.endOfWord ;
    }

    public static void main(String[] args) {
        String words[] = {"the","there","a","their","any","thee"};

        TriesMain root = new TriesMain();
        for (String word : words){
            root.insert(word);
        }

        System.out.println(root.search("the"));
    }
}
