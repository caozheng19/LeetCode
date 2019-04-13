package leetcode.problem122;

class Solution {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxVal = maxVal - prices[i-1] + prices[i];
            }
        }
        return maxVal;
    }
}
