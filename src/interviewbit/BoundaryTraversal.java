package interviewbit;

import java.util.ArrayList;

public class BoundaryTraversal {

    public ArrayList<Integer> solve(PathSum.TreeNode A) {

        ArrayList<Integer> traversal = new ArrayList<>();
        traversal.add(A.val);
        edges(A.left, traversal, true);
        leaves(A.left, traversal);
        leaves(A.right, traversal);
        edges(A.right, traversal, false);

        return traversal;
    }

    private void edges(PathSum.TreeNode root, ArrayList<Integer> traversal, boolean isLeft){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            return;
        }

        traversal.add(root.val);
        if(isLeft){
            edges(root.left, traversal, isLeft);
        }else{
            edges(root.right, traversal, isLeft);
        }

    }

    private void leaves(PathSum.TreeNode root, ArrayList<Integer> traversal){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            traversal.add(root.val);
            return;
        }

        leaves(root.left, traversal);

        leaves(root.right, traversal);

    }
}
