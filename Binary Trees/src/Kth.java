import java.util.*;

public class Kth {

    private static List<Integer> kthLevel(Main.TreeNode root,int k){
        Queue<Main.TreeNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);

        int count = k - 1;

        while (!qu.isEmpty() && count != 0){
            Main.TreeNode curr = qu.remove();
            if(curr == null){
                if(qu.isEmpty()) break;
                else {
                    qu.add(null);
                    count--;
                }
            }else {
                if(curr.left != null) qu.add(curr.left);
                if(curr.right != null) qu.add(curr.right);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!qu.isEmpty()){
            Main.TreeNode curr = qu.remove();
            if(curr == null) break;
            res.add(curr.data);
        }

        return res;

    }

    private static void kthLevelR(Main.TreeNode root , int k,int level,List<Integer> res){
      if(root == null) return;
        if(level == k){
            res.add(root.data);
            return;
        }
        kthLevelR(root.left,k,level+1,res);
        kthLevelR(root.right,k,level+1,res);
    }

    private static void kthLevelR(Main.TreeNode root , int k ,List<Integer> res){
        if(root == null) return;
        if( k == 0){
           res.add(root.data);
            return;
        }
        kthLevelR(root.left,k-1,res);
        kthLevelR(root.right,k-1,res);
    }

    private static boolean findPath(Main.TreeNode root, int node, List<Integer> res){
        if(root == null) return false;
        res.add(root.data);
        if(root.data == node) return true;
        boolean leftNodeFound = findPath(root.left,node,res);
        boolean rightNodeFound = findPath(root.right,node,res);
        if(leftNodeFound || rightNodeFound) return  true;
        else {
            res.removeLast();
            return false;
        }
    }

    private static int KthAncestorNodeBF(Main.TreeNode root,int k, int node){
        List<Integer> res = new ArrayList<>();
         boolean findPath = findPath(root,node,res);
         if(!findPath) return -1;
         int index = res.size() - k;
        return  res.get(index - 1);
    }

    static int ans = -1;

    static int KthAncestorBackTracking(Main.TreeNode root, int k, int node){
        if(root == null) return  -1;
        if(root.data == node) return  0;

        int leftDis = KthAncestorBackTracking(root.left,k,node);
        int rightDis = KthAncestorBackTracking(root.right,k,node);

        int valid = Math.max(leftDis,rightDis);
         if(valid + 1 == k) {
             ans = root.data;
         };
         return valid + 1;
    }

    static int kthAncestorStack(Main.TreeNode root, int k, int node) {
        if (root == null) return -1;

        Stack<Main.TreeNode> st = new Stack<>();
        Main.TreeNode curr = root, lastVisited = null;

        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                if (curr.data == node) break;
                curr = curr.left;
            } else {
                Main.TreeNode peek = st.peek();
                if (peek.right != null && peek.right != lastVisited) {
                    curr = peek.right;
                } else {
                    lastVisited = st.pop();
                }
            }
        }

        if (st.isEmpty()) return -1; // node not found

        // Remove node itself
        st.pop();

        while (k-- > 1 && !st.isEmpty()) {
            st.pop();
        }

        return st.isEmpty() ? -1 : st.peek().data;
    }



    public static void main(String[] args) {
        Main.TreeNode root = new Main.TreeNode(1);
        root.left = new Main.TreeNode(2);
        root.right = new Main.TreeNode(3);
        root.left.left = new Main.TreeNode(4);
        root.left.right = new Main.TreeNode(5);
        root.right.left = new Main.TreeNode(6);
        root.right.right = new Main.TreeNode(7);
        root.left.right.left = new Main.TreeNode(8);

//        Print the Kth level of Node

//        int k = 3;

//        System.out.println(kthLevel(root,k));

//        List<Integer> res = new ArrayList<>();
//        kthLevelR(root,k ,1,res);
//        kthLevelR(root,k-1,res);
//        System.out.println(res);

//        O/p K th ancestor of node

        int k = 2, node = 8;
        System.out.println(KthAncestorNodeBF(root,k,node));
        KthAncestorBackTracking(root,k,node);
        System.out.println(ans);
        System.out.println(kthAncestorStack(root,k,node));







    }

}
