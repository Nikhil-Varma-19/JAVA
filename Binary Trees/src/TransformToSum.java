public class TransformToSum {
    static  int transformToSumSubTree(Main.TreeNode root){
        if(root == null) return 0;
        int leftSum = transformToSumSubTree(root.left);
        int rightSum = transformToSumSubTree(root.right);
        int data = root.data;
        root.data = leftSum + rightSum ;
        if(root.left != null) root.data += root.left.data;
        if(root.right != null) root.data += root.right.data;
        return data;
    }

    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.left.left = new Main.TreeNode(4);
        root.left.right = new Main.TreeNode(5);
        root.right.left = new Main.TreeNode(6);
        root.right.right = new Main.TreeNode(7);
//        root.left.right.left = new Main.TreeNode(8);

        transformToSumSubTree(root);
        Main.BinaryTree.preOrder(root);
    }
}
