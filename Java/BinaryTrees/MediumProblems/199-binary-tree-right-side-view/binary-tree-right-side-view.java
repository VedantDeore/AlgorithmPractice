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
    private void right(TreeNode root, int level, List<Integer> ds){
        if(root == null){
            return;
        }

        if(level == ds.size()){
            ds.add(root.val);
        }

        if(root.right != null){
            right(root.right,level+1,ds);
        }
        if(root.left != null){
            right(root.left,level+1,ds);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
        right(root,0,ds);
        return ds;
    }
}