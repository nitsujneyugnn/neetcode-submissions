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
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)[0] == 1;
    }

    // int[0] represents if a previous subtreees are balanced already.
    // int[1] represents the height
    private int[] isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = isBalancedHelper(root.left);
        int[] right = isBalancedHelper(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) // Checks for subtrees
        && (Math.abs(left[1] - right[1]) <= 1); // Check for current node

        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }
}
