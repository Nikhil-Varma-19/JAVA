import java.util.ArrayList;
import java.util.List;

public class MergeBST {


    static BST.TreeNode mergeBST(BST.TreeNode bst_1, BST.TreeNode bst_2){
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        BST.inOrderInArray(bst_1,arr1);
        BST.inOrderInArray(bst_2,arr2);

        List<Integer> array = new ArrayList<>();

        int i = 0, j = 0;

        while ( i < arr1.size() && j < arr2.size() ){
            if(arr1.get(i) > arr2.get(j)){
                array.add(arr2.get(j));
                j++;
            }else {
                array.add(arr1.get(i));
                i++;
            }
        }
        while ( i < arr1.size()) {
            array.add(arr1.get(i));
            i++;
        }
        while ( j < arr2.size()) {
            array.add(arr2.get(j));
            j++;
        }

        return createBST(array,0,array.size() - 1);
    }

    private static BST.TreeNode createBST(List<Integer> nums, int start, int end){
        if(start > end) return null;

        int mid = (start + end) /2;

        BST.TreeNode root = new BST.TreeNode(nums.get(mid));
        root.left = createBST(nums,start,mid -1);
        root.right = createBST(nums,mid + 1,end);
        return root;
    }

    public static void main(String[] args) {
        BST.TreeNode root1 = new BST.TreeNode(2);
        root1.left = new BST.TreeNode(1);
        root1.right = new BST.TreeNode(4);

        BST.TreeNode root2 = new BST.TreeNode(9);
        root2.left = new BST.TreeNode(3);
        root2.right = new BST.TreeNode(12);

        BST.TreeNode root = mergeBST(root1,root2);

        BST.preOrderPrint(root);

    }
}
