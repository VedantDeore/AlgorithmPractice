class Pair {
public:
    int first;
    int second;
    Pair(int first, int second) : first(first), second(second) {}
};
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<Pair>> adjList(n+1);

        for(auto element : times){
            int u = element[0];
            int v = element[1];
            int time = element[2];
            adjList[u].push_back({v,time});
        } 
        vector<int> dist(n+1,1e9);
        dist[k] = 0;
        dist[0] = 0;

        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> q;
        q.push({0,k});
        while(!q.empty()){
            auto current  = q.top();
            q.pop();

            int time = current.first;
            int node = current.second;

            for(auto& neighbour : adjList[node]){
                int adjNode = neighbour.first;
                int edgeWeight = neighbour.second;
                if(time + edgeWeight < dist[adjNode]){
                    dist[adjNode] = time + edgeWeight;
                    q.push({dist[adjNode], adjNode});
                }
            }
        }
        int mintime= 0;

        for(int i=0;i<= n;i++){
            if(dist[i] == 1e9)return -1;
            mintime = max(mintime, dist[i]);
        }
        return mintime;
    }
};