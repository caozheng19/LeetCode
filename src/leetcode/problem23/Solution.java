package leetcode.problem23;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

/*
  关键在于对dis的理解 可以参考归并排序
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int listsLen = lists.length;
        if(listsLen==0) return null;
        while(listsLen>1){     //我一开始这里写listsLen>0会进入死循环
            int dis = (listsLen+1)/2;
            for(int i = 0;i<listsLen/2;i++){
                lists[i] = merge(lists[i],lists[i+dis]);
            }
            listsLen = dis;
        }
        return lists[0];
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode mergeList = new ListNode(0);
        ListNode originMergeList = mergeList;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                mergeList.next = l1;
                l1 = l1.next;
                mergeList = mergeList.next;
            }else{
                mergeList.next = l2;
                l2 = l2.next;
                mergeList = mergeList.next;
            }
        }
        if(l2==null){
            while(l1!=null){
                mergeList.next= l1;
                l1 = l1.next;
                mergeList = mergeList.next;
            }
        }
        if(l1==null){
            while(l2!=null){
                mergeList.next = l2;
                l2 = l2.next;
                mergeList = mergeList.next;
            }
        }
        return originMergeList.next;
    }
}