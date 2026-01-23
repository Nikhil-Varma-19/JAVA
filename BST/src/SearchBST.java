public class SearchBST {

    static boolean search(BST.TreeNode root, int key){
        if(root == null) return false;

        if(root.data == key) return  true;


        if(root.data > key){
            return search(root.left,key);
        }else {
            return search(root.right,key);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3,4,2,7};
        int key = 6;
        BST.TreeNode root = null;

        for(int num : nums){
            root = BST.insertIntoBST(root,num);
        }

        System.out.println(search(root,key));
    }
}
