package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class AllElem {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        inorder(root1, l1);
        inorder(root2, l2);
        List<Integer> l3 = new ArrayList<>();

        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                l3.add(l1.get(i++));
            } else {
                l3.add(l2.get(j++));
            }
        }

        while (i < l1.size()) {
            l3.add(l1.get(i++));
        }
        while (j < l2.size()) {
            l3.add(l2.get(j++));
        }

        return l3;
    }

    void helper(TreeNode root1, TreeNode root2, List<Integer> list) {
        if (root1 == null && root2 == null) {
            return;
        }

        if (root1 == null) {
            inorder(root2, list);
            return;
        }

        if (root2 == null) {
            inorder(root1, list);
            return;
        }

        if (root1.val < root2.val) {
            inorder(root1.left, list);
            list.add(root1.val);
            helper(root1.right, root2.left, list);
            list.add(root2.val);
        } else {
            inorder(root2.left, list);
            list.add(root2.val);
            helper(root1.left, root2.right, list);
            list.add(root1.val);
        }

    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        treeNode1.right = new TreeNode(59);
        treeNode1.right.left = new TreeNode(57);
        treeNode1.right.right = new TreeNode(90);

        TreeNode treeNode2 = new TreeNode(60);
        treeNode2.left = new TreeNode(17);
        treeNode2.right = new TreeNode(74);
        treeNode2.left.left = new TreeNode(6);
        treeNode2.left.right = new TreeNode(20);
        treeNode2.right.left = new TreeNode(63);
        treeNode2.right.right = new TreeNode(97);
        treeNode2.right.right.left = new TreeNode(95);

        System.out.println(new AllElem().getAllElements(treeNode1, treeNode2));


    }


}
