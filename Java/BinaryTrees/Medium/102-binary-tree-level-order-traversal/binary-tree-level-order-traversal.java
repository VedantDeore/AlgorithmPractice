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
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public void level(TreeNode node, int level){
        if(ans.size() == level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(node.val);
        if(node.left !=null)level(node.left, level+1);
        if(node.right!=null)level(node.right,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return ans;
        level(root,0);
        return ans;
    }
}