package leetcode.problem347;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //使用hashmao来统计每个元素出现了多少次
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int v = map.get(nums[i]);
                map.put(nums[i], v + 1);
            }
        }
        //初始化一个大小为k的数组

        int[] arr = new int[k];
        /*
            求最大topK用小顶堆
            求最小topK用大顶堆
            这里将数组初始化为小顶堆
        */
        sort(arr);
        /*
            将小顶堆每个元素初始化为0后插入统计的元素的频率
            如果元素出现的频率大于堆中的最小值
            将堆顶元素替换为元素的频率
            然后不断自上而下调整堆
        */
        for (Integer v : map.keySet()) {
            if (map.get(v) > arr[0])
                swap(arr, 0, map.get(v));
            adjust(arr, 0, arr.length);
        }
        //用来存储返回值
        List<Integer> list = new ArrayList<Integer>();
        //map的迭代器
        Iterator iter = map.entrySet().iterator();
        for (int i = k - 1; i >= 0; i--) {
            iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if ((Integer) entry.getValue() == arr[i]) {
                    list.add((Integer) entry.getKey());
                    Integer key = (Integer) entry.getKey();
                    //当测试用例是[1,2]
                    //           2
                    //如果不移除会出现输出[1,2,1,2]
                    iter.remove();
                }
            }

        }
        return list;
    }

    //自下而上调整
    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
    }

    //自上而下调整
    public void adjust(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] > arr[k + 1]) {
                k++;
            }
            if (arr[k] < temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    //交换元素值
    public void swap(int[] arr, int a, int b) {
        arr[0] = b;
    }
}