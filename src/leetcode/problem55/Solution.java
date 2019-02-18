package leetcode.problem55;

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            //下标和当前下标对应的值（可以前进的步数）相加如果大于下一步的下标 说明可以到达 如此逆推即可
            if(i+nums[i]>=n){
                n=i;
            }
        }
        if(n==0) return true;
        return false;
    }
}