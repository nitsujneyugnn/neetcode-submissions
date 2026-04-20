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
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        return invertTreeHelper(node);
    }

    private TreeNode invertTreeHelper(TreeNode node) {
        if (node == null) {
            return node;
        } else {
            TreeNode temp = node.left;
            node.left = invertTreeHelper(node.right);
            node.right = invertTreeHelper(temp);
        }
        return node;
    }
}
