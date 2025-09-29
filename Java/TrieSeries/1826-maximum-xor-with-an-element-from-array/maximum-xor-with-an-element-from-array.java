
class Node{
    Node links[] = new Node[2];

    public Node(){

    }

    boolean containsKey(int ind){
        return (links[ind] != null);
    }

    Node get(int ind){
        return links[ind];
    }

    void put(int ind, Node node){
        links[ind] = node;
    }
}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    public void insert(int num){
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num>>i) &1;

            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public int getMax(int num){
        Node node = root;

        int maxNum =0;

        for (int i = 31; i >=0; i--) {
            int bit = (num>>i)&1;

            if(node.containsKey(1 - bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1 - bit);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int offlineQueries[][] = new int[queries.length][3];
        int m = queries.length;
        for (int i = 0; i < queries.length; i++) {
            offlineQueries[i][0] = queries[i][0]; // xi
            offlineQueries[i][1] = queries[i][1]; // ai
            offlineQueries[i][2] = i; // index
        }

        Arrays.sort(offlineQueries, (a,b)-> a[1] - b[1]);

        int ind=0;
        Trie trie = new Trie();

        int ans[] = new int[queries.length];
        // Arrays.fill(ans, -1);

        for (int i = 0; i < m; i++) {
            while(ind < nums.length && nums[ind] <= offlineQueries[i][1]) {
                trie.insert(nums[ind]);
                ind++;
            }
            int queryIndex = offlineQueries[i][2];
            if(ind != 0){
                ans[queryIndex] = trie.getMax(offlineQueries[i][0]); 
            }else{
                ans[queryIndex] = -1;
            }
        }
        return ans;
    }
}