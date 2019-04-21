package leetcode.problem322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins,0,coins.length);
        int[][] B = new int[coins.length+1][amount+1];
        for (int i = 1; i < amount+1; i++) {
            B[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length+1; i++) {
            B[i][0] = 0;
        }
        for(int i =1;i<coins.length+1;i++){
            for(int j =1;j<amount+1;j++){
                if(coins[i-1]>j){
                    B[i][j] = B[i-1][j];
                }else{
                    int k = j / coins[i-1];
                    for(int m = 0;m<=k;m++){
                        int value1 = B[i-1][j-coins[i-1]] + 1;
                        int value2 = B[i-1][j];
                        B[i][j] = Math.min(value1,value2);
                    }
                }
            }
        }

        System.out.println(B[coins.length][amount]);
        if(B[coins.length][amount]!=0) return B[coins.length][amount];
        return -1;


    }
}
