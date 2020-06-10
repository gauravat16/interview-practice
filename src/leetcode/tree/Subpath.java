package leetcode.tree;

import interviewbit.TreeNode;
import leetcode.ListNode;

public class Subpath {

    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head, root, head);
    }

    public boolean helper(ListNode head, TreeNode root, ListNode curr) {
        if(root == null){
            return false;
        }
        if(curr == null){
            return true;
        }

        if(curr.val == root.val){
            return helper(head, root.left, curr.next) || helper(curr.next, root.right, curr.next);
        }else{
            return helper(head, root.left, head) || helper(head, root.right, head);
        }

    }

    public static void main(String[] args) {

    }
}
