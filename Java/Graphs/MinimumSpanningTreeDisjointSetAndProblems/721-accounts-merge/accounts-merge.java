class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node){
        if(node == parent.get(node))return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp); 
        return ulp;      
    }     
    public void UnionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));

        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    ds.UnionBySize(i, map.get(mail));
                }
            }
        }

        ArrayList<List<String>> mergedEmails = new ArrayList<>();
        for (int i = 0; i < n; i++) mergedEmails.add(new ArrayList<>());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int parent = ds.findUParent(entry.getValue());
            mergedEmails.get(parent).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedEmails.get(i).isEmpty()) continue;

            Collections.sort(mergedEmails.get(i));

            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0)); 
            account.addAll(mergedEmails.get(i));

            ans.add(account);
        }

        return ans;
    }
}