package interviewbit;

public class PathSum {

    public int hasPathSum(TreeNode root, int target) {

        int val = target - root.val;
        if(root.left==null && root.right==null && val == 0){
            return 1;
        }

        int l = 0, r =0;
        if(root.left != null){
            hasPathSum(root.left, val);
        }

        if(root.right != null){
            hasPathSum(root.right,val);
        }

        return (l==1 || r ==1)? 1 : 0;
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

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1000);
        t1.left = new TreeNode(2000);
        t1.left.left = new TreeNode(-3001);

        System.out.println(new PathSum().hasPathSum(t1, -1));
    }
}