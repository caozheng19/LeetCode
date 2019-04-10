package leetcode.problem416;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int cap = sum/2;
        int [][] B = new int[nums.length][cap+1];
        for(int i = 0;i<cap;i++){
            if(i>=nums[0]){
                B[0][i]=nums[0];
            }
        }
        for(int k=1;k<nums.length;k++){
            for(int c = 1;c<=cap;c++){
                if(nums[k]>c){
                    B[k][c]=B[k-1][c];
                }else{
                    int v1 = B[k-1][c-nums[k]]+nums[k];
                    int v2 = B[k-1][c];
                    if(v1>v2){
                        B[k][c] = v1;
                    }else{
                        B[k][c] = v2;
                    }
                }
            }
        }
        boolean res = B[nums.length-1][cap]==cap?true:false;
        System.out.println(res);
        return res;
    }

}