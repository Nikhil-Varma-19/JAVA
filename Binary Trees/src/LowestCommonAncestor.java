import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    static boolean getPath(Main.TreeNode root, int n, List<Main.TreeNode> path){
        if(root == null) return false;

        path.add(root);

        if(root.data == n) return true;

        boolean leftPath = getPath(root.left,n,path);
        boolean rightPath = getPath(root.right,n,path);

        if (leftPath || rightPath) return true;

        path.removeLast();
        return false;
        
    }

    private static int LCA1(Main.TreeNode root, int n1, int n2){

        List<Main.TreeNode> path1  = new ArrayList<>();
        List<Main.TreeNode> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)) break;;
        }

        return path1.get(i - 1).data;

    }

    public static Main.TreeNode LCA2(Main.TreeNode root, int n1 , int n2){
        if(root == null ||root.data == n1 || root.data == n2){
            return root;
        }

        Main.TreeNode leftFind = LCA2(root.left,n1,n2);
        Main.TreeNode rightFind = LCA2(root.right,n1,n2);

        if(leftFind == null)  return rightFind;
        if (rightFind == null) return leftFind;

        return root;
    }

    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.left.left = new Main.TreeNode(4);
        root.left.right = new Main.TreeNode(5);
        root.right.left = new Main.TreeNode(6);
        root.right.right = new Main.TreeNode(7);

        int n1 = 4, n2 = 5;
        System.out.println(LCA1(root,n1,n2));
        System.out.println(LCA2(root,n1,n2).data);
    }
}
