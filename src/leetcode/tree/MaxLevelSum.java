package leetcode.tree;

import interviewbit.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int max = root.val;
        int level = 1, maxLevel = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode node = q.poll();

            int sum = 0;

            for (int i = 0; i < size; i++) {
                if (node.left != null) {
                    sum += node.left.val;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    sum += node.right.val;
                    q.offer(node.right);
                }
            }
            level++;

            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
        }

        return maxLevel;

    }
}
