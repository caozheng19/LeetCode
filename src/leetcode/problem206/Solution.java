package leetcode.problem206;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode pre = head;
        ListNode cen = head.next;
        ListNode behind = null;
        ListNode newHead = null;
        int flag =1;
        if(cen!=null){
            behind = cen.next;
        }
        if(cen==null){
            return head;
        }
        while(cen!=null){
            if(flag==1){
                pre.next = null;
                flag=0;
            }
            cen.next = pre;
            pre = cen;
            newHead = cen;
            cen = behind;
            if(behind!=null)
                behind = behind.next;
        }
        return newHead;
    }
}