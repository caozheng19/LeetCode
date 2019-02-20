package leetcode.problem704;

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int index = erfensearch(nums,target,0,nums.length-1);
        return index;
    }
    public int erfensearch(int[] nums,int target,int left,int right){
        if(left<=right){
            int mid = (left+right)/2;
            if(target==nums[mid]){
                return mid;
            }else if(nums[mid]>target){
                return erfensearch(nums,target,left,mid-1);
            }else{
                return erfensearch(nums,target,mid+1,right);
            }
        }
        return -1;
    }
}