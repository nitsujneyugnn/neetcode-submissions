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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        return maxDepthHelper(node, 0);
    }

    private int maxDepthHelper(TreeNode node, int count) {
        if (node == null) {
            return count;
        } else {
            int leftCount = maxDepthHelper(node.left, count + 1);
            int rightCount = maxDepthHelper(node.right, count + 1);

            if (leftCount > rightCount) {
                return leftCount;
            } else {
                return rightCount;
            }
        }
    }
}
