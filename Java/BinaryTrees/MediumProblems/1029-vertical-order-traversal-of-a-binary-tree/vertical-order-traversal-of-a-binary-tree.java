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
    class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap <Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0,0));

        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int x = curr.row;
            int y = curr.col;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}