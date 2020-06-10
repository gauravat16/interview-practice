package leetcode.tree;

import interviewbit.TreeNode;

public class BSTFromPreOrder {

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int idx, int max) {
        if (idx >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);

        if (idx < preorder.length && root.val > preorder[idx]) {
            root.left = helper(preorder, idx, root.val);
        }

        for (int i = idx; i < preorder.length; i++) {
            if (max > preorder[i] && preorder[i] > root.val) {
                root.right = helper(preorder, i, max);
                break;
            }
        }
        return root;
    }
}
