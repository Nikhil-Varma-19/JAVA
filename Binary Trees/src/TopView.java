import java.util.*;

public class TopView {

    static class Info{
        int hd;
        Main.TreeNode node;

        Info(int hd, Main.TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }

    private static List<Integer> topView(Main.TreeNode root){
        Queue<Info> qu = new LinkedList<>();
        Map<Integer,Main.TreeNode> map = new HashMap<>();

        qu.add(new Info(0,root));
        qu.add(null);

        int min = 0, max = 0;

        while (!qu.isEmpty()){
           Info curr = qu.remove();

           if(curr == null){
               if(qu.isEmpty()) break;
               else qu.add(null);
           }else {
               if(!map.containsKey(curr.hd)){
                   map.put(curr.hd, curr.node);
               }

               if(curr.node.left != null){
                   qu.add(new Info(curr.hd - 1, curr.node.left ));
                   min = Math.min(min, curr.hd - 1);
               }

               if(curr.node.right != null){
                   qu.add(new Info(curr.hd + 1, curr.node.right));
                   max = Math.max(max, curr.hd + 1);
               }
           }

        }

        List<Integer> res = new ArrayList<>();

        for ( int i = min ; i <= max; i++){
            res.add(map.get(i).data);
        }


      return res;
    }

    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.left.left = new Main.TreeNode(4);
        root.left.right = new Main.TreeNode(5);
        root.right.left = new Main.TreeNode(6);
        root.right.right = new Main.TreeNode(7);

        System.out.println(topView(root));
    }
}
