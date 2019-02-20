package leetcode.problem35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = erfensearch(nums,target,0,nums.length-1);
        return index;
    }
    public int erfensearch(int[] nums,int target,int left,int right){
        System.out.println("left:  "+left+"right:  "+right);
        if(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                return erfensearch(nums,target,left,mid-1);
            }else{
                return erfensearch(nums,target,mid+1,right);
            }

        }
        if(left>right){
            return left;
        }
        return -1;
    }
}