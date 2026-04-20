/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int val = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return val;
    }

    private void helper(TreeNode root, int k) {
        if (root == null || count == k) {
            return;
        }  else {
            helper(root.left, k);
            count++;
            if (k == count) {
                val = root.val;
            }
            helper(root.right, k);
        }
    }
}
