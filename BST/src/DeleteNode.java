public class DeleteNode {

    static BST.TreeNode delete(BST.TreeNode root, int val){
        if(root == null) return null;
        if(root.data > val){
            root.left = delete(root.left,val);
        } else if (root.data < val) {
            root.right = delete(root.right,val);
        }else {
            // All cases

//            Case 1: leaf node
            if(root.left == null && root.right == null){
                return  null;
            }

//            Case 2: One Child

            if(root.left == null) return root.right;
            else if (root.right == null) return root.left;

//            Case 3: Two Child
            BST.TreeNode inOrderSuc = findInorderSuccessor(root.right);
            root.data = inOrderSuc.data;
            root.right = delete(root.right, inOrderSuc.data);
        }
        return root;
    }

    private static BST.TreeNode findInorderSuccessor(BST.TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int[] nums = {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums){
            root = BST.insertIntoBST(root,num);
        }

        BST.inOrderPrint(root);
        System.out.println(); 

        int deleteNode = 10;
        delete(root,deleteNode);

        BST.inOrderPrint(root);
        System.out.println();



    }
}
