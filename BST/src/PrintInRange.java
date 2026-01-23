import java.util.ArrayList;
import java.util.List;

public class PrintInRange {
    static List<Integer> printInRange(BST.TreeNode root, List<Integer> res,int k1 ,int k2){
        if(root == null) return res;

        if(root.data >= k1){
            printInRange(root.left,res,k1,k2);
        }
        if(k1 <= root.data && k2 >= root.data){
            res.add(root.data);
        }
        if(root.data <= k2){
            printInRange(root.right,res,k1,k2);
        }

        return res;

    }
    public static void main(String[] args) {
        int[] nums = {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums){
            root = BST.insertIntoBST(root,num);
        }
        List<Integer> res = new ArrayList<>();
        System.out.println(printInRange(root,res,3,6));

    }
}
