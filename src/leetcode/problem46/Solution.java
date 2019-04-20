package leetcode.problem46;


import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> outerList = new ArrayList<List<Integer>>();
    List<Integer> innerList = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0) return outerList;
        quanpailie(nums,0);
        return outerList;
    }

    public void quanpailie(int[] nums,int start){
        if(start==nums.length-1){
            List<Integer> list = new ArrayList<Integer>();
            for(int v : nums){
                list.add(v);
            }
            outerList.add(list);
        }

        for(int i = start;i<nums.length;i++){
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            quanpailie(nums,start+1);
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }
}