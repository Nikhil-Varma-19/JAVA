public class AVL {

    private static class TreeNode{
            int data, height;
            TreeNode left, right;

            TreeNode(int data){
                this.height = 1;
                this.data = data;
            }
    }

    private static TreeNode root ;

    private static int height(TreeNode root){
        if(root == null) return  0;
        return root.height;
    }

    private static int getBalance(TreeNode root){
        if (root == null) return 0;
        return height(root.left) - height(root.right);
    }


    public static TreeNode insert(TreeNode root, int key){
        if(root == null) return new TreeNode(key);

        if(root.data > key){
            root.left = insert(root.left,key);
        } else if (root.data < key) {
            root.right = insert(root.right,key);
        }else return root;

        // updated the height of node
        root.height = 1 + Math.max(height(root.left),height(root.right));

        // get root balance
        int bf = getBalance(root);


        // Case LL (Left Left)
        if(bf > 1 && key < root.left.data) return rightRotate(root);

        // Case RR (Right Right)
        if(bf < -1 && key > root.right.data) return leftRotate(root);

        // Case LR (Left Right)
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Case RL (Right Left)
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private static TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode z = y.left; // x.right.left

        // rotated
        y.left = x;
        x.right = z;

        // update height
        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;

        return y;
    }

    private static TreeNode rightRotate(TreeNode x) {
        TreeNode y = x.left;
        TreeNode z = y.right;

        // rotated
        y.right = x;
        x.left = z;

        x.height = Math.max(height(x.left),height(x.right)) + 1;
        y.height = Math.max(height(y.left),height(y.right)) + 1;

        return y;
    }

    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrderAVL(root);

    }

    private static void preOrderAVL(TreeNode root){
        if(root == null) return;
        System.out.printf(root.data+ " ");
        preOrderAVL(root.left);
        preOrderAVL(root.right);
    }
}