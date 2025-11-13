class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int totalSum = 0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        if(totalSum %2 != 0)return false;

        int k = totalSum/2;
        
        vector<char> prev(k+1,0);        
        prev[0] = true;
        if(nums[0] <= k){
            prev[nums[0]] = true;
        }

        for(int index=1;index<n;index++){
            vector<char> curr(k + 1, 0);
            for(int target= 1; target<=k ;target++){
                bool nottake = prev[target];
                bool take = false;
                if(target >= nums[index]){
                    take = prev[target - nums[index]];
                }

                curr[target] = (take || nottake);
            }
            prev = curr;
        }
        return prev[k];
    }
};