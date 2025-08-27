class Solution {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];

        for(int i=0;i<m;i++){
            int temp[] = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j] = 1;
                }else{
                    int up=0;
                    int down=0;
                    if(i>0) up = prev[j];
                    if(j>0) down = temp[j-1];

                    temp[j] = up + down;
                }
            }
            prev = temp;
        }

        return prev[n-1];
    }
}