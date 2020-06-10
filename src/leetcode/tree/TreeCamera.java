package leetcode.tree;

import interviewbit.TreeNode;

public class TreeCamera {

    enum State {
        MONITORED_BY_CAMERA, MONITORED_WITHOUT_CAMERA, NOT_MONITORED;
    }

    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        State state = helper(root);
        return (state == State.NOT_MONITORED || state == State.MONITORED_WITHOUT_CAMERA) ? ++cameras : cameras;
    }

    private State helper(TreeNode root) {
        if (root == null) {
            return State.MONITORED_WITHOUT_CAMERA;
        }

        State left = helper(root.left);
        State right = helper(root.right);

        if (left == State.NOT_MONITORED || right == State.NOT_MONITORED) {
            cameras++;
            return State.MONITORED_BY_CAMERA;
        }

        return (left == State.MONITORED_BY_CAMERA || right == State.MONITORED_BY_CAMERA) ? State.MONITORED_WITHOUT_CAMERA : State.NOT_MONITORED;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);
        treeNode.left.left.left.right = new TreeNode(5);


        System.out.println(new TreeCamera().minCameraCover(treeNode));

    }
}
