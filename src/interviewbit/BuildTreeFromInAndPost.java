package interviewbit;

import java.util.*;

public class BuildTreeFromInAndPost {

    int rootIdx = 0;

    public TreeNode buildTree(List<Integer> A, List<Integer> B) {

        rootIdx = B.size() - 1;

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            idxMap.put(A.get(i), i);
        }

        return helper(A, B, idxMap, 0, A.size() - 1);
    }

    private TreeNode helper(List<Integer> A, List<Integer> B, Map<Integer, Integer> idxMap, int s, int e) {
        if (s > e || rootIdx < 0) {
            return null;
        }
        TreeNode root = new TreeNode(B.get(rootIdx));
        rootIdx--;

        int index = idxMap.get(root.val);
        root.right = helper(A, B, idxMap, index + 1, e);
        root.left = helper(A, B, idxMap, s, index - 1);

        return root;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }

    void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new BuildTreeFromInAndPost().buildTree(Arrays.asList(1, 2, 5, 6, 7, 9, 8, 10, 15, 20, 25), Arrays.asList(1, 5, 2, 7, 8, 9, 6, 15, 25, 20, 10));

        List<Integer> data = new ArrayList<>();
        new BuildTreeFromInAndPost().inorder(root, data);
        System.out.println(data);
        data.clear();

        new BuildTreeFromInAndPost().postOrder(root, data);
        System.out.println(data);


    }
}
