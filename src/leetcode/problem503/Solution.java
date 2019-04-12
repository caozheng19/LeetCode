package leetcode.problem503;

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> map  =new HashMap<Integer,Integer>();
        for(int i = 0;i<2*nums.length;i++){
            int curVal = nums[i%nums.length];
            while(!stack.isEmpty()&&nums[stack.peek()%nums.length]<curVal){
                map.put(stack.pop(),curVal);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        int[] res = new int[nums.length];
        int idx1 = 0;
        int idx2 = 0;
        for(int v : nums){
            res[idx1] = map.get(idx2);
            idx1++;
            idx2++;
        }

        return res;
    }
}
