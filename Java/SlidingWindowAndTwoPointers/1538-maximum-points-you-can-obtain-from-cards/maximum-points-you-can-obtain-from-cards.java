class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0, maxSum=0;
        for(int i =0;i<=k-1;i++){
            leftSum += cardPoints[i];
            maxSum = leftSum;
        }
        int rind = cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rind];
            rind--;
            maxSum = Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
}