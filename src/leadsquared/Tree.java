package leadsquared;

import java.util.*;

public class Tree {



    public int[] decrypt(int[] input1, int[] input2, int input3) {
        rootIdx = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input1.length; i++) {
            map.put(input1[i], i);
        }
        TreeNode treeNode = helper(input1, input2, map, 0, input1.length - 1);

        if(treeNode == null){
            return new int[0];
        }

        int[] postOrder = new int[input3];
        List<Integer> list = new ArrayList<>();

        postOrder(treeNode, list);

        for (int i = 0; i < list.size(); i++) {
            postOrder[i] = list.get(i);
        }
        return postOrder;


    }

    int rootIdx = 0;

    private void postOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.left != null) {
            postOrder(treeNode.left, list);
        }



        if (treeNode.right != null) {
            postOrder(treeNode.right, list);
        }
        list.add(treeNode.val);

    }

    private TreeNode helper(int[] inorder, int[] preOrder, Map<Integer, Integer> inMap, int s, int e) {
        if (rootIdx >= preOrder.length || s < 0 || e < 0 || s > e) {
            return null;
        }

        int rootVal = preOrder[rootIdx++];
        int idx = inMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, preOrder, inMap, s, idx - 1);
        root.right = helper(inorder, preOrder, inMap, idx + 1, e);

        System.out.println(root.val);

        return root;

    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Tree().decrypt(new int[]{4, 2, 5, 1, 3}, new int[]{1, 2, 4, 5, 3}, 5)));
        System.out.println(Arrays.toString(new Tree().decrypt(new int[]{1}, new int[]{1}, 1)));

    }


}
