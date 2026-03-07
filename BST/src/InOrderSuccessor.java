public class InOrderSuccessor {

    private static BST.TreeNode previous;
    private static BST.TreeNode successor;

    private static void inOrderSuccessorHelper(BST.TreeNode root, BST.TreeNode p){
            if(root == null) return;

            // left
        inOrderSuccessorHelper(root.left,p);
            // process
        if( previous != null && p.data == previous.data  && successor == null){
            successor = root;
        }
        previous = root;
            // right
        inOrderSuccessorHelper(root.right,p);

    }

    static BST.TreeNode inOrderSuccessor(BST.TreeNode root, BST.TreeNode p){

//        T.C : O(n) and S.C : O(n)
        if(p.right != null){
            BST.TreeNode curr = p.right;

            while( curr.left != null){
                curr = curr.left;
            }

            return curr;

        }else {
      // root does not have a right subtree
            inOrderSuccessorHelper(root,p);

            return successor;
        }
    }
    public static void main(String[] args) {
       BST.TreeNode root = new BST.TreeNode(2);
       root.left = new BST.TreeNode(1);
       root.right = new BST.TreeNode(3);

       BST.TreeNode p = new BST.TreeNode(1);

       BST.TreeNode ans = inOrderSuccessor(root,p);
        System.out.println(ans.data);

    }
}
