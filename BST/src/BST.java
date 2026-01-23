import java.util.List;

public class BST {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;

        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }

        if(root.data > data){
            // insert into left subtree
            root.left = insertIntoBST(root.left,data);
        }else {
            root.right = insertIntoBST(root.right,data);
        }

        return root;

    }
    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};

        TreeNode root = null;

        for(int num : values){
            root = insertIntoBST(root,num);
        }

        inOrderPrint(root);

    }

    public  static void inOrderPrint(TreeNode root){
        if(root == null) return;

        inOrderPrint(root.left);
        System.out.printf(root.data + " ");
        inOrderPrint(root.right);
    }

    public static void preOrderPrint(TreeNode root){
        if(root == null) return;
        System.out.printf(root.data+" ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public static void inOrderInArray(BST.TreeNode root, List<Integer> res){
        if(root == null) return;
        inOrderInArray(root.left,res);
        res.add(root.data);
        inOrderInArray(root.right,res);
    }
}