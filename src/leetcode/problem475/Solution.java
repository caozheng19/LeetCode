package leetcode.problem475;

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int housesLen = houses.length;
        int heatersLen = heaters.length;
        int minDis = Integer.MIN_VALUE;
        for(int i = 0;i<houses.length;i++){
            int j = 0;
            while((j<heatersLen-1)&&(Math.abs(houses[i]-heaters[j])>=Math.abs(houses[i]-heaters[j+1]))){
                j++;
            }
            minDis = Math.max(Math.abs(houses[i]-heaters[j]),minDis);
        }
        return minDis;
    }
}
