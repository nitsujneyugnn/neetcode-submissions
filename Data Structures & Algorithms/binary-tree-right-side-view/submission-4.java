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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 1);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list, int h) {
        if (root != null) {
            if (list.size() < h) {
                list.add(root.val);
            }
            helper(root.right, list, h + 1);
            helper(root.left, list, h + 1);
        }
    }
}
