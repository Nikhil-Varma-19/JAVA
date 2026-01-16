public class MaxDis {
    private static int distanceFromNode(Main.TreeNode root,int n){
        if(root == null) return -1;

        if(root.data == n) return  0;

        int leftTree = distanceFromNode(root.left,n);
        int rightTree = distanceFromNode(root.right,n);

        if(leftTree == -1 && rightTree == -1) return -1;
        else if (leftTree == -1) return rightTree + 1;
        else return leftTree + 1;
    }
    static int minDistanceBtwNodes(Main.TreeNode root,int n1,int n2){
        Main.TreeNode lca = LowestCommonAncestor.LCA2(root,n1,n2);
        if(lca == null) return 0;
        int n1DistanceNode = distanceFromNode(lca,n1);
        int n2DistanceNode = distanceFromNode(lca,n2);
        return n1DistanceNode + n2DistanceNode;
    }
    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.left.left = new Main.TreeNode(4);
        root.left.right = new Main.TreeNode(5);
        root.right.left = new Main.TreeNode(6);
        root.right.right = new Main.TreeNode(7);

        int n1 = 4, n2 = 6;
        System.out.println(minDistanceBtwNodes(root,n1,n2));
    }
}
