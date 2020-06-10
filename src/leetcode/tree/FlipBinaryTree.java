package leetcode.tree;

import interviewbit.TreeNode;

public class FlipBinaryTree {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        boolean condition1 = (root1.left == null && root2.left != null) || (root2.left == null && root1.left != null);
        boolean condition2 = (root1.left != null && root2.left != null) && root1.left.val != root2.left.val;
        if (condition1 || condition2) {
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }

        if (((root1.left != null && root2.left != null) && root1.left.val != root2.left.val) ||
                ((root1.right != null && root2.right != null) && root1.right.val != root2.right.val))
            return false;

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

    }

    private void preOrder(TreeNode treeNode){
        if(treeNode == null) return;
        preOrder(treeNode.left);
        preOrder(treeNode.right);
        System.out.print(treeNode.val+",");

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.left.right = new TreeNode(6);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        new FlipBinaryTree().preOrder(root1);
        System.out.println();
       new FlipBinaryTree().preOrder(root2);

        System.out.println(new FlipBinaryTree().flipEquiv(root1, root2));
    }
}
