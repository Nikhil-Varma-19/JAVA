public class MirrorBST {
    static BST.TreeNode mirrorBST(BST.TreeNode root){
        if(root == null) return null;

        BST.TreeNode leftSubTree = mirrorBST(root.left);
        BST.TreeNode rightSubTree = mirrorBST(root.right);

        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }
    public static void main(String[] args) {
        int[] nums = {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums){
            root = BST.insertIntoBST(root,num);
        }

        BST.preOrderPrint(root);
        System.out.println();

        BST.TreeNode res = mirrorBST(root);
        BST.preOrderPrint(root);


    }

}
