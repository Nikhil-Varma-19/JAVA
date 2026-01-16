import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

      static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildBinaryTree(int[] nodes) {
            idx++;
            // base case;
            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);

            return newNode;
        }

        public static void preOrder(TreeNode root) { // O(n)
            if (root == null) {
//                System.out.printf(-1 + " ");
                return;
            }
            System.out.printf(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(TreeNode root) { // O(n)
            if (root == null) {
                System.out.printf(-1 + " ");
                return;
            }

            inOrder(root.left);
            System.out.printf(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(TreeNode root) {
            if (root == null) {
                System.out.printf(-1 + " ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.printf(root.data + " ");
        }

        public static void levelOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            List<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {

                TreeNode currNode = queue.remove();
                if (currNode == null) {
                    System.out.println();
                    res.add(temp);
                    temp = new ArrayList<>();
                    if (queue.isEmpty()) break;
                    else queue.add(null);
                } else {
                    System.out.printf(currNode.data + " ");
                    temp.add(currNode.data);
                    if (currNode.left != null) queue.add(currNode.left);
                    if (currNode.right != null) queue.add(currNode.right);
                }
            }
            System.out.println(res);
        }

        public static int heightTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftH = heightTree(root.left);
            int rightH = heightTree(root.right);
            return Math.max(leftH, rightH) + 1;
        }

        public static int countNode(TreeNode root){
            if(root == null) return 0;

            int count1 = countNode(root.left);
            int count2 =countNode(root.right);

            return count1 + count2 + 1;

        }

        public static int sumOfNodes(TreeNode root){
            if(root == null) return 0;

            int leftSumNodes = sumOfNodes(root.left);
            int rightSumNodes = sumOfNodes(root.right);

            return leftSumNodes + rightSumNodes + root.data;

        }

        public static int diameterNode(TreeNode root){
            // Approach 1 O(n^2)
            if(root == null) return 0;

            int leftDiameter = diameterNode(root.left);
            int rightDiameter = diameterNode(root.right);
            int leftHeight = heightTree(root.left);
            int rightHeight = heightTree(root.right);

            return Math.max( leftHeight + rightHeight + 1 ,Math.max(leftDiameter,rightDiameter));
        }

        static class Info{
            int diameter;
            int height;

            Info(int diameter, int height){
                this.diameter = diameter;
                this.height = height;
            }
        }

        public static Info diameterNode2(TreeNode root){
            // Approach 1 O(n)
            if(root == null) return new Info(0,0);

            Info leftInfo = diameterNode2(root.left);
            Info rightInfo = diameterNode2(root.right);

            int diameter = Math.max(Math.max( leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
            int height = Math.max(leftInfo.height,rightInfo.height) + 1;

            return new Info(diameter,height);
        }


    }

    static class BinaryTreeStack {
        public static void preOrder(TreeNode root) {
            if (root == null) return;

            Stack<TreeNode> st = new Stack<>();

            st.add(root);

            while (!st.isEmpty()) {
                TreeNode node = st.pop();
                System.out.printf(node.data + " ");

                if (node.right != null) st.add(node.right);

                if (node.left != null) st.add(node.left);
            }

        }

        public static void inOrder(TreeNode root) {
            if (root == null) return;

            List<Integer> res = new ArrayList<>();

            Stack<TreeNode> st = new Stack<>();

            TreeNode curr = root;

            while (curr != null || !st.isEmpty()) {
                // go to leftest of the tree
                while (curr != null) {
                    st.add(curr);
                    curr = curr.left;
                }
                curr = st.pop();
                res.add(curr.data);
                curr = curr.right;

            }
//            Go left until you can’t, visit, then go right.
            System.out.println(res);
        }

        public static void levelOrder(TreeNode root){
            if(root == null) return ;

            List<List<Integer>> res =new ArrayList<>();

            Queue<TreeNode> qu = new LinkedList<>();

            qu.add(root);

            while (!qu.isEmpty()){
               int size = qu.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = qu.remove();
                    temp.add(node.data);
                    if(node.left != null) qu.add(node.left);
                    if(node.right != null) qu.add(node.right);
                }
                res.add(temp);
            }

            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        BinaryTree tree = new BinaryTree();
        TreeNode root = BinaryTree.buildBinaryTree(nums);
//        System.out.println(root.left.right.data);
//        BinaryTree.preOrder(root);
//        BinaryTree.inOrder(root);
//        BinaryTree.postOrder(root);
        BinaryTree.levelOrder(root);
//        int res = BinaryTree.heightTree(root);
//        int ans = BinaryTree.countNode(root);
//        System.out.println(BinaryTree.sumOfNodes(root));
//        System.out.println(BinaryTree.diameterNode(root));
//        System.out.println(BinaryTree.diameterNode2(root).height);


        // without rec
//        BinaryTreeStack.preOrder(root);
//        BinaryTreeStack.inOrder(root);
//        BinaryTreeStack.levelOrder(root);
    }


}