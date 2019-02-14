package leetcode.problem21;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeListHead = new ListNode(0);
        ListNode mergeCurrentNode = mergeListHead;
        ListNode l1CurrentNode = l1;
        ListNode l2CurrentNode = l2;
        while(l1CurrentNode!=null&&l2CurrentNode!=null){
            if(l1CurrentNode.val<=l2CurrentNode.val){
                mergeCurrentNode.next = l1CurrentNode;
                l1CurrentNode = l1CurrentNode.next;
            }else{
                mergeCurrentNode.next = l2CurrentNode;
                l2CurrentNode = l2CurrentNode.next;
            }
            mergeCurrentNode = mergeCurrentNode.next;
            mergeCurrentNode.next = null;
        }
        if(l2CurrentNode==null){
            while(l1CurrentNode!=null){
                mergeCurrentNode.next = l1CurrentNode;
                l1CurrentNode = l1CurrentNode.next;
                mergeCurrentNode =  mergeCurrentNode.next;
            }
        }
        if(l1CurrentNode==null){
            while(l2CurrentNode!=null){
                mergeCurrentNode.next = l2CurrentNode;
                l2CurrentNode = l2CurrentNode.next;
                mergeCurrentNode =  mergeCurrentNode.next;
            }
        }
        return mergeListHead.next;
    }
}
