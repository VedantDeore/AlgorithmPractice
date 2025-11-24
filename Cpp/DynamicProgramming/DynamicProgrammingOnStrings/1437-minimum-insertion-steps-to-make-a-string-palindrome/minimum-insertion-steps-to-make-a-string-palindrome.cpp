class Solution {
public:
    int minInsertions(string s) {
        string s2 = s;
        reverse(s2.begin(), s2.end());
        int n = s.length();
        vector<int> prev(n+1);
        int ans=0;
        for(int i=1;i<=n;i++){
            vector<int> curr(n+1);
            for(int j=1;j<=n;j++){
                if(s[i-1] == s2[j-1]){
                    curr[j] = 1 + prev[j-1];
                    ans = max(ans, curr[j]);
                }else{
                    curr[j] = max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }
        return n-ans;
    }
};