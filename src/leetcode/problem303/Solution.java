package leetcode.problem303;

class NumArray {
    int[] sum ;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums.length==0) return;
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] +=sum[i-1]+nums[i];
        }

    }

    public int sumRange(int i, int j) {
        return i==0?sum[j]:sum[j]-sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
