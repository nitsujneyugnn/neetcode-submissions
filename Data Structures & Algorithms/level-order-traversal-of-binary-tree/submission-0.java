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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderHelper(root, list, 0);
        return list;
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> list, int h) {
        if (root != null) {
            if (list.size() < h + 1) {
                list.add(new ArrayList<>());
            }
            list.get(h).add(root.val);

            levelOrderHelper(root.left, list, h + 1);
            levelOrderHelper(root.right, list, h + 1);
        }
    }

}
