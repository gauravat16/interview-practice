package interviewbit;

public class FlattenBinaryTree {

    public TreeNode flatten(TreeNode a) {
        helper(a);
        return a;
    }


    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            left.right = temp;
            return right;
        }

        if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            return left;
        }

        if (root.left == null && root.right != null) {
            return right;
        }

        return root;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right =  new TreeNode(6);

        System.out.println(new FlattenBinaryTree().flatten(treeNode));
    }
}
