import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    private static Integer last;

    static  boolean isValidHelper(BST.TreeNode root){
        if(root == null) return true;

        boolean left = isValidHelper(root.left);

        if(!left) return false;

        if(last == null) last = root.data;
        else{
            if(root.data > last){

            }else{
                return false;
            }
            last = root.data;
        }

        boolean right = isValidHelper(root.right);

        return right;

    }

    static boolean isValidBST(BST.TreeNode root, BST.TreeNode min, BST.TreeNode max){
        if(root == null) return true;

        if(min != null && root.data <= min.data) return false;
        else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    static boolean inOrderApp(BST.TreeNode root){
        List<Integer> result = new ArrayList<>();
        BST.inOrderInArray(root,result);
        for (int i = 1; i < result.size() ; i++) {
            if(result.get(i) < result.get(i -1)) {
                return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        int[] nums = {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums){
            root = BST.insertIntoBST(root,num);
        }

        System.out.println("BST is valid: "+inOrderApp(root));
        System.out.println("BST is valid: "+isValidBST(root,null,null));
        last = null;
        System.out.println("BST is valid: "+isValidHelper(root));


    }

}
