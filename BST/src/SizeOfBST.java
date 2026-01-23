public class SizeOfBST {
    static  int ans = 0;
    static  class BSTInfo{
        boolean isBST;
        int size;
        int min;
        int max;

        public BSTInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }



    static BSTInfo sizeOfLargestBST(BST.TreeNode root){
        if(root == null) {
            return new BSTInfo(true,0,0,0);
        }
        if(root.left == null && root.right == null){
            ans = Math.max(ans,1);
            return new BSTInfo(true,1,root.data,root.data);
        }

        BSTInfo leftInfo = sizeOfLargestBST(root.left);
        BSTInfo rightInfo = sizeOfLargestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(leftInfo.min, Math.min(rightInfo.min, root.data));
        int max = Math.max(leftInfo.max, Math.max(rightInfo.max, root.data));

        if(leftInfo.max > root.data || rightInfo.min < root.data) return new BSTInfo(false,size,min,max);
        ans = Math.max(ans,size);
        return new BSTInfo(true,size,min,max);
    }

    public static void main(String[] args) {
        BST.TreeNode root = new BST.TreeNode(50);
        root.left = new BST.TreeNode(30);
        root.right = new BST.TreeNode(60);
        root.left.left = new BST.TreeNode(5);
        root.left.right = new BST.TreeNode(20);
        root.right.left =new BST.TreeNode(45);
        root.right.right = new BST.TreeNode(70);
        root.right.right.left = new BST.TreeNode(65);
        root.right.right.right = new BST.TreeNode(80);
        root.right.right.right.left = new BST.TreeNode(75);
        root.right.right.right.right = new BST.TreeNode(90);

        sizeOfLargestBST(root);
        System.out.println(ans);
    }
}
