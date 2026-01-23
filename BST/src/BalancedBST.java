import java.util.ArrayList;
import java.util.List;

public class BalancedBST {
    static BST.TreeNode createBalancedBST(int[] nums,int start,int end){
        // balance mean equal no of node in left and right subtree
        if(start > end) return null;

        int mid = start + (end - start)/2;

        BST.TreeNode root = new BST.TreeNode(nums[mid]);
        root.left = createBalancedBST(nums,start,mid-1);
        root.right = createBalancedBST(nums,mid+1,end);
        return root;
    }

    static BST.TreeNode convertBSTToBalancedBST(BST.TreeNode root){
        List<Integer> nums = new ArrayList<>();
        // tree sorted into array
        BST.inOrderInArray(root,nums);
        int[] res = new int[nums.size()];
        for (int i = 0; i <nums.size(); i++) {
                    res[i] = nums.get(i);
        }
        return createBalancedBST(res,0,res.length -1);
    }
    public static void main(String[] args) {
        int[] nums1 = {3,5,6,8,10,11,12};

        BST.TreeNode result = createBalancedBST(nums1,0,nums1.length -1);
        BST.preOrderPrint(result);
        System.out.println();

//        Convert BST to Balanced BST

        int[] nums2= {8,5,3,1,4,6,10,11,14};

        BST.TreeNode root = null;

        for (int num : nums2){
            root = BST.insertIntoBST(root,num);
        }

        BST.TreeNode res = convertBSTToBalancedBST(root);

        BST.preOrderPrint(res);
        System.out.println();
        BST.inOrderPrint(res);

    }
}
