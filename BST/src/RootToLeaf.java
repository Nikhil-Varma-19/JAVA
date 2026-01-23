import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {
    static  void rootToLeaf(BST.TreeNode root, List<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        rootToLeaf(root.left,path);
        rootToLeaf(root.right,path);
        path.removeLast();

    }
    public static void main(String[] args) {
        int[] nums = {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums){
            root = BST.insertIntoBST(root,num);
        }

        rootToLeaf(root,new ArrayList<>());
    }
}
