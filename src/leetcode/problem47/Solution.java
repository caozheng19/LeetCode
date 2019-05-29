package leetcode.problem47;

import java.util.*;

/**
 * Created by caozheng on 2019/5/29.
 */
class Solution {
    public List<List<Integer>> outerList = new ArrayList<List<Integer>>();
    public List<Integer> innerList = new ArrayList<Integer>();
    public HashMap<String, Integer> map = new HashMap<String, Integer>();
    public Set<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        quanpailie(nums, 0);
        outerList = new ArrayList<>(set);
        return outerList;
    }

    public void quanpailie(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            if (start == nums.length - 1) {
//                 StringBuilder str = new StringBuilder("");
//                 for (int v : nums) {
//                     innerList.add(v);
//                     str.append(v);
//                 }
//                 System.out.println(str.toString());
//                 if (!map.containsKey(str.toString())) {
//                     outerList.add(new ArrayList<>(innerList));

//                     map.put(str.toString(), 0);
//                 }
//                 innerList.clear();
                for (int v : nums) {
                    innerList.add(v);
                }
                set.add(new ArrayList<>(innerList));//这个地方如果是set.add(innerList) 就会出错
                innerList.clear();
            }
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
            quanpailie(nums, start + 1);
            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

        }

    }
}
