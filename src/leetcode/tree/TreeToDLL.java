package leetcode.tree;

import interviewbit.TreeNode;

public class TreeToDLL {

    TreeNode start, prev;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        helper(root);
        prev.right = start;
        start.left = prev;
        return start;

    }


    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (prev != null) {
            prev.right = root;
            root.left = prev;
        }else {
            start = root;
        }
        prev = root;

        helper(root.right);

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(5);

        System.out.println(new TreeToDLL().treeToDoublyList(treeNode));
    }
}
