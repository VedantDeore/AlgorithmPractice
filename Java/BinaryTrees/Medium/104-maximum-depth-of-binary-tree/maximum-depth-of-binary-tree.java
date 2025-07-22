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
    int height;
    public void max(TreeNode root, int curr){
        if(root==null)return;
        height = Math.max(curr,height);
        max(root.left, curr+1);
        max(root.right,curr+1);
    }
    public int maxDepth(TreeNode root) {
        max(root,1);
        return height;
    }
}