import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SubTree {

    static boolean isSubTree(Main.TreeNode root,Main.TreeNode subroot){
        //  T.C O(n×m)  S.C : O(n)
        if(root == null) return false;

        if(root.data == subroot.data && isIdentical(root,subroot)) return true;

        boolean leftSubAns = isSubTree(root.left,subroot);
        boolean rightSubAns = isSubTree(root.right,subroot);
        return  leftSubAns || rightSubAns;
    }

    private static boolean isIdentical(Main.TreeNode root, Main.TreeNode subroot) {
        if( root == null && subroot == null) return true;
        if (root == null || subroot == null || subroot.data != root.data) return false;
        return isIdentical(root.left,subroot.left) && isIdentical(root.right,subroot.right);
     }


     private static void preOrder(Main.TreeNode root, List<Integer> res){
        if(root == null) {
            res.add(null);
            return;
        }
        res.add(root.data);
        preOrder(root.left,res);
        preOrder(root.right,res);
     }

     private static boolean iterationApp(Main.TreeNode root, Main.TreeNode subRoot){
        if(root == null || subRoot == null) return false;

        List<Integer> rootArray = new ArrayList<>();
        List<Integer> subRootArray = new ArrayList<>();

        preOrder(root,rootArray);
         System.out.println(rootArray);
        preOrder(subRoot,subRootArray);
         System.out.println(subRootArray);
         boolean res = false;
//         for (int i = 0; i < rootArray.size() - subRootArray.size(); i++) {
//                int j ;
//                for( j = 0; j < subRootArray.size(); j++){
//                    if(rootArray.get(i+j) != subRootArray.get(j)){
//                        break;
//                    }
//                }
//                if(j == subRootArray.size())  res = true;
//         }
         int i = 0, j = 0;
         while ( i < rootArray.size() && j < subRootArray.size()){
             if(rootArray.get(i) != subRootArray.get(j)){
                 j = 0;
             }else {
                 j++;
             }
             i++;

         }


        return j == subRootArray.size() ;
     }

    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.right.right = new Main.TreeNode(6);
        root.left.left = new Main.TreeNode(4);
        root.right.left = new Main.TreeNode(10);
        root.right.left.left = new Main.TreeNode(2);
        root.right.left.left.left = new Main.TreeNode(4);
        root.right.left.left.right = new Main.TreeNode(5);


        Main.TreeNode subRoot = new Main.TreeNode(2);
        subRoot.left = new Main.TreeNode(4);
        subRoot.right = new Main.TreeNode(5);


        System.out.println(isSubTree(root,subRoot));
        System.out.println(iterationApp(root,subRoot));

    }
}
